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

package com.liferay.portalweb.portlet.wiki.wikipage.addfrontpagecreoleolists;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddFrontPageCreoleOListsTest extends BaseTestCase {
	public void testAddFrontPageCreoleOLists() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"This page is empty. Edit it to add some text."),
			selenium.getText("//div[@class='wiki-body']/div/a"));
		selenium.clickAt("//div[@class='wiki-body']/div/a",
			RuntimeVariables.replace(
				"This page is empty. Edit it to add some text."));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[.='Source']"));
		selenium.clickAt("//span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForVisible("//a[@class='cke_button_source cke_on']");
		selenium.waitForVisible("//td[@id='cke_contents__36_editor']/textarea");
		selenium.type("//td[@id='cke_contents__36_editor']/textarea",
			RuntimeVariables.replace(
				"# Item1\n## Subitem1a\n# Item2\n## Subitem2a\n## Subitem2b\n# Item3\n## Subitem3a\n## Subitem3b\n## Subitem3c"));
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[.='Source']"));
		selenium.clickAt("//span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForVisible("//td[@id='cke_contents__36_editor']/iframe");
		selenium.selectFrame("//td[@id='cke_contents__36_editor']/iframe");
		selenium.waitForPartialText("//body", "Item1");
		selenium.waitForPartialText("//body", "Subitem1a");
		selenium.waitForPartialText("//body", "Item2");
		selenium.waitForPartialText("//body", "Subitem2a");
		selenium.waitForPartialText("//body", "Subitem2b");
		selenium.waitForPartialText("//body", "Item3");
		selenium.waitForPartialText("//body", "Subitem3a");
		selenium.waitForPartialText("//body", "Subitem3b");
		selenium.waitForPartialText("//body", "Subitem3c");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"Item1 Subitem1a Item2 Subitem2a Subitem2b Item3 Subitem3a Subitem3b Subitem3c"),
			selenium.getText("//div[@class='wiki-body']/ol"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='wiki-body']/ol/li)[1]", "Item1"));
		assertEquals(RuntimeVariables.replace("Subitem1a"),
			selenium.getText(
				"xPath=(//div[@class='wiki-body']/ol/li/ol/li[1])[1]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='wiki-body']/ol/li)[2]", "Item2"));
		assertEquals(RuntimeVariables.replace("Subitem2a"),
			selenium.getText(
				"xPath=(//div[@class='wiki-body']/ol/li/ol/li[1])[2]"));
		assertEquals(RuntimeVariables.replace("Subitem2b"),
			selenium.getText(
				"xPath=(//div[@class='wiki-body']/ol/li/ol/li[2])[1]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='wiki-body']/ol/li)[3]", "Item3"));
		assertEquals(RuntimeVariables.replace("Subitem3a"),
			selenium.getText(
				"xPath=(//div[@class='wiki-body']/ol/li/ol/li[1])[3]"));
		assertEquals(RuntimeVariables.replace("Subitem3b"),
			selenium.getText(
				"xPath=(//div[@class='wiki-body']/ol/li/ol/li[2])[2]"));
		assertEquals(RuntimeVariables.replace("Subitem3c"),
			selenium.getText(
				"xPath=(//div[@class='wiki-body']/ol/li/ol/li[3])[1]"));
	}
}