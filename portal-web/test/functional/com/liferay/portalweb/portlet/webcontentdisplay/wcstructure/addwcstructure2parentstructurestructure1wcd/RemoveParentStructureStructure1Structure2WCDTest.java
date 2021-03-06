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

package com.liferay.portalweb.portlet.webcontentdisplay.wcstructure.addwcstructure2parentstructurestructure1wcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RemoveParentStructureStructure1Structure2WCDTest
	extends BaseTestCase {
	public void testRemoveParentStructureStructure1Structure2WCD()
		throws Exception {
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
		selenium.clickAt("link=Structures",
			RuntimeVariables.replace("Structures"));
		selenium.waitForPageToLoad("30000");
		selenium.selectWindow("null");
		assertTrue(selenium.isVisible("//tr[4]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Structure2 Name"),
			selenium.getText("//tr[4]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("WC Structure2 Description"),
			selenium.getText("//tr[4]/td[4]/a"));
		selenium.clickAt("//tr[4]/td[3]/a",
			RuntimeVariables.replace("WC Structure2 Name"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@value='Remove']");
		selenium.clickAt("//input[@value='Remove']",
			RuntimeVariables.replace("Remove"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isVisible("//tr[4]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Structure2 Name"),
			selenium.getText("//tr[4]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("WC Structure2 Description"),
			selenium.getText("//tr[4]/td[4]/a"));
	}
}