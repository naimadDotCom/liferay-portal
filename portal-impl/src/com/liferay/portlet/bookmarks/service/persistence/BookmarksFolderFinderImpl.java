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

package com.liferay.portlet.bookmarks.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.bookmarks.model.BookmarksFolder;
import com.liferay.portlet.bookmarks.model.impl.BookmarksFolderImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

/**
 * @author Joshua Steven Rodriguez
 */
public class BookmarksFolderFinderImpl
	extends BasePersistenceImpl<BookmarksFolder>
	implements BookmarksFolderFinder {

	public static final String FIND_BY_NO_RESOURCE_BLOCKS =
		BookmarksFolderFinder.class.getName() + ".findByNoResourceBlocks";

	@Override
	public List<BookmarksFolder> findByNoResourceBlocks()
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NO_RESOURCE_BLOCKS);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("BookmarksFolder", BookmarksFolderImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(BookmarksFolder.class.getName());

			return q.list(true);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}