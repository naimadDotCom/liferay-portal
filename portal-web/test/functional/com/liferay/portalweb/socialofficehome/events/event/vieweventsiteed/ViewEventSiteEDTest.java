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

package com.liferay.portalweb.socialofficehome.events.event.vieweventsiteed;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEventSiteEDTest extends BaseTestCase {
	public void testViewEventSiteED() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForText("xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]",
			"Events");
		assertEquals(RuntimeVariables.replace("Events"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]"));
		assertTrue(selenium.isPartialText("//h2[contains(.,'Events')]", "Events"));
		assertEquals(RuntimeVariables.replace("Calendar Event Title"),
			selenium.getText("//span[@class='event-name']/a"));
		selenium.clickAt("//span[@class='event-name']/a",
			RuntimeVariables.replace("Calendar Event Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText("//a[@title='Go to Open Site Name']"));
		assertEquals(RuntimeVariables.replace("Calendar Event Title"),
			selenium.getText("//h1[@class='header-title']"));
	}
}