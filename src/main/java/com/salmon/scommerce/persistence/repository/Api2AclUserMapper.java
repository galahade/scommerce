package com.salmon.scommerce.persistence.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.salmon.scommerce.persistence.domain.Api2AclUser;

/**
 * 
 * Function: aclUserMapper  
 * date: 2014年10月10日 下午2:31:50 
 * 
 * @author ctian
 *
 */
public interface Api2AclUserMapper {
	
	@Select("SELECT * FROM api2_acl_user where admin_id = #{adminId}")
	@ResultMap("Api2AclUserResult")
	public Api2AclUser getByEntityId(int adminId);

	public int add(Api2AclUser api2AclUser);
	
	@Update("UPDATE api2_acl_user SET admin_id =#{adminId}, role_id=#{roleId} WHERE admin_id=#{adminId}")
	public int update(Api2AclUser api2AclUser);
	
	@Delete("DELETE FROM api2_acl_user where admin_id = #{adminId}")
	public int delete(int adminId);
}
