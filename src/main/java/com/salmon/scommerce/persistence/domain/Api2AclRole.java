package com.salmon.scommerce.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ctian
 * @date 2014-10-10
 */
@Table(name="api2_acl_role")
public class Api2AclRole extends BaseDomain {

	@Id()
	@Column(name="entity_id")
	private int entityId;
	
	@Column(name="role_name")
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
	
	@Override
	public String toString() {
		return "Api2AclRole [entityId=" + entityId + ", roleName=" + roleName
				+ ", api2AclRuleList=" + api2AclRuleList + "]";
	}
	


}
