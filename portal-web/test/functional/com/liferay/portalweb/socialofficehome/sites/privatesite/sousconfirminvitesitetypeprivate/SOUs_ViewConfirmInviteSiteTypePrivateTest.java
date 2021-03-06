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

package com.liferay.portalweb.socialofficehome.sites.privatesite.sousconfirminvitesitetypeprivate;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewConfirmInviteSiteTypePrivateTest extends BaseTestCase {
	public void testSOUs_ViewConfirmInviteSiteTypePrivate()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		selenium.waitForVisible("//select[@id='_5_WAR_soportlet_tabs1']");
		assertTrue(selenium.isPartialText(
				"//select[@id='_5_WAR_soportlet_tabs1']", "All Sites"));
		selenium.select("//select[@id='_5_WAR_soportlet_tabs1']",
			RuntimeVariables.replace("My Sites"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.type("//input[@class='search-input']",
			RuntimeVariables.replace("Private"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Private Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Private Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Site Name"),
			selenium.getText("//div[@class='community-title']"));
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText("//nav/ul/li[contains(.,'Home')]/a/span"));
		assertEquals(RuntimeVariables.replace("Calendar"),
			selenium.getText("//nav/ul/li[contains(.,'Calendar')]/a/span"));
		assertEquals(RuntimeVariables.replace("Documents"),
			selenium.getText("//nav/ul/li[contains(.,'Documents')]/a/span"));
		assertEquals(RuntimeVariables.replace("Forums"),
			selenium.getText("//nav/ul/li[contains(.,'Forums')]/a/span"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//nav/ul/li[contains(.,'Blogs')]/a/span"));
		assertEquals(RuntimeVariables.replace("Wiki"),
			selenium.getText("//nav/ul/li[contains(.,'Wiki')]/a/span"));
		assertEquals(RuntimeVariables.replace("Members"),
			selenium.getText("//nav/ul/li[contains(.,'Members')]/a/span"));
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		selenium.waitForVisible(
			"//button[contains(.,'Sites Directory')]/span[2]");
		assertEquals(RuntimeVariables.replace("Sites Directory"),
			selenium.getText("//button[contains(.,'Sites Directory')]/span[2]"));
		selenium.clickAt("//button[contains(.,'Sites Directory')]/span[2]",
			RuntimeVariables.replace("Sites Directory"));
		selenium.waitForVisible("xPath=(//h1[@class='header-title']/span)[1]");
		assertEquals(RuntimeVariables.replace("Directory"),
			selenium.getText("xPath=(//h1[@class='header-title']/span)[1]"));
		assertTrue(selenium.isVisible(
				"//input[@id='_5_WAR_soportlet_dialogKeywords']"));
		selenium.select("//select[@id='_5_WAR_soportlet_tabs1']",
			RuntimeVariables.replace("My Sites"));
		selenium.type("//input[@id='_5_WAR_soportlet_dialogKeywords']",
			RuntimeVariables.replace("Private Site Name"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Private Site Name"),
			selenium.getText("//span[@class='name']/a"));
		assertEquals(RuntimeVariables.replace("Private Site Description"),
			selenium.getText("//span[@class='description']"));
		selenium.clickAt("//span[@class='name']/a",
			RuntimeVariables.replace("Private Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Site Name"),
			selenium.getText("//div[@class='community-title']"));
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText("//nav/ul/li[1]/a/span"));
		assertEquals(RuntimeVariables.replace("Calendar"),
			selenium.getText("//nav/ul/li[2]/a/span"));
		assertEquals(RuntimeVariables.replace("Documents"),
			selenium.getText("//nav/ul/li[3]/a/span"));
		assertEquals(RuntimeVariables.replace("Forums"),
			selenium.getText("//nav/ul/li[4]/a/span"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//nav/ul/li[5]/a/span"));
		assertEquals(RuntimeVariables.replace("Wiki"),
			selenium.getText("//nav/ul/li[6]/a/span"));
		assertEquals(RuntimeVariables.replace("Members"),
			selenium.getText("//nav/ul/li[7]/a/span"));
		selenium.clickAt("//nav/ul/li[7]/a/span",
			RuntimeVariables.replace("Members"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Bloggs, Joe"),
			selenium.getText("xPath=(//div[@class='lfr-contact-name']/a)[1]"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("xPath=(//div[@class='lfr-contact-extra'])[1]"));
		assertEquals(RuntimeVariables.replace("User01, Social01"),
			selenium.getText("xPath=(//div[@class='lfr-contact-name']/a)[2]"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText("xPath=(//div[@class='lfr-contact-extra'])[2]"));
	}
}