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

package com.liferay.portalweb.portal.cluster.cluster3;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMBCategoryNodeTwoTest extends BaseTestCase {
	public void testAddMBCategoryNodeTwo() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Welcome");
		selenium.clickAt("link=Welcome", RuntimeVariables.replace("Welcome"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Category']",
			RuntimeVariables.replace("Add Category"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@id='_19_name']");
		selenium.type("//input[@id='_19_name']",
			RuntimeVariables.replace("MB Category Name Node-2"));
		selenium.type("//textarea[@id='_19_description']",
			RuntimeVariables.replace("MB Category Description Node-2"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isTextPresent("MB Category Name Node-2"));
		assertTrue(selenium.isTextPresent("MB Category Description Node-2"));
		assertEquals(RuntimeVariables.replace("Node: [$CLUSTER_NODE_2$]"),
			selenium.getText("//div[@id='content']/div[3]"));
	}
}