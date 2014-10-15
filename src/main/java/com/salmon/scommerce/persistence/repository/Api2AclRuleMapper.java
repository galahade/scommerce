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
public interface Api2AclRuleMapper extends BaseMapper<Api2AclRule> {
	
	@Select("SELECT * FROM api2_acl_rule where entity_id = #{entityId}")
	@ResultMap("Api2AclRuleResult")
	public Api2AclRule getAclRuleByEntityId(int entityId);
	
	public List<Api2AclRule> getAclRules(Api2AclRule api2AclRule);
	

	

}
