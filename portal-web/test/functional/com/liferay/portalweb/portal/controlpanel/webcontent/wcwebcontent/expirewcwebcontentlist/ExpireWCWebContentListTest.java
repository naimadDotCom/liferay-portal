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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.expirewcwebcontentlist;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ExpireWCWebContentListTest extends BaseTestCase {
	public void testExpireWCWebContentList() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
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
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");

		String webContentID = selenium.getText("//td[2]/a");
		RuntimeVariables.setValue("webContentID", webContentID);
		assertEquals(RuntimeVariables.replace("${webContentID}"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[5]/a"));
		assertTrue(selenium.isVisible("//td[6]/a"));
		assertTrue(selenium.isVisible("//td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[8]/a"));
		assertFalse(selenium.isChecked("//input[@name='_15_rowIds']"));
		selenium.clickAt("//input[@name='_15_rowIds']",
			RuntimeVariables.replace("Row ID"));
		assertTrue(selenium.isChecked("//input[@name='_15_rowIds']"));
		selenium.clickAt("//input[@value='Expire']",
			RuntimeVariables.replace("Expire"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to expire the selected web content[\\s\\S]$"));
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("${webContentID}"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Expired"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[5]/a"));
		assertTrue(selenium.isVisible("//td[6]/a"));
		assertTrue(selenium.isVisible("//td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[8]/a"));
	}
}