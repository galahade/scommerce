package com.salmon.scommerce.persistence.repository;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.salmon.scommerce.persistence.domain.Api2AclUser;

/**
 * 
 * Function: aclUserMapper  
 * date: 2014年10月10日 下午2:31:50 
 * 
 * @author ctian
 *
 */
public interface Api2AclUserMapper extends BaseMapper<Api2AclUser>  {
	
	@Select("SELECT * FROM api2_acl_user where admin_id = #{adminId}")
	@ResultMap(value = { "Api2AclUserResult" })
	public Api2AclUser getByEntityId(int adminId);
	

	
}
