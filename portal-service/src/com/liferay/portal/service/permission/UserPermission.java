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

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Charles May
 */
public interface UserPermission {

	/**
	 * @deprecated
	 */
	public void check(
			PermissionChecker permissionChecker, long userId,
			long organizationId, long locationId, String actionId)
		throws PrincipalException;

	public void check(
			PermissionChecker permissionChecker, long userId,
			long[] organizationIds, String actionId)
		throws PrincipalException;

	public void check(
			PermissionChecker permissionChecker, long userId, String actionId)
		throws PrincipalException;

	/**
	 * @deprecated
	 */
	public boolean contains(
		PermissionChecker permissionChecker, long userId, long organizationId,
		long locationId, String actionId);

	public boolean contains(
		PermissionChecker permissionChecker, long userId,
		long[] organizationIds, String actionId);

	public boolean contains(
		PermissionChecker permissionChecker, long userId, String actionId);

	public boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Group group, Role role,
			User user)
		throws PortalException, SystemException;

	public boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Group group, User user)
		throws PortalException, SystemException;

	public boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Organization organization,
			Role role, User user)
		throws SystemException;

	public boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Organization organization,
			User user)
		throws PortalException, SystemException;

}