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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.tags.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewTagsTest extends BaseTestCase {
	public void testViewTags() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/tags-message-board-community/");
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace("Message Boards Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Tags", RuntimeVariables.replace("Tags"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='tags-admin-list lfr-component']/ul/li[1]/div/span/a",
			"selenium");
		assertEquals(RuntimeVariables.replace("selenium"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[1]/div/span/a"));
		assertEquals(RuntimeVariables.replace("selenium1"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[2]/div/span/a"));
		assertEquals(RuntimeVariables.replace("selenium2"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[3]/div/span/a"));
		assertEquals(RuntimeVariables.replace("selenium3"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[4]/div/span/a"));
	}
}