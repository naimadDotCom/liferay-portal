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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link ResourceLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ResourceLocalService
 * @generated
 */
public class ResourceLocalServiceWrapper implements ResourceLocalService,
	ServiceWrapper<ResourceLocalService> {
	public ResourceLocalServiceWrapper(
		ResourceLocalService resourceLocalService) {
		_resourceLocalService = resourceLocalService;
	}

	/**
	* Adds the resource to the database. Also notifies the appropriate model listeners.
	*
	* @param resource the resource
	* @return the resource that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Resource addResource(
		com.liferay.portal.model.Resource resource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.addResource(resource);
	}

	/**
	* Creates a new resource with the primary key. Does not add the resource to the database.
	*
	* @param resourceId the primary key for the new resource
	* @return the new resource
	*/
	public com.liferay.portal.model.Resource createResource(long resourceId) {
		return _resourceLocalService.createResource(resourceId);
	}

	/**
	* Deletes the resource with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resourceId the primary key of the resource
	* @return the resource that was removed
	* @throws PortalException if a resource with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Resource deleteResource(long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.deleteResource(resourceId);
	}

	/**
	* Deletes the resource from the database. Also notifies the appropriate model listeners.
	*
	* @param resource the resource
	* @return the resource that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Resource deleteResource(
		com.liferay.portal.model.Resource resource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.deleteResource(resource);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resourceLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.portal.model.Resource fetchResource(long resourceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.fetchResource(resourceId);
	}

	/**
	* Returns the resource with the primary key.
	*
	* @param resourceId the primary key of the resource
	* @return the resource
	* @throws PortalException if a resource with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Resource getResource(long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.getResource(resourceId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the resources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resources
	* @param end the upper bound of the range of resources (not inclusive)
	* @return the range of resources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Resource> getResources(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.getResources(start, end);
	}

	/**
	* Returns the number of resources.
	*
	* @return the number of resources
	* @throws SystemException if a system exception occurred
	*/
	public int getResourcesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.getResourcesCount();
	}

	/**
	* Updates the resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resource the resource
	* @return the resource that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Resource updateResource(
		com.liferay.portal.model.Resource resource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.updateResource(resource);
	}

	/**
	* Updates the resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resource the resource
	* @param merge whether to merge the resource with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the resource that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Resource updateResource(
		com.liferay.portal.model.Resource resource, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.updateResource(resource, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _resourceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_resourceLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Adds resources for the model, always creating a resource at the
	* individual scope and only creating resources at the group, group
	* template, and company scope if such resources don't already exist.
	*
	* <ol>
	* <li>
	* If the service context specifies that default group or default guest
	* permissions are to be added, then only default permissions are added. See
	* {@link com.liferay.portal.service.ServiceContext#setAddGroupPermissions(
	* boolean)} and {@link
	* com.liferay.portal.service.ServiceContext#setAddGuestPermissions(
	* boolean)}.
	* </li>
	* <li>
	* Else ...
	* <ol>
	* <li>
	* If the service context specifies to derive default permissions, then
	* default group and guest permissions are derived from the model and
	* added. See {@link
	* com.liferay.portal.service.ServiceContext#setDeriveDefaultPermissions(
	* boolean)}.
	* </li>
	* <li>
	* Lastly group and guest permissions from the service
	* context are applied. See {@link
	* com.liferay.portal.service.ServiceContext#setGroupPermissions(String[])}
	* and {@link
	* com.liferay.portal.service.ServiceContext#setGuesPermissions(String[])}.
	* </li>
	* </ol>
	*
	* </li>
	* </ol>
	*
	* @param auditedModel the model to associate with the resources
	* @param serviceContext the service context to apply. Can set whether to
	add the model's default group and guest permissions, set whether
	to derive default group and guest permissions from the model, set
	group permissions to apply, and set guest permissions to apply.
	* @throws PortalException if no portal actions could be found associated
	with the model or if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void addModelResources(
		com.liferay.portal.model.AuditedModel auditedModel,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.addModelResources(auditedModel, serviceContext);
	}

	/**
	* Adds resources for the model with the name and primary key, always
	* creating a resource at the individual scope and only creating resources
	* at the group, group template, and company scope if such resources don't
	* already exist.
	*
	* @param companyId the primary key of the portal instance
	* @param groupId the primary key of the group
	* @param userId the primary key of the user adding the resources
	* @param name a name for the resource, typically the model's class name
	* @param primKey the primary key of the model instance, optionally
	<code>0</code> if no instance exists
	* @param groupPermissions the group permissions to be applied
	* @param guestPermissions the guest permissions to be applied
	* @throws PortalException if no portal actions could be found associated
	with the model or if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void addModelResources(long companyId, long groupId, long userId,
		java.lang.String name, long primKey,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.addModelResources(companyId, groupId, userId,
			name, primKey, groupPermissions, guestPermissions);
	}

	/**
	* Adds resources for the model with the name and primary key string, always
	* creating a resource at the individual scope and only creating resources
	* at the group, group template, and company scope if such resources don't
	* already exist.
	*
	* @param companyId the primary key of the portal instance
	* @param groupId the primary key of the group
	* @param userId the primary key of the user adding the resources
	* @param name a name for the resource, typically the model's class name
	* @param primKey the primary key string of the model instance, optionally
	an empty string if no instance exists
	* @param groupPermissions the group permissions to be applied
	* @param guestPermissions the guest permissions to be applied
	* @throws PortalException if no portal actions could be found associated
	with the model or if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void addModelResources(long companyId, long groupId, long userId,
		java.lang.String name, java.lang.String primKey,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.addModelResources(companyId, groupId, userId,
			name, primKey, groupPermissions, guestPermissions);
	}

	public com.liferay.portal.model.Resource addResource(long companyId,
		java.lang.String name, int scope, java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.addResource(companyId, name, scope, primKey);
	}

	/**
	* Adds resources for the entity with the name and primary key, always
	* creating a resource at the individual scope and only creating resources
	* at the group, group template, and company scope if such resources don't
	* already exist.
	*
	* @param companyId the primary key of the portal instance
	* @param groupId the primary key of the group
	* @param userId the primary key of the user adding the resources
	* @param name a name for the resource, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param primKey the primary key of the resource instance, optionally
	<code>0</code> if no instance exists
	* @param portletActions whether to associate portlet actions with the
	resource
	* @param addGroupPermissions whether to add group permissions
	* @param addGuestPermissions whether to add guest permissions
	* @throws PortalException if no portal actions could be found associated
	with the resource or if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void addResources(long companyId, long groupId, long userId,
		java.lang.String name, long primKey, boolean portletActions,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.addResources(companyId, groupId, userId, name,
			primKey, portletActions, addGroupPermissions, addGuestPermissions);
	}

	/**
	* Adds resources for the entity with the name and primary key string,
	* always creating a resource at the individual scope and only creating
	* resources at the group, group template, and company scope if such
	* resources don't already exist.
	*
	* @param companyId the primary key of the portal instance
	* @param groupId the primary key of the group
	* @param userId the primary key of the user adding the resources
	* @param name a name for the resource, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param primKey the primary key string of the resource instance,
	optionally an empty string if no instance exists
	* @param portletActions whether to associate portlet actions with the
	resource
	* @param addGroupPermissions whether to add group permissions
	* @param addGuestPermissions whether to add guest permissions
	* @throws PortalException if no portal actions could be found associated
	with the resource or if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void addResources(long companyId, long groupId, long userId,
		java.lang.String name, java.lang.String primKey,
		boolean portletActions, boolean addGroupPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.addResources(companyId, groupId, userId, name,
			primKey, portletActions, addGroupPermissions, addGuestPermissions);
	}

	/**
	* Adds resources for the entity with the name. Use this method if the user
	* is unknown or irrelevant and there is no current entity instance.
	*
	* @param companyId the primary key of the portal instance
	* @param groupId the primary key of the group
	* @param name a name for the resource, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param portletActions whether to associate portlet actions with the
	resource
	* @throws PortalException if no portal actions could be found associated
	with the resource or if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void addResources(long companyId, long groupId,
		java.lang.String name, boolean portletActions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.addResources(companyId, groupId, name,
			portletActions);
	}

	/**
	* Deletes the resource associated with the model at the scope.
	*
	* @param auditedModel the model associated with the resource
	* @param scope the scope of the resource. For more information see {@link
	com.liferay.portal.model.ResourceConstants}.
	* @throws PortalException if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void deleteResource(
		com.liferay.portal.model.AuditedModel auditedModel, int scope)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.deleteResource(auditedModel, scope);
	}

	/**
	* Deletes the resource matching the primary key at the scope.
	*
	* @param companyId the primary key of the portal instance
	* @param name the resource's name, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param scope the scope of the resource. For more information see {@link
	com.liferay.portal.model.ResourceConstants}.
	* @param primKey the primary key of the resource instance
	* @throws PortalException if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void deleteResource(long companyId, java.lang.String name,
		int scope, long primKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.deleteResource(companyId, name, scope, primKey);
	}

	/**
	* Deletes the resource matching the primary key at the scope.
	*
	* @param companyId the primary key of the portal instance
	* @param name the resource's name, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param scope the scope of the resource. For more information see {@link
	com.liferay.portal.model.ResourceConstants}.
	* @param primKey the primary key string of the resource instance
	* @throws PortalException if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void deleteResource(long companyId, java.lang.String name,
		int scope, java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.deleteResource(companyId, name, scope, primKey);
	}

	public void deleteResources(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.deleteResources(name);
	}

	public com.liferay.portal.model.Resource fetchResource(long companyId,
		java.lang.String name, int scope, java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.fetchResource(companyId, name, scope,
			primKey);
	}

	public long getLatestResourceId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.getLatestResourceId();
	}

	/**
	* Returns a new resource with the name and primary key at the scope.
	*
	* @param companyId the primary key of the portal instance
	* @param name a name for the resource, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param scope the scope of the resource. For more information see {@link
	com.liferay.portal.model.ResourceConstants}.
	* @param primKey the primary key string of the resource
	* @return the new resource
	* @throws PortalException if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Resource getResource(long companyId,
		java.lang.String name, int scope, java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.getResource(companyId, name, scope, primKey);
	}

	public java.util.List<com.liferay.portal.model.Resource> getResources()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceLocalService.getResources();
	}

	/**
	* Updates the resources for the model, replacing their group and guest
	* permissions with new ones from the service context.
	*
	* @param auditedModel the model associated with the resources
	* @param serviceContext the service context to be applied. Can set group
	and guest permissions.
	* @throws PortalException if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void updateModelResources(
		com.liferay.portal.model.AuditedModel auditedModel,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.updateModelResources(auditedModel, serviceContext);
	}

	/**
	* Updates resources matching the group, name, and primary key at the
	* individual scope, setting new group and guest permissions.
	*
	* @param companyId the primary key of the portal instance
	* @param groupId the primary key of the group
	* @param name the resource's name, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param primKey the primary key of the resource instance
	* @param groupPermissions the group permissions to be applied
	* @param guestPermissions the guest permissions to be applied
	* @throws PortalException if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void updateResources(long companyId, long groupId,
		java.lang.String name, long primKey,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.updateResources(companyId, groupId, name,
			primKey, groupPermissions, guestPermissions);
	}

	/**
	* Updates resources matching the group, name, and primary key string at the
	* individual scope, setting new group and guest permissions.
	*
	* @param companyId the primary key of the portal instance
	* @param groupId the primary key of the group
	* @param name the resource's name, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param primKey the primary key string of the resource instance
	* @param groupPermissions the group permissions to be applied
	* @param guestPermissions the guest permissions to be applied
	* @throws PortalException if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void updateResources(long companyId, long groupId,
		java.lang.String name, java.lang.String primKey,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.updateResources(companyId, groupId, name,
			primKey, groupPermissions, guestPermissions);
	}

	/**
	* Updates resources matching the name, primary key string and scope,
	* replacing the primary key of their resource permissions with the new
	* primary key.
	*
	* @param companyId the primary key of the portal instance
	* @param name the resource's name, which should be a portlet ID if the
	resource is a portlet or the resource's class name otherwise
	* @param scope the scope of the resource. For more information see {@link
	com.liferay.portal.model.ResourceConstants}.
	* @param primKey the primary key string of the resource instance
	* @param newPrimKey the new primary key string of the resource
	* @throws PortalException if a portal exception occurred
	* @throws SystemException if a system exception occurred
	*/
	public void updateResources(long companyId, java.lang.String name,
		int scope, java.lang.String primKey, java.lang.String newPrimKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceLocalService.updateResources(companyId, name, scope, primKey,
			newPrimKey);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ResourceLocalService getWrappedResourceLocalService() {
		return _resourceLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedResourceLocalService(
		ResourceLocalService resourceLocalService) {
		_resourceLocalService = resourceLocalService;
	}

	public ResourceLocalService getWrappedService() {
		return _resourceLocalService;
	}

	public void setWrappedService(ResourceLocalService resourceLocalService) {
		_resourceLocalService = resourceLocalService;
	}

	private ResourceLocalService _resourceLocalService;
}