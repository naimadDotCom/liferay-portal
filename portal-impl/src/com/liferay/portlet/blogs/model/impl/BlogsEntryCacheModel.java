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

package com.liferay.portlet.blogs.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.portlet.blogs.model.BlogsEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing BlogsEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BlogsEntry
 * @generated
 */
public class BlogsEntryCacheModel implements CacheModel<BlogsEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", content=");
		sb.append(content);
		sb.append(", displayDate=");
		sb.append(displayDate);
		sb.append(", allowPingbacks=");
		sb.append(allowPingbacks);
		sb.append(", allowTrackbacks=");
		sb.append(allowTrackbacks);
		sb.append(", trackbacks=");
		sb.append(trackbacks);
		sb.append(", smallImage=");
		sb.append(smallImage);
		sb.append(", smallImageId=");
		sb.append(smallImageId);
		sb.append(", smallImageURL=");
		sb.append(smallImageURL);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	public BlogsEntry toEntityModel() {
		BlogsEntryImpl blogsEntryImpl = new BlogsEntryImpl();

		if (uuid == null) {
			blogsEntryImpl.setUuid(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setUuid(uuid);
		}

		blogsEntryImpl.setEntryId(entryId);
		blogsEntryImpl.setGroupId(groupId);
		blogsEntryImpl.setCompanyId(companyId);
		blogsEntryImpl.setUserId(userId);

		if (userName == null) {
			blogsEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			blogsEntryImpl.setCreateDate(null);
		}
		else {
			blogsEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			blogsEntryImpl.setModifiedDate(null);
		}
		else {
			blogsEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			blogsEntryImpl.setTitle(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setTitle(title);
		}

		if (urlTitle == null) {
			blogsEntryImpl.setUrlTitle(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setUrlTitle(urlTitle);
		}

		if (description == null) {
			blogsEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setDescription(description);
		}

		if (content == null) {
			blogsEntryImpl.setContent(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setContent(content);
		}

		if (displayDate == Long.MIN_VALUE) {
			blogsEntryImpl.setDisplayDate(null);
		}
		else {
			blogsEntryImpl.setDisplayDate(new Date(displayDate));
		}

		blogsEntryImpl.setAllowPingbacks(allowPingbacks);
		blogsEntryImpl.setAllowTrackbacks(allowTrackbacks);

		if (trackbacks == null) {
			blogsEntryImpl.setTrackbacks(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setTrackbacks(trackbacks);
		}

		blogsEntryImpl.setSmallImage(smallImage);
		blogsEntryImpl.setSmallImageId(smallImageId);

		if (smallImageURL == null) {
			blogsEntryImpl.setSmallImageURL(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setSmallImageURL(smallImageURL);
		}

		blogsEntryImpl.setStatus(status);
		blogsEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			blogsEntryImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			blogsEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			blogsEntryImpl.setStatusDate(null);
		}
		else {
			blogsEntryImpl.setStatusDate(new Date(statusDate));
		}

		blogsEntryImpl.resetOriginalValues();

		return blogsEntryImpl;
	}

	public String uuid;
	public long entryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String urlTitle;
	public String description;
	public String content;
	public long displayDate;
	public boolean allowPingbacks;
	public boolean allowTrackbacks;
	public String trackbacks;
	public boolean smallImage;
	public long smallImageId;
	public String smallImageURL;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}