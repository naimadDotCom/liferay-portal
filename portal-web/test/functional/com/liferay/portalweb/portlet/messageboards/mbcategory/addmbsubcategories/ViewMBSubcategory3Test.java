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

package com.liferay.portalweb.portlet.messageboards.mbcategory.addmbsubcategories;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBSubcategory3Test extends BaseTestCase {
	public void testViewMBSubcategory3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//td[1]/a/strong"));
		assertEquals(RuntimeVariables.replace("3"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//td[4]/a"));
		selenium.clickAt("//td[1]/a/strong",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Category Subcategory1 Name"),
			selenium.getText("//tr[3]/td[1]/a/strong"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[3]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[3]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[3]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//tr[3]/td[5]/span/ul/li/strong/a/span"));
		assertEquals(RuntimeVariables.replace("MB Category Subcategory2 Name"),
			selenium.getText("//tr[4]/td[1]/a/strong"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[4]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[4]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[4]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//tr[4]/td[5]/span/ul/li/strong/a/span"));
		assertEquals(RuntimeVariables.replace("MB Category Subcategory3 Name"),
			selenium.getText("//tr[5]/td[1]/a/strong"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[5]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[5]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[5]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//tr[5]/td[5]/span/ul/li/strong/a/span"));
		selenium.clickAt("//tr[5]/td[1]/a/strong",
			RuntimeVariables.replace("MB Category Subcategory3 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Category Subcategory3 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"There are no threads in this category."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}