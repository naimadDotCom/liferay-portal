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
 * This class is a wrapper for {@link AssetEntryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetEntryService
 * @generated
 */
public class AssetEntryServiceWrapper implements AssetEntryService,
	ServiceWrapper<AssetEntryService> {
	public AssetEntryServiceWrapper(AssetEntryService assetEntryService) {
		_assetEntryService = assetEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _assetEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_assetEntryService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetEntry> getCompanyEntries(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getCompanyEntries(companyId, start, end);
	}

	public int getCompanyEntriesCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getCompanyEntriesCount(companyId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetEntry> getEntries(
		com.liferay.portlet.asset.service.persistence.AssetEntryQuery entryQuery)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getEntries(entryQuery);
	}

	public int getEntriesCount(
		com.liferay.portlet.asset.service.persistence.AssetEntryQuery entryQuery)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getEntriesCount(entryQuery);
	}

	public com.liferay.portlet.asset.model.AssetEntry getEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getEntry(entryId);
	}

	public com.liferay.portlet.asset.model.AssetEntry incrementViewCounter(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.incrementViewCounter(className, classPK);
	}

	public com.liferay.portlet.asset.model.AssetEntry updateEntry(
		long groupId, java.util.Date createDate, java.util.Date modifiedDate,
		java.lang.String className, long classPK, java.lang.String classUuid,
		long classTypeId, long[] categoryIds, java.lang.String[] tagNames,
		boolean visible, java.util.Date startDate, java.util.Date endDate,
		java.util.Date publishDate, java.util.Date expirationDate,
		java.lang.String mimeType, java.lang.String title,
		java.lang.String description, java.lang.String summary,
		java.lang.String url, java.lang.String layoutUuid, int height,
		int width, java.lang.Integer priority, boolean sync)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.updateEntry(groupId, createDate,
			modifiedDate, className, classPK, classUuid, classTypeId,
			categoryIds, tagNames, visible, startDate, endDate, publishDate,
			expirationDate, mimeType, title, description, summary, url,
			layoutUuid, height, width, priority, sync);
	}

	/**
	* @deprecated {@link #updateEntry(long, Date, Date. String, long, String,
	long, long[], String[], boolean, Date, Date, Date, Date,
	String, String, String, String, String, String, int, int,
	Integer, boolean)}
	*/
	public com.liferay.portlet.asset.model.AssetEntry updateEntry(
		long groupId, java.lang.String className, long classPK,
		java.lang.String classUuid, long classTypeId, long[] categoryIds,
		java.lang.String[] tagNames, boolean visible, java.util.Date startDate,
		java.util.Date endDate, java.util.Date publishDate,
		java.util.Date expirationDate, java.lang.String mimeType,
		java.lang.String title, java.lang.String description,
		java.lang.String summary, java.lang.String url,
		java.lang.String layoutUuid, int height, int width,
		java.lang.Integer priority, boolean sync)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.updateEntry(groupId, className, classPK,
			classUuid, classTypeId, categoryIds, tagNames, visible, startDate,
			endDate, publishDate, expirationDate, mimeType, title, description,
			summary, url, layoutUuid, height, width, priority, sync);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AssetEntryService getWrappedAssetEntryService() {
		return _assetEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAssetEntryService(AssetEntryService assetEntryService) {
		_assetEntryService = assetEntryService;
	}

	public AssetEntryService getWrappedService() {
		return _assetEntryService;
	}

	public void setWrappedService(AssetEntryService assetEntryService) {
		_assetEntryService = assetEntryService;
	}

	private AssetEntryService _assetEntryService;
}