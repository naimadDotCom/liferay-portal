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

package com.liferay.portalweb.portlet.announcements.announcementsentry.editannouncementsentrygeneral;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.announcements.portlet.addportletannouncements.AddPageAnnouncementsTest;
import com.liferay.portalweb.portlet.announcements.portlet.addportletannouncements.AddPortletAnnouncementsTest;
import com.liferay.portalweb.portlet.myaccount.timezone.selecttimezonepacificstandardtime.SelectTimeZonePacificStandardTimeTest;
import com.liferay.portalweb.portlet.myaccount.timezone.selecttimezonepacificstandardtime.TearDownTimeZoneTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EditAnnouncementsEntryGeneralTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(SelectTimeZonePacificStandardTimeTest.class);
		testSuite.addTestSuite(AddPageAnnouncementsTest.class);
		testSuite.addTestSuite(AddPortletAnnouncementsTest.class);
		testSuite.addTestSuite(AddAnnouncementsEntryGeneralTest.class);
		testSuite.addTestSuite(EditAnnouncementsEntryGeneralTest.class);
		testSuite.addTestSuite(TearDownAnnouncementsEntryTest.class);
		testSuite.addTestSuite(TearDownTimeZoneTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}