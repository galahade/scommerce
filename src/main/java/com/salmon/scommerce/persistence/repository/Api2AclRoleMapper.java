package com.salmon.scommerce.persistence.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.salmon.scommerce.persistence.domain.Api2AclRole;
import com.salmon.scommerce.persistence.domain.Api2AclRule;

/**
 * 
 * @author ctian
 * @Date 2014-10-08
 *
 */
public interface Api2AclRoleMapper extends BaseMapper<Api2AclRole> {
	
	
	

	@Select("SELECT * FROM api2_acl_role")
	@ResultMap("Api2AclRoleResult")
	public List<Api2AclRole> getAclRoles(Api2AclRole api2AclRole);
	
	@Select("SELECT role.entity_id role_entity_id, role_name, rule.entity_id,role_id,resource_id,privilege "
			+ "FROM api2_acl_role role, api2_acl_rule rule "
			+ "WHERE role.entity_id = rule.role_id AND role.entity_id = #{roleId}")
	@ResultMap("Api2AclRoleAndRuleResult")
	public Api2AclRole getAclRoleandPrivsByRoleId(int roleId);
	
	public List<Api2AclRole> getAclRolesandPivs(@Param("api2AclRole")Api2AclRole api2AclRole,@Param("api2AclRule")Api2AclRule api2AclRule);
	
	

}
