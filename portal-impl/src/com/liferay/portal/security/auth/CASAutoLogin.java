/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ldap.PortalLDAPImporterUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 * @author Wesley Gong
 * @author Daeyoung Song
 */
public class CASAutoLogin implements AutoLogin {

	@Override
	public String[] login(
		HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String[] credentials = null;

		try {
			long companyId = PortalUtil.getCompanyId(request);

			if (!PrefsPropsUtil.getBoolean(
					companyId, PropsKeys.CAS_AUTH_ENABLED,
					PropsValues.CAS_AUTH_ENABLED)) {

				return credentials;
			}

			String login = (String)session.getAttribute(WebKeys.CAS_LOGIN);

			if (Validator.isNull(login)) {
				Object noSuchUserException = session.getAttribute(
					WebKeys.CAS_NO_SUCH_USER_EXCEPTION);

				if (noSuchUserException == null) {
					return credentials;
				}

				session.removeAttribute(WebKeys.CAS_NO_SUCH_USER_EXCEPTION);

				session.setAttribute(WebKeys.CAS_FORCE_LOGOUT, Boolean.TRUE);

				String redirect = PrefsPropsUtil.getString(
					companyId, PropsKeys.CAS_NO_SUCH_USER_REDIRECT_URL,
					PropsValues.CAS_NO_SUCH_USER_REDIRECT_URL);

				request.setAttribute(AutoLogin.AUTO_LOGIN_REDIRECT, redirect);

				return credentials;
			}

			String authType = PrefsPropsUtil.getString(
				companyId, PropsKeys.COMPANY_SECURITY_AUTH_TYPE,
				PropsValues.COMPANY_SECURITY_AUTH_TYPE);

			User user = null;

			if (PrefsPropsUtil.getBoolean(
					companyId, PropsKeys.CAS_IMPORT_FROM_LDAP,
					PropsValues.CAS_IMPORT_FROM_LDAP)) {

				try {
					if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						user = PortalLDAPImporterUtil.importLDAPUser(
							companyId, StringPool.BLANK, login);
					}
					else {
						user = PortalLDAPImporterUtil.importLDAPUser(
							companyId, login, StringPool.BLANK);
					}
				}
				catch (SystemException se) {
				}
			}

			if (user == null) {
				if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
					user = UserLocalServiceUtil.getUserByScreenName(
						companyId, login);
				}
				else {
					user = UserLocalServiceUtil.getUserByEmailAddress(
						companyId, login);
				}
			}

			String redirect = ParamUtil.getString(request, "redirect");

			if (Validator.isNotNull(redirect)) {
				request.setAttribute(
					AutoLogin.AUTO_LOGIN_REDIRECT_AND_CONTINUE, redirect);
			}

			credentials = new String[3];

			credentials[0] = String.valueOf(user.getUserId());
			credentials[1] = user.getPassword();
			credentials[2] = Boolean.TRUE.toString();

			return credentials;
		}
		catch (NoSuchUserException nsue) {
			session.removeAttribute(WebKeys.CAS_LOGIN);

			session.setAttribute(
				WebKeys.CAS_NO_SUCH_USER_EXCEPTION, Boolean.TRUE);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return credentials;
	}

	/**
	 * @deprecated Use <code>importLDAPUser</code>.
	 */
	protected User addUser(long companyId, String screenName) throws Exception {
		return PortalLDAPImporterUtil.importLDAPUser(
			companyId, StringPool.BLANK, screenName);
	}

	private static Log _log = LogFactoryUtil.getLog(CASAutoLogin.class);

}