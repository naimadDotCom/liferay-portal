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

package com.liferay.portlet.documentlibrary.util;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.metadata.RawMetadataProcessorUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.security.pacl.DoPrivileged;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.repository.liferayrepository.model.LiferayFileEntry;
import com.liferay.portal.repository.liferayrepository.model.LiferayFileVersion;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryConstants;
import com.liferay.portlet.documentlibrary.service.DLFileEntryMetadataLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

import java.io.File;
import java.io.InputStream;

import java.util.List;
import java.util.Map;

/**
 * @author Alexander Chow
 * @author Mika Koivisto
 * @author Miguel Pastor
 */
@DoPrivileged
public class RawMetadataProcessorImpl
	implements DLProcessor, RawMetadataProcessor {

	@Override
	public void afterPropertiesSet() {
	}

	@Override
	public void cleanUp(FileEntry fileEntry) {
	}

	@Override
	public void cleanUp(FileVersion fileVersion) {
	}

	@Override
	public void exportGeneratedFiles(
			PortletDataContext portletDataContext, FileEntry fileEntry,
			Element fileEntryElement)
		throws Exception {

		return;
	}

	@Override
	public void generateMetadata(FileVersion fileVersion)
		throws SystemException {

		long fileVersionId = fileVersion.getFileVersionId();

		long fileEntryMetadataCount =
			DLFileEntryMetadataLocalServiceUtil.
				getFileVersionFileEntryMetadatasCount(fileVersionId);

		if (fileEntryMetadataCount == 0) {
			trigger(fileVersion);
		}
	}

	@Override
	public void importGeneratedFiles(
			PortletDataContext portletDataContext, FileEntry fileEntry,
			FileEntry importedFileEntry, Element fileEntryElement)
		throws Exception {

		return;
	}

	@Override
	public boolean isSupported(FileVersion fileVersion) {
		return true;
	}

	@Override
	public boolean isSupported(String mimeType) {
		return true;
	}

	@Override
	public void saveMetadata(FileVersion fileVersion)
		throws PortalException, SystemException {

		Map<String, Fields> rawMetadataMap = null;

		if (fileVersion instanceof LiferayFileVersion) {
			try {
				LiferayFileVersion liferayFileVersion =
					(LiferayFileVersion)fileVersion;

				File file = liferayFileVersion.getFile(false);

				rawMetadataMap = RawMetadataProcessorUtil.getRawMetadataMap(
					fileVersion.getExtension(), fileVersion.getMimeType(),
					file);
			}
			catch (UnsupportedOperationException uoe) {
			}
		}

		if (rawMetadataMap == null) {
			InputStream inputStream = null;

			try {
				inputStream = fileVersion.getContentStream(false);

				if (inputStream == null) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"No metadata is available for file version " +
								fileVersion.getFileVersionId());
					}

					return;
				}

				rawMetadataMap = RawMetadataProcessorUtil.getRawMetadataMap(
					fileVersion.getExtension(), fileVersion.getMimeType(),
					inputStream);
			}
			finally {
				StreamUtil.cleanUp(inputStream);
			}
		}

		List<DDMStructure> ddmStructures =
			DDMStructureLocalServiceUtil.getClassStructures(
				fileVersion.getCompanyId(),
				PortalUtil.getClassNameId(DLFileEntry.class), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setScopeGroupId(fileVersion.getGroupId());
		serviceContext.setUserId(fileVersion.getUserId());

		DLFileEntryMetadataLocalServiceUtil.updateFileEntryMetadata(
			fileVersion.getCompanyId(), ddmStructures, 0L,
			fileVersion.getFileEntryId(), fileVersion.getFileVersionId(),
			rawMetadataMap, serviceContext);

		FileEntry fileEntry = fileVersion.getFileEntry();

		if (fileEntry instanceof LiferayFileEntry) {
			Indexer indexer = IndexerRegistryUtil.getIndexer(
				DLFileEntryConstants.getClassName());

			LiferayFileEntry liferayFileEntry = (LiferayFileEntry)fileEntry;

			indexer.reindex(liferayFileEntry.getDLFileEntry());
		}
	}

	@Override
	public void trigger(FileVersion fileVersion) {
		if (PropsValues.DL_FILE_ENTRY_PROCESSORS_TRIGGER_SYNCHRONOUSLY) {
			try {
				MessageBusUtil.sendSynchronousMessage(
					DestinationNames.DOCUMENT_LIBRARY_RAW_METADATA_PROCESSOR,
					fileVersion);
			}
			catch (MessageBusException mbe) {
				if (_log.isWarnEnabled()) {
					_log.warn(mbe, mbe);
				}
			}
		}
		else {
			MessageBusUtil.sendMessage(
				DestinationNames.DOCUMENT_LIBRARY_RAW_METADATA_PROCESSOR,
				fileVersion);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		RawMetadataProcessorImpl.class);

}