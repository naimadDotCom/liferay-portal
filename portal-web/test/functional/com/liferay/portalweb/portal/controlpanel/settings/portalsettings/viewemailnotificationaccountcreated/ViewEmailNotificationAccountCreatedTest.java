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

package com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewemailnotificationaccountcreated;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEmailNotificationAccountCreatedTest extends BaseTestCase {
	public void testViewEmailNotificationAccountCreated()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//a[@id='_130_emailNotificationsLink']");
		selenium.clickAt("//a[@id='_130_emailNotificationsLink']",
			RuntimeVariables.replace("Email Notifications"));
		selenium.clickAt("link=Account Created Notification",
			RuntimeVariables.replace("Account Created Notification"));
		selenium.waitForElementPresent(
			"//input[@name='_130_settings--admin.email.user.added.enabled--Checkbox']");
		assertTrue(selenium.isElementPresent(
				"//input[@name='_130_settings--admin.email.user.added.enabled--Checkbox']"));
		assertTrue(selenium.isTextPresent("Subject"));
		assertTrue(selenium.isTextPresent("Body"));
	}
}