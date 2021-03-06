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

package com.liferay.portal.model;

import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ResourceCode}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ResourceCode
 * @generated
 */
public class ResourceCodeWrapper implements ResourceCode,
	ModelWrapper<ResourceCode> {
	public ResourceCodeWrapper(ResourceCode resourceCode) {
		_resourceCode = resourceCode;
	}

	public Class<?> getModelClass() {
		return ResourceCode.class;
	}

	public String getModelClassName() {
		return ResourceCode.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codeId", getCodeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("scope", getScope());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long codeId = (Long)attributes.get("codeId");

		if (codeId != null) {
			setCodeId(codeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer scope = (Integer)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}
	}

	/**
	* Returns the primary key of this resource code.
	*
	* @return the primary key of this resource code
	*/
	public long getPrimaryKey() {
		return _resourceCode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this resource code.
	*
	* @param primaryKey the primary key of this resource code
	*/
	public void setPrimaryKey(long primaryKey) {
		_resourceCode.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the code ID of this resource code.
	*
	* @return the code ID of this resource code
	*/
	public long getCodeId() {
		return _resourceCode.getCodeId();
	}

	/**
	* Sets the code ID of this resource code.
	*
	* @param codeId the code ID of this resource code
	*/
	public void setCodeId(long codeId) {
		_resourceCode.setCodeId(codeId);
	}

	/**
	* Returns the company ID of this resource code.
	*
	* @return the company ID of this resource code
	*/
	public long getCompanyId() {
		return _resourceCode.getCompanyId();
	}

	/**
	* Sets the company ID of this resource code.
	*
	* @param companyId the company ID of this resource code
	*/
	public void setCompanyId(long companyId) {
		_resourceCode.setCompanyId(companyId);
	}

	/**
	* Returns the name of this resource code.
	*
	* @return the name of this resource code
	*/
	public java.lang.String getName() {
		return _resourceCode.getName();
	}

	/**
	* Sets the name of this resource code.
	*
	* @param name the name of this resource code
	*/
	public void setName(java.lang.String name) {
		_resourceCode.setName(name);
	}

	/**
	* Returns the scope of this resource code.
	*
	* @return the scope of this resource code
	*/
	public int getScope() {
		return _resourceCode.getScope();
	}

	/**
	* Sets the scope of this resource code.
	*
	* @param scope the scope of this resource code
	*/
	public void setScope(int scope) {
		_resourceCode.setScope(scope);
	}

	public boolean isNew() {
		return _resourceCode.isNew();
	}

	public void setNew(boolean n) {
		_resourceCode.setNew(n);
	}

	public boolean isCachedModel() {
		return _resourceCode.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_resourceCode.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _resourceCode.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _resourceCode.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_resourceCode.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _resourceCode.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resourceCode.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ResourceCodeWrapper((ResourceCode)_resourceCode.clone());
	}

	public int compareTo(com.liferay.portal.model.ResourceCode resourceCode) {
		return _resourceCode.compareTo(resourceCode);
	}

	@Override
	public int hashCode() {
		return _resourceCode.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portal.model.ResourceCode> toCacheModel() {
		return _resourceCode.toCacheModel();
	}

	public com.liferay.portal.model.ResourceCode toEscapedModel() {
		return new ResourceCodeWrapper(_resourceCode.toEscapedModel());
	}

	public com.liferay.portal.model.ResourceCode toUnescapedModel() {
		return new ResourceCodeWrapper(_resourceCode.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _resourceCode.toString();
	}

	public java.lang.String toXmlString() {
		return _resourceCode.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_resourceCode.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResourceCodeWrapper)) {
			return false;
		}

		ResourceCodeWrapper resourceCodeWrapper = (ResourceCodeWrapper)obj;

		if (Validator.equals(_resourceCode, resourceCodeWrapper._resourceCode)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ResourceCode getWrappedResourceCode() {
		return _resourceCode;
	}

	public ResourceCode getWrappedModel() {
		return _resourceCode;
	}

	public void resetOriginalValues() {
		_resourceCode.resetOriginalValues();
	}

	private ResourceCode _resourceCode;
}