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

package com.liferay.portlet.asset.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AssetVocabularyLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetVocabularyLocalService
 * @generated
 */
public class AssetVocabularyLocalServiceWrapper
	implements AssetVocabularyLocalService,
		ServiceWrapper<AssetVocabularyLocalService> {
	public AssetVocabularyLocalServiceWrapper(
		AssetVocabularyLocalService assetVocabularyLocalService) {
		_assetVocabularyLocalService = assetVocabularyLocalService;
	}

	/**
	* Adds the asset vocabulary to the database. Also notifies the appropriate model listeners.
	*
	* @param assetVocabulary the asset vocabulary
	* @return the asset vocabulary that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary addAssetVocabulary(
		com.liferay.portlet.asset.model.AssetVocabulary assetVocabulary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.addAssetVocabulary(assetVocabulary);
	}

	/**
	* Creates a new asset vocabulary with the primary key. Does not add the asset vocabulary to the database.
	*
	* @param vocabularyId the primary key for the new asset vocabulary
	* @return the new asset vocabulary
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary createAssetVocabulary(
		long vocabularyId) {
		return _assetVocabularyLocalService.createAssetVocabulary(vocabularyId);
	}

	/**
	* Deletes the asset vocabulary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vocabularyId the primary key of the asset vocabulary
	* @return the asset vocabulary that was removed
	* @throws PortalException if a asset vocabulary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary deleteAssetVocabulary(
		long vocabularyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.deleteAssetVocabulary(vocabularyId);
	}

	/**
	* Deletes the asset vocabulary from the database. Also notifies the appropriate model listeners.
	*
	* @param assetVocabulary the asset vocabulary
	* @return the asset vocabulary that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary deleteAssetVocabulary(
		com.liferay.portlet.asset.model.AssetVocabulary assetVocabulary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.deleteAssetVocabulary(assetVocabulary);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _assetVocabularyLocalService.dynamicQuery();
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
		return _assetVocabularyLocalService.dynamicQuery(dynamicQuery);
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
		return _assetVocabularyLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _assetVocabularyLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _assetVocabularyLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.portlet.asset.model.AssetVocabulary fetchAssetVocabulary(
		long vocabularyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.fetchAssetVocabulary(vocabularyId);
	}

	/**
	* Returns the asset vocabulary with the primary key.
	*
	* @param vocabularyId the primary key of the asset vocabulary
	* @return the asset vocabulary
	* @throws PortalException if a asset vocabulary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary getAssetVocabulary(
		long vocabularyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getAssetVocabulary(vocabularyId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the asset vocabulary with the UUID in the group.
	*
	* @param uuid the UUID of asset vocabulary
	* @param groupId the group id of the asset vocabulary
	* @return the asset vocabulary
	* @throws PortalException if a asset vocabulary with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary getAssetVocabularyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getAssetVocabularyByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the asset vocabularies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of asset vocabularies
	* @param end the upper bound of the range of asset vocabularies (not inclusive)
	* @return the range of asset vocabularies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getAssetVocabularies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getAssetVocabularies(start, end);
	}

	/**
	* Returns the number of asset vocabularies.
	*
	* @return the number of asset vocabularies
	* @throws SystemException if a system exception occurred
	*/
	public int getAssetVocabulariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getAssetVocabulariesCount();
	}

	/**
	* Updates the asset vocabulary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param assetVocabulary the asset vocabulary
	* @return the asset vocabulary that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary updateAssetVocabulary(
		com.liferay.portlet.asset.model.AssetVocabulary assetVocabulary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.updateAssetVocabulary(assetVocabulary);
	}

	/**
	* Updates the asset vocabulary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param assetVocabulary the asset vocabulary
	* @param merge whether to merge the asset vocabulary with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the asset vocabulary that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary updateAssetVocabulary(
		com.liferay.portlet.asset.model.AssetVocabulary assetVocabulary,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.updateAssetVocabulary(assetVocabulary,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _assetVocabularyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_assetVocabularyLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.liferay.portlet.asset.model.AssetVocabulary addDefaultVocabulary(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.addDefaultVocabulary(groupId);
	}

	/**
	* @deprecated
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary addVocabulary(
		long userId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String settings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.addVocabulary(userId, titleMap,
			descriptionMap, settings, serviceContext);
	}

	public com.liferay.portlet.asset.model.AssetVocabulary addVocabulary(
		long userId, java.lang.String title,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String settings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.addVocabulary(userId, title,
			titleMap, descriptionMap, settings, serviceContext);
	}

	public com.liferay.portlet.asset.model.AssetVocabulary addVocabulary(
		long userId, java.lang.String title,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.addVocabulary(userId, title,
			serviceContext);
	}

	public void addVocabularyResources(
		com.liferay.portlet.asset.model.AssetVocabulary vocabulary,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetVocabularyLocalService.addVocabularyResources(vocabulary,
			addGroupPermissions, addGuestPermissions);
	}

	public void addVocabularyResources(
		com.liferay.portlet.asset.model.AssetVocabulary vocabulary,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetVocabularyLocalService.addVocabularyResources(vocabulary,
			groupPermissions, guestPermissions);
	}

	public void deleteVocabularies(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetVocabularyLocalService.deleteVocabularies(groupId);
	}

	public void deleteVocabulary(
		com.liferay.portlet.asset.model.AssetVocabulary vocabulary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetVocabularyLocalService.deleteVocabulary(vocabulary);
	}

	public void deleteVocabulary(long vocabularyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetVocabularyLocalService.deleteVocabulary(vocabularyId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getCompanyVocabularies(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getCompanyVocabularies(companyId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getGroupsVocabularies(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getGroupsVocabularies(groupIds);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getGroupsVocabularies(
		long[] groupIds, java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getGroupsVocabularies(groupIds,
			className);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getGroupVocabularies(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getGroupVocabularies(groupId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getGroupVocabularies(
		long groupId, boolean addDefaultVocabulary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getGroupVocabularies(groupId,
			addDefaultVocabulary);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getGroupVocabularies(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getGroupVocabularies(groupId, name,
			start, end, obc);
	}

	public com.liferay.portlet.asset.model.AssetVocabulary getGroupVocabulary(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getGroupVocabulary(groupId, name);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getVocabularies(
		long[] vocabularyIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getVocabularies(vocabularyIds);
	}

	public com.liferay.portlet.asset.model.AssetVocabulary getVocabulary(
		long vocabularyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.getVocabulary(vocabularyId);
	}

	/**
	* @deprecated
	*/
	public com.liferay.portlet.asset.model.AssetVocabulary updateVocabulary(
		long vocabularyId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String settings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.updateVocabulary(vocabularyId,
			titleMap, descriptionMap, settings, serviceContext);
	}

	public com.liferay.portlet.asset.model.AssetVocabulary updateVocabulary(
		long vocabularyId, java.lang.String title,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String settings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetVocabularyLocalService.updateVocabulary(vocabularyId,
			title, titleMap, descriptionMap, settings, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AssetVocabularyLocalService getWrappedAssetVocabularyLocalService() {
		return _assetVocabularyLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAssetVocabularyLocalService(
		AssetVocabularyLocalService assetVocabularyLocalService) {
		_assetVocabularyLocalService = assetVocabularyLocalService;
	}

	public AssetVocabularyLocalService getWrappedService() {
		return _assetVocabularyLocalService;
	}

	public void setWrappedService(
		AssetVocabularyLocalService assetVocabularyLocalService) {
		_assetVocabularyLocalService = assetVocabularyLocalService;
	}

	private AssetVocabularyLocalService _assetVocabularyLocalService;
}