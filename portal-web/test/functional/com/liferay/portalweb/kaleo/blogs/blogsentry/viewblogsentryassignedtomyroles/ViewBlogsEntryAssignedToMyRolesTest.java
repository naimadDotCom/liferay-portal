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

package com.liferay.portalweb.kaleo.blogs.blogsentry.viewblogsentryassignedtomyroles;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryAssignedToMyRolesTest extends BaseTestCase {
	public void testViewBlogsEntryAssignedToMyRoles() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Pending Approval"),
			selenium.getText("//div[@class='entry-content']/h3"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Content"),
			selenium.getText("//div[@class='entry-body']"));
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=My Workflow Tasks",
			RuntimeVariables.replace("My Workflow Tasks"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Pending", RuntimeVariables.replace("Pending"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to you."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[3]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Blogs Entry Title')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[5]/a"));
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("There are no completed tasks."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}