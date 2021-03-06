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

import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portlet.documentlibrary.model.DLProcessorConstants;

import java.io.InputStream;

import java.util.Properties;

/**
 * @author Sergio González
 */
public class PDFProcessorUtil {

	public static void generateImages(FileVersion fileVersion)
		throws Exception {

		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor != null) {
			pdfProcessor.generateImages(fileVersion);
		}
	}

	public static String getGlobalSearchPath() throws Exception {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return null;
		}

		return pdfProcessor.getGlobalSearchPath();
	}

	public static PDFProcessor getPDFProcessor() {
		return (PDFProcessor)DLProcessorRegistryUtil.getDLProcessor(
			DLProcessorConstants.PDF_PROCESSOR);
	}

	public static InputStream getPreviewAsStream(
			FileVersion fileVersion, int index)
		throws Exception {

		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return null;
		}

		return pdfProcessor.getPreviewAsStream(fileVersion, index);
	}

	public static int getPreviewFileCount(FileVersion fileVersion) {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return 0;
		}

		return pdfProcessor.getPreviewFileCount(fileVersion);
	}

	public static long getPreviewFileSize(FileVersion fileVersion, int index)
		throws Exception {

		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return 0;
		}

		return pdfProcessor.getPreviewFileSize(fileVersion, index);
	}

	public static Properties getResourceLimitsProperties() throws Exception {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return null;
		}

		return pdfProcessor.getResourceLimitsProperties();
	}

	public static InputStream getThumbnailAsStream(
			FileVersion fileVersion, int index)
		throws Exception {

		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return null;
		}

		return pdfProcessor.getThumbnailAsStream(fileVersion, index);
	}

	public static long getThumbnailFileSize(FileVersion fileVersion, int index)
		throws Exception {

		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return 0;
		}

		return pdfProcessor.getThumbnailFileSize(fileVersion, index);
	}

	public static boolean hasImages(FileVersion fileVersion) {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return false;
		}

		return pdfProcessor.hasImages(fileVersion);
	}

	public static boolean isDocumentSupported(FileVersion fileVersion) {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return false;
		}

		return pdfProcessor.isDocumentSupported(fileVersion);
	}

	public static boolean isDocumentSupported(String mimeType) {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return false;
		}

		return pdfProcessor.isDocumentSupported(mimeType);
	}

	public static boolean isImageMagickEnabled() throws Exception {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return false;
		}

		return pdfProcessor.isImageMagickEnabled();
	}

	public static boolean isSupported(String mimeType) {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor == null) {
			return false;
		}

		return pdfProcessor.isSupported(mimeType);
	}

	public static void reset() throws Exception {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor != null) {
			getPDFProcessor().reset();
		}
	}

	public static void trigger(FileVersion fileVersion) {
		PDFProcessor pdfProcessor = getPDFProcessor();

		if (pdfProcessor != null) {
			getPDFProcessor().trigger(fileVersion);
		}
	}

	/**
	 * @deprecated
	 */
	public void setPDFProcessor(PDFProcessor pdfProcessor) {
	}

}