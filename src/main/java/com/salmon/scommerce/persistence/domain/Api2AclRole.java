package com.salmon.scommerce.persistence.domain;

import java.util.List;

public class Api2AclRole {

	private int entityId;
	private String roleName;
	private List<Api2AclRule> api2AclRuleList;

	public int getEntityId() {
		return entityId;
	}
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Api2AclRule> getApi2AclRule() {
		return api2AclRuleList;
	}
	public void setApi2AclRule(List<Api2AclRule> api2AclRuleList) {
		this.api2AclRuleList = api2AclRuleList;
	}
	


}
