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

package com.liferay.portal.velocity;

import com.liferay.portal.kernel.audit.AuditMessageFactoryUtil;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UnicodeLanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ArrayUtil_IW;
import com.liferay.portal.kernel.util.DateUtil_IW;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.GetterUtil_IW;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil_IW;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Randomizer_IW;
import com.liferay.portal.kernel.util.StaticFieldGetter;
import com.liferay.portal.kernel.util.StringUtil_IW;
import com.liferay.portal.kernel.util.TimeZoneUtil_IW;
import com.liferay.portal.kernel.util.UnicodeFormatter_IW;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.Validator_IW;
import com.liferay.portal.kernel.velocity.VelocityContext;
import com.liferay.portal.kernel.velocity.VelocityVariables;
import com.liferay.portal.kernel.xml.SAXReader;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Theme;
import com.liferay.portal.service.permission.AccountPermissionUtil;
import com.liferay.portal.service.permission.CommonPermissionUtil;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portal.service.permission.LayoutPermissionUtil;
import com.liferay.portal.service.permission.OrganizationPermissionUtil;
import com.liferay.portal.service.permission.PasswordPolicyPermissionUtil;
import com.liferay.portal.service.permission.PortalPermissionUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.service.permission.RolePermissionUtil;
import com.liferay.portal.service.permission.UserGroupPermissionUtil;
import com.liferay.portal.service.permission.UserPermissionUtil;
import com.liferay.portal.theme.NavItem;
import com.liferay.portal.theme.RequestVars;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SessionClicks_IW;
import com.liferay.portal.util.WebKeys;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.expando.service.ExpandoColumnLocalService;
import com.liferay.portlet.expando.service.ExpandoRowLocalService;
import com.liferay.portlet.expando.service.ExpandoTableLocalService;
import com.liferay.portlet.expando.service.ExpandoValueLocalService;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.taglib.util.VelocityTaglibImpl;
import com.liferay.util.portlet.PortletRequestUtil;

import java.lang.reflect.Method;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.taglib.tiles.ComponentConstants;
import org.apache.struts.tiles.ComponentContext;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.EscapeTool;
import org.apache.velocity.tools.generic.IteratorTool;
import org.apache.velocity.tools.generic.ListTool;
import org.apache.velocity.tools.generic.MathTool;
import org.apache.velocity.tools.generic.NumberTool;
import org.apache.velocity.tools.generic.SortTool;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class VelocityVariablesImpl implements VelocityVariables {

	@Override
	public void insertHelperUtilities(
		VelocityContext velocityContext, String[] restrictedVariables) {

		// Array util

		velocityContext.put("arrayUtil", ArrayUtil_IW.getInstance());

		// Audit message factory

		try {
			velocityContext.put(
				"auditMessageFactoryUtil",
				AuditMessageFactoryUtil.getAuditMessageFactory());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Audit router util

		try {
			velocityContext.put(
				"auditRouterUtil", AuditRouterUtil.getAuditRouter());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Browser sniffer

		try {
			velocityContext.put(
				"browserSniffer", BrowserSnifferUtil.getBrowserSniffer());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Date format

		try {
			velocityContext.put(
				"dateFormatFactory",
				FastDateFormatFactoryUtil.getFastDateFormatFactory());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Date tool

		velocityContext.put("dateTool", new DateTool());

		// Date util

		velocityContext.put("dateUtil", DateUtil_IW.getInstance());

		// Escape tool

		velocityContext.put("escapeTool", new EscapeTool());

		// Service locator

		try {
			ServiceLocator serviceLocator = ServiceLocator.getInstance();

			insertHelperUtility(
				velocityContext, restrictedVariables, "serviceLocator",
				serviceLocator);

			// Expando column service

			try {
				velocityContext.put(
					"expandoColumnLocalService",
					serviceLocator.findService(
						ExpandoColumnLocalService.class.getName()));
			}
			catch (SecurityException se) {
				_log.error(se, se);
			}

			// Expando row service

			try {
				velocityContext.put(
					"expandoRowLocalService",
					serviceLocator.findService(
						ExpandoRowLocalService.class.getName()));
			}
			catch (SecurityException se) {
				_log.error(se, se);
			}

			// Expando table service

			try {
				velocityContext.put(
					"expandoTableLocalService",
					serviceLocator.findService(
						ExpandoTableLocalService.class.getName()));
			}
			catch (SecurityException se) {
				_log.error(se, se);
			}

			// Expando value service

			try {
				velocityContext.put(
					"expandoValueLocalService",
					serviceLocator.findService(
						ExpandoValueLocalService.class.getName()));
			}
			catch (SecurityException se) {
				_log.error(se, se);
			}
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Getter util

		velocityContext.put("getterUtil", GetterUtil_IW.getInstance());

		// Html util

		try {
			velocityContext.put("htmlUtil", HtmlUtil.getHtml());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Http util

		try {
			velocityContext.put("httpUtil", HttpUtil.getHttp());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Iterator tool

		velocityContext.put("iteratorTool", new IteratorTool());

		// Journal content util

		try {
			velocityContext.put(
				"journalContentUtil", JournalContentUtil.getJournalContent());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// JSON factory util

		try {
			velocityContext.put(
				"jsonFactoryUtil", JSONFactoryUtil.getJSONFactory());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Language util

		try {
			velocityContext.put("languageUtil", LanguageUtil.getLanguage());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"unicodeLanguageUtil",
				UnicodeLanguageUtil.getUnicodeLanguage());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// List tool

		velocityContext.put("listTool", new ListTool());

		// Locale util

		try {
			velocityContext.put("localeUtil", LocaleUtil.getInstance());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Math tool

		velocityContext.put("mathTool", new MathTool());

		// Number tool

		velocityContext.put("numberTool", new NumberTool());

		// Param util

		velocityContext.put("paramUtil", ParamUtil_IW.getInstance());

		// Portal util

		try {
			insertHelperUtility(
				velocityContext, restrictedVariables, "portalUtil",
				PortalUtil.getPortal());
			insertHelperUtility(
				velocityContext, restrictedVariables, "portal",
				PortalUtil.getPortal());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Prefs props util

		try {
			insertHelperUtility(
				velocityContext, restrictedVariables, "prefsPropsUtil",
				PrefsPropsUtil.getPrefsProps());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Props util

		try {
			insertHelperUtility(
				velocityContext, restrictedVariables, "propsUtil",
				PropsUtil.getProps());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Portlet URL factory

		try {
			velocityContext.put(
				"portletURLFactory",
				PortletURLFactoryUtil.getPortletURLFactory());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Portlet preferences

		insertHelperUtility(
			velocityContext, restrictedVariables, "velocityPortletPreferences",
			new VelocityPortletPreferences());

		// Randomizer

		velocityContext.put(
			"randomizer", Randomizer_IW.getInstance().getWrappedInstance());

		// Util locator

		try {
			UtilLocator utilLocator = UtilLocator.getInstance();

			insertHelperUtility(
				velocityContext, restrictedVariables, "utilLocator",
				utilLocator);

			// SAX reader util

			try {
				velocityContext.put(
					"saxReaderUtil",
					utilLocator.findUtil(SAXReader.class.getName()));
			}
			catch (SecurityException se) {
				_log.error(se, se);
			}
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Session clicks

		try {
			insertHelperUtility(
				velocityContext, restrictedVariables, "sessionClicks",
				SessionClicks_IW.getInstance());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Sort tool

		velocityContext.put("sortTool", new SortTool());

		// Static field getter

		velocityContext.put(
			"staticFieldGetter", StaticFieldGetter.getInstance());

		// String util

		velocityContext.put("stringUtil", StringUtil_IW.getInstance());

		// Time zone util

		velocityContext.put("timeZoneUtil", TimeZoneUtil_IW.getInstance());

		// Unicode formatter

		velocityContext.put(
			"unicodeFormatter", UnicodeFormatter_IW.getInstance());

		// Validator

		velocityContext.put("validator", Validator_IW.getInstance());

		// VelocityTaglib methods

		try {
			Class<?> clazz = VelocityTaglibImpl.class;

			Method method = clazz.getMethod(
				"layoutIcon", new Class[] {Layout.class});

			velocityContext.put("velocityTaglib#layoutIcon", method);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		// Web server servlet token

		try {
			velocityContext.put(
				"webServerToken",
				WebServerServletTokenUtil.getWebServerServletToken());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Permissions

		try {
			velocityContext.put(
				"accountPermission",
				AccountPermissionUtil.getAccountPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"commonPermission", CommonPermissionUtil.getCommonPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"groupPermission", GroupPermissionUtil.getGroupPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"layoutPermission", LayoutPermissionUtil.getLayoutPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"organizationPermission",
				OrganizationPermissionUtil.getOrganizationPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"passwordPolicyPermission",
				PasswordPolicyPermissionUtil.getPasswordPolicyPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"portalPermission", PortalPermissionUtil.getPortalPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"portletPermission",
				PortletPermissionUtil.getPortletPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"rolePermission", RolePermissionUtil.getRolePermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"userGroupPermission",
				UserGroupPermissionUtil.getUserGroupPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"userPermission", UserPermissionUtil.getUserPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		// Deprecated

		try {
			velocityContext.put(
				"dateFormats",
				FastDateFormatFactoryUtil.getFastDateFormatFactory());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"imageToken",
				WebServerServletTokenUtil.getWebServerServletToken());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}

		try {
			velocityContext.put(
				"locationPermission",
				OrganizationPermissionUtil.getOrganizationPermission());
		}
		catch (SecurityException se) {
			_log.error(se, se);
		}
	}

	@Override
	public void insertVariables(
			VelocityContext velocityContext, HttpServletRequest request)
		throws Exception {

		// Request

		velocityContext.put("request", request);

		// Portlet config

		PortletConfig portletConfig = (PortletConfig)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_CONFIG);

		if (portletConfig != null) {
			velocityContext.put("portletConfig", portletConfig);
		}

		// Render request

		final PortletRequest portletRequest =
			(PortletRequest)request.getAttribute(
				JavaConstants.JAVAX_PORTLET_REQUEST);

		if (portletRequest != null) {
			if (portletRequest instanceof RenderRequest) {
				velocityContext.put("renderRequest", portletRequest);
			}
		}

		// Render response

		final PortletResponse portletResponse =
			(PortletResponse)request.getAttribute(
				JavaConstants.JAVAX_PORTLET_RESPONSE);

		if (portletResponse != null) {
			if (portletResponse instanceof RenderResponse) {
				velocityContext.put("renderResponse", portletResponse);
			}
		}

		// XML request

		if ((portletRequest != null) && (portletResponse != null)) {
			velocityContext.put(
				"xmlRequest",
				new Object() {

					@Override
					public String toString() {
						return PortletRequestUtil.toXML(
							portletRequest, portletResponse);
					}

				}
			);
		}

		// Theme display

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (themeDisplay != null) {
			Layout layout = themeDisplay.getLayout();
			List<Layout> layouts = themeDisplay.getLayouts();

			velocityContext.put("themeDisplay", themeDisplay);
			velocityContext.put("company", themeDisplay.getCompany());
			velocityContext.put("user", themeDisplay.getUser());
			velocityContext.put("realUser", themeDisplay.getRealUser());
			velocityContext.put("layout", layout);
			velocityContext.put("layouts", layouts);
			velocityContext.put("plid", String.valueOf(themeDisplay.getPlid()));
			velocityContext.put(
				"layoutTypePortlet", themeDisplay.getLayoutTypePortlet());
			velocityContext.put(
				"scopeGroupId", new Long(themeDisplay.getScopeGroupId()));
			velocityContext.put(
				"permissionChecker", themeDisplay.getPermissionChecker());
			velocityContext.put("locale", themeDisplay.getLocale());
			velocityContext.put("timeZone", themeDisplay.getTimeZone());
			velocityContext.put("colorScheme", themeDisplay.getColorScheme());
			velocityContext.put(
				"portletDisplay", themeDisplay.getPortletDisplay());

			// Navigation items

			if (layout != null) {
				RequestVars requestVars = new RequestVars(
					request, themeDisplay, layout.getAncestorPlid(),
					layout.getAncestorLayoutId(), velocityContext);

				List<NavItem> navItems = NavItem.fromLayouts(
					requestVars, layouts);

				velocityContext.put("navItems", navItems);
			}

			// Init

			velocityContext.put(
				"init",
				themeDisplay.getPathContext() +
					VelocityResourceListener.SERVLET_SEPARATOR +
						"/html/themes/_unstyled/templates/init.vm");

			// Deprecated

			velocityContext.put(
				"portletGroupId", new Long(themeDisplay.getScopeGroupId()));
		}

		// Theme

		Theme theme = (Theme)request.getAttribute(WebKeys.THEME);

		if ((theme == null) && (themeDisplay != null)) {
			theme = themeDisplay.getTheme();
		}

		if (theme != null) {

			// Full css and templates path

			velocityContext.put("theme", theme);

			String servletContextName = GetterUtil.getString(
				theme.getServletContextName());

			velocityContext.put(
				"fullCssPath",
				servletContextName + theme.getVelocityResourceListener() +
					theme.getCssPath());

			velocityContext.put(
				"fullTemplatesPath",
				servletContextName + theme.getVelocityResourceListener() +
					theme.getTemplatesPath());
		}

		// Tiles attributes

		insertTilesVariables(velocityContext, request);

		// Page title and subtitle

		velocityContext.put(
			"pageTitle", request.getAttribute(WebKeys.PAGE_TITLE));
		velocityContext.put(
			"pageSubtitle", request.getAttribute(WebKeys.PAGE_SUBTITLE));

		// Insert custom vm variables

		Map<String, Object> vmVariables =
			(Map<String, Object>)request.getAttribute(WebKeys.VM_VARIABLES);

		if (vmVariables != null) {
			for (Map.Entry<String, Object> entry : vmVariables.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();

				if (Validator.isNotNull(key)) {
					velocityContext.put(key, value);
				}
			}
		}
	}

	protected void insertHelperUtility(
		VelocityContext velocityContext, String[] restrictedVariables,
		String key, Object value) {

		if (!ArrayUtil.contains(restrictedVariables, key)) {
			velocityContext.put(key, value);
		}
	}

	protected void insertTilesVariables(
		VelocityContext velocityContext, HttpServletRequest request) {

		ComponentContext componentContext =
			(ComponentContext)request.getAttribute(
				ComponentConstants.COMPONENT_CONTEXT);

		if (componentContext == null) {
			return;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String tilesTitle = (String)componentContext.getAttribute("title");

		themeDisplay.setTilesTitle(tilesTitle);

		velocityContext.put("tilesTitle", tilesTitle);

		String tilesContent = (String)componentContext.getAttribute("content");

		themeDisplay.setTilesContent(tilesContent);

		velocityContext.put("tilesContent", tilesContent);

		boolean tilesSelectable = GetterUtil.getBoolean(
			(String)componentContext.getAttribute("selectable"));

		themeDisplay.setTilesSelectable(tilesSelectable);

		velocityContext.put("tilesSelectable", tilesSelectable);
	}

	private static Log _log = LogFactoryUtil.getLog(
		VelocityVariablesImpl.class);

}