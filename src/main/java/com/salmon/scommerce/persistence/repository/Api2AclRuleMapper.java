package com.salmon.scommerce.persistence.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.salmon.scommerce.persistence.domain.Api2AclRule;

/**
 * 
 * @author ctian
 * @Date 2014-10-08
 *
 */
public interface Api2AclRuleMapper {
	
	@Select("SELECT * FROM api2_acl_rule where entity_id = #{entityId}")
	@ResultMap("Api2AclRuleResult")
	public Api2AclRule getAclRuleByEntityId(int entityId);
	
	public List<Api2AclRule> getAclRules(Api2AclRule api2AclRule);
	
	@Insert("INSERT INTO api2_acl_rule(role_id, resource_id, privilege ) VALUES(#{roleId}, #{resourceId}, #{privilege})")
	public int addAclRule(Api2AclRule api2AclRule);
	
	@Update("UPDATE api2_acl_rule SET role_id = #{roleId},resource_id = #{resourceId},privilege = #{privilege} "
			+ "where entity_id = #{entityId} ")
	public void updateRuleByEntityId(Api2AclRule api2AclRule);
	
	@Delete("DELETE FROM api2_acl_rule WHERE entity_id = #{entityId}")
	public void deleteByEntityId(int entityId);

	

}
