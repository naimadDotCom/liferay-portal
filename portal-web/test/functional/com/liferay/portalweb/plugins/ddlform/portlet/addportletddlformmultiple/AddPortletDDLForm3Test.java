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

package com.liferay.portalweb.plugins.ddlform.portlet.addportletddlformmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPortletDDLForm3Test extends BaseTestCase {
	public void testAddPortletDDLForm3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Dynamic Data List Form Test Page",
			RuntimeVariables.replace("Dynamic Data List Form Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//li[@id='_145_addContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_addContent']/a/span");
		selenium.waitForVisible("//a[@id='_145_addApplication']");
		assertTrue(selenium.isPartialText("//a[@id='_145_addApplication']",
				"More"));
		selenium.clickAt("//a[@id='_145_addApplication']",
			RuntimeVariables.replace("More"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-live-search/aui-live-search-min.js')]");
		selenium.waitForVisible("//input[@id='layout_configuration_content']");
		selenium.sendKeys("//input[@id='layout_configuration_content']",
			RuntimeVariables.replace("d"));
		selenium.waitForVisible("//div[@title='Dynamic Data List Form']/p/a");
		selenium.clickAt("//div[@title='Dynamic Data List Form']/p/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//div[1]/div/section");
		assertTrue(selenium.isVisible("//div[1]/div/section"));
		assertEquals(RuntimeVariables.replace("Dynamic Data List Form"),
			selenium.getText("xPath=(//span[@class='portlet-title-text'])[1]"));
		selenium.waitForVisible("//div[2]/div/section");
		assertTrue(selenium.isVisible("//div[2]/div/section"));
		assertEquals(RuntimeVariables.replace("Dynamic Data List Form"),
			selenium.getText("xPath=(//span[@class='portlet-title-text'])[2]"));
		selenium.waitForVisible("//div[3]/div/section");
		assertTrue(selenium.isVisible("//div[3]/div/section"));
		assertEquals(RuntimeVariables.replace("Dynamic Data List Form"),
			selenium.getText("xPath=(//span[@class='portlet-title-text'])[3]"));
	}
}