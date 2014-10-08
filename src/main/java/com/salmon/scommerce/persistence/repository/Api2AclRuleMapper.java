package com.salmon.scommerce.persistence.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.salmon.scommerce.persistence.domain.Api2AclRule;

/**
 * 
 * @author ctian
 * @Date 2014-10-08
 *
 */
public interface Api2AclRuleMapper {
	
	public List<Api2AclRule> getAclRules(Api2AclRule api2AclRule);
	
	@Insert("INSERT INTO api2_acl_rule(role_id, resource_id, privilege ) VALUES(#{roleId}, #{resourceId}, #{privilege})")
	public int addAclRule(Api2AclRule api2AclRule);

	

}
