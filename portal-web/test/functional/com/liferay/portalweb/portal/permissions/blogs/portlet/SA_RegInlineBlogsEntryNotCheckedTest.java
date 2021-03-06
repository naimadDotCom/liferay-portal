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

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_RegInlineBlogsEntryNotCheckedTest extends BaseTestCase {
	public void testSA_RegInlineBlogsEntryNotChecked()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Blogs Permissions Page");
		selenium.clickAt("link=Blogs Permissions Page",
			RuntimeVariables.replace("Blogs Permissions Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Permissions']",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@id='guest_ACTION_ADD_ENTRY']");
		assertFalse(selenium.isChecked("//input[@id='guest_ACTION_ADD_ENTRY']"));
		assertFalse(selenium.isChecked(
				"//input[@id='portlet_ACTION_ADD_ENTRY']"));
	}
}