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

import java.util.Set;

/**
 * @author Sergio González
 */
public class AudioProcessorUtil {

	public static void generateAudio(FileVersion fileVersion) throws Exception {
		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor != null) {
			audioProcessor.generateAudio(fileVersion);
		}
	}

	public static Set<String> getAudioMimeTypes() {
		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor == null) {
			return null;
		}

		return audioProcessor.getAudioMimeTypes();
	}

	public static AudioProcessor getAudioProcessor() {
		return (AudioProcessor)DLProcessorRegistryUtil.getDLProcessor(
			DLProcessorConstants.AUDIO_PROCESSOR);
	}

	public static InputStream getPreviewAsStream(
			FileVersion fileVersion, String type)
		throws Exception {

		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor == null) {
			return null;
		}

		return audioProcessor.getPreviewAsStream(fileVersion, type);
	}

	public static long getPreviewFileSize(FileVersion fileVersion, String type)
		throws Exception {

		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor == null) {
			return 0;
		}

		return audioProcessor.getPreviewFileSize(fileVersion, type);
	}

	public static boolean hasAudio(FileVersion fileVersion) {
		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor == null) {
			return false;
		}

		return audioProcessor.hasAudio(fileVersion);
	}

	public static boolean isAudioSupported(FileVersion fileVersion) {
		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor == null) {
			return false;
		}

		return audioProcessor.isAudioSupported(fileVersion);
	}

	public static boolean isAudioSupported(String mimeType) {
		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor == null) {
			return false;
		}

		return audioProcessor.isAudioSupported(mimeType);
	}

	public static boolean isSupported(String mimeType) {
		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor == null) {
			return false;
		}

		return audioProcessor.isSupported(mimeType);
	}

	public static void trigger(FileVersion fileVersion) {
		AudioProcessor audioProcessor = getAudioProcessor();

		if (audioProcessor == null) {
			return;
		}

		audioProcessor.trigger(fileVersion);
	}

	/**
	 * @deprecated
	 */
	public void setAudioProcessor(AudioProcessor audioProcessor) {
	}

}