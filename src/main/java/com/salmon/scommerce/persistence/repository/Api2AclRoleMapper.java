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
public interface Api2AclRoleMapper {
	
	

	@Select("SELECT * FROM api2_acl_role")
	@ResultMap("Api2AclRoleResult")
	public List<Api2AclRole> getAclRoles(Api2AclRole api2AclRole);
	
	
	public List<Api2AclRole> getAclRolesandPivs(@Param("api2AclRole")Api2AclRole api2AclRole,@Param("api2AclRule")Api2AclRule api2AclRule);
	
	
//	@Insert("INSERT INTO api2_acl_rule(role_id, resource_id, privilege ) VALUES(#{roleId}, #{resourceId}, #{privilege})")
//	public int addAclRule(Api2AclRule api2AclRule);

}
