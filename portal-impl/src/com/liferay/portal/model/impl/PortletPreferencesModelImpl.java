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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.model.PortletPreferencesModel;
import com.liferay.portal.model.PortletPreferencesSoap;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the PortletPreferences service. Represents a row in the &quot;PortletPreferences&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.PortletPreferencesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PortletPreferencesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletPreferencesImpl
 * @see com.liferay.portal.model.PortletPreferences
 * @see com.liferay.portal.model.PortletPreferencesModel
 * @generated
 */
@JSON(strict = true)
public class PortletPreferencesModelImpl extends BaseModelImpl<PortletPreferences>
	implements PortletPreferencesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a portlet preferences model instance should use the {@link com.liferay.portal.model.PortletPreferences} interface instead.
	 */
	public static final String TABLE_NAME = "PortletPreferences";
	public static final Object[][] TABLE_COLUMNS = {
			{ "portletPreferencesId", Types.BIGINT },
			{ "ownerId", Types.BIGINT },
			{ "ownerType", Types.INTEGER },
			{ "plid", Types.BIGINT },
			{ "portletId", Types.VARCHAR },
			{ "preferences", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table PortletPreferences (portletPreferencesId LONG not null primary key,ownerId LONG,ownerType INTEGER,plid LONG,portletId VARCHAR(200) null,preferences TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table PortletPreferences";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.PortletPreferences"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.PortletPreferences"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.PortletPreferences"),
			true);
	public static long OWNERID_COLUMN_BITMASK = 1L;
	public static long OWNERTYPE_COLUMN_BITMASK = 2L;
	public static long PLID_COLUMN_BITMASK = 4L;
	public static long PORTLETID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PortletPreferences toModel(PortletPreferencesSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PortletPreferences model = new PortletPreferencesImpl();

		model.setPortletPreferencesId(soapModel.getPortletPreferencesId());
		model.setOwnerId(soapModel.getOwnerId());
		model.setOwnerType(soapModel.getOwnerType());
		model.setPlid(soapModel.getPlid());
		model.setPortletId(soapModel.getPortletId());
		model.setPreferences(soapModel.getPreferences());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PortletPreferences> toModels(
		PortletPreferencesSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PortletPreferences> models = new ArrayList<PortletPreferences>(soapModels.length);

		for (PortletPreferencesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.PortletPreferences"));

	public PortletPreferencesModelImpl() {
	}

	public long getPrimaryKey() {
		return _portletPreferencesId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPortletPreferencesId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_portletPreferencesId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return PortletPreferences.class;
	}

	public String getModelClassName() {
		return PortletPreferences.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("portletPreferencesId", getPortletPreferencesId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("ownerType", getOwnerType());
		attributes.put("plid", getPlid());
		attributes.put("portletId", getPortletId());
		attributes.put("preferences", getPreferences());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long portletPreferencesId = (Long)attributes.get("portletPreferencesId");

		if (portletPreferencesId != null) {
			setPortletPreferencesId(portletPreferencesId);
		}

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		Integer ownerType = (Integer)attributes.get("ownerType");

		if (ownerType != null) {
			setOwnerType(ownerType);
		}

		Long plid = (Long)attributes.get("plid");

		if (plid != null) {
			setPlid(plid);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String preferences = (String)attributes.get("preferences");

		if (preferences != null) {
			setPreferences(preferences);
		}
	}

	@JSON
	public long getPortletPreferencesId() {
		return _portletPreferencesId;
	}

	public void setPortletPreferencesId(long portletPreferencesId) {
		_portletPreferencesId = portletPreferencesId;
	}

	@JSON
	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_columnBitmask |= OWNERID_COLUMN_BITMASK;

		if (!_setOriginalOwnerId) {
			_setOriginalOwnerId = true;

			_originalOwnerId = _ownerId;
		}

		_ownerId = ownerId;
	}

	public long getOriginalOwnerId() {
		return _originalOwnerId;
	}

	@JSON
	public int getOwnerType() {
		return _ownerType;
	}

	public void setOwnerType(int ownerType) {
		_columnBitmask |= OWNERTYPE_COLUMN_BITMASK;

		if (!_setOriginalOwnerType) {
			_setOriginalOwnerType = true;

			_originalOwnerType = _ownerType;
		}

		_ownerType = ownerType;
	}

	public int getOriginalOwnerType() {
		return _originalOwnerType;
	}

	@JSON
	public long getPlid() {
		return _plid;
	}

	public void setPlid(long plid) {
		_columnBitmask |= PLID_COLUMN_BITMASK;

		if (!_setOriginalPlid) {
			_setOriginalPlid = true;

			_originalPlid = _plid;
		}

		_plid = plid;
	}

	public long getOriginalPlid() {
		return _originalPlid;
	}

	@JSON
	public String getPortletId() {
		if (_portletId == null) {
			return StringPool.BLANK;
		}
		else {
			return _portletId;
		}
	}

	public void setPortletId(String portletId) {
		_columnBitmask |= PORTLETID_COLUMN_BITMASK;

		if (_originalPortletId == null) {
			_originalPortletId = _portletId;
		}

		_portletId = portletId;
	}

	public String getOriginalPortletId() {
		return GetterUtil.getString(_originalPortletId);
	}

	@JSON
	public String getPreferences() {
		if (_preferences == null) {
			return StringPool.BLANK;
		}
		else {
			return _preferences;
		}
	}

	public void setPreferences(String preferences) {
		_preferences = preferences;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			PortletPreferences.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PortletPreferences toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PortletPreferences)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public PortletPreferences toUnescapedModel() {
		return (PortletPreferences)this;
	}

	@Override
	public Object clone() {
		PortletPreferencesImpl portletPreferencesImpl = new PortletPreferencesImpl();

		portletPreferencesImpl.setPortletPreferencesId(getPortletPreferencesId());
		portletPreferencesImpl.setOwnerId(getOwnerId());
		portletPreferencesImpl.setOwnerType(getOwnerType());
		portletPreferencesImpl.setPlid(getPlid());
		portletPreferencesImpl.setPortletId(getPortletId());
		portletPreferencesImpl.setPreferences(getPreferences());

		portletPreferencesImpl.resetOriginalValues();

		return portletPreferencesImpl;
	}

	public int compareTo(PortletPreferences portletPreferences) {
		long primaryKey = portletPreferences.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortletPreferences)) {
			return false;
		}

		PortletPreferences portletPreferences = (PortletPreferences)obj;

		long primaryKey = portletPreferences.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		PortletPreferencesModelImpl portletPreferencesModelImpl = this;

		portletPreferencesModelImpl._originalOwnerId = portletPreferencesModelImpl._ownerId;

		portletPreferencesModelImpl._setOriginalOwnerId = false;

		portletPreferencesModelImpl._originalOwnerType = portletPreferencesModelImpl._ownerType;

		portletPreferencesModelImpl._setOriginalOwnerType = false;

		portletPreferencesModelImpl._originalPlid = portletPreferencesModelImpl._plid;

		portletPreferencesModelImpl._setOriginalPlid = false;

		portletPreferencesModelImpl._originalPortletId = portletPreferencesModelImpl._portletId;

		portletPreferencesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PortletPreferences> toCacheModel() {
		PortletPreferencesCacheModel portletPreferencesCacheModel = new PortletPreferencesCacheModel();

		portletPreferencesCacheModel.portletPreferencesId = getPortletPreferencesId();

		portletPreferencesCacheModel.ownerId = getOwnerId();

		portletPreferencesCacheModel.ownerType = getOwnerType();

		portletPreferencesCacheModel.plid = getPlid();

		portletPreferencesCacheModel.portletId = getPortletId();

		String portletId = portletPreferencesCacheModel.portletId;

		if ((portletId != null) && (portletId.length() == 0)) {
			portletPreferencesCacheModel.portletId = null;
		}

		portletPreferencesCacheModel.preferences = getPreferences();

		String preferences = portletPreferencesCacheModel.preferences;

		if ((preferences != null) && (preferences.length() == 0)) {
			portletPreferencesCacheModel.preferences = null;
		}

		return portletPreferencesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{portletPreferencesId=");
		sb.append(getPortletPreferencesId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", ownerType=");
		sb.append(getOwnerType());
		sb.append(", plid=");
		sb.append(getPlid());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", preferences=");
		sb.append(getPreferences());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.PortletPreferences");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>portletPreferencesId</column-name><column-value><![CDATA[");
		sb.append(getPortletPreferencesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerType</column-name><column-value><![CDATA[");
		sb.append(getOwnerType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>plid</column-name><column-value><![CDATA[");
		sb.append(getPlid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preferences</column-name><column-value><![CDATA[");
		sb.append(getPreferences());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = PortletPreferences.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			PortletPreferences.class
		};
	private long _portletPreferencesId;
	private long _ownerId;
	private long _originalOwnerId;
	private boolean _setOriginalOwnerId;
	private int _ownerType;
	private int _originalOwnerType;
	private boolean _setOriginalOwnerType;
	private long _plid;
	private long _originalPlid;
	private boolean _setOriginalPlid;
	private String _portletId;
	private String _originalPortletId;
	private String _preferences;
	private long _columnBitmask;
	private PortletPreferences _escapedModel;
}