package com.salmon.scommerce.persistence.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.salmon.scommerce.persistence.domain.AdminRole;
import com.salmon.scommerce.persistence.domain.AdminUser;

public interface AdminUserMapper {
	
	@Update("UPDATE admin_user SET user_id = #{newId} WHERE user_id = #{oldId}")
	public void updateUserId(@Param("newId") int newId, @Param("oldId") int oldId);
	
	@Update("UPDATE admin_role SET user_id = #{newId} WHERE user_id = #{oldId}")
	public void updateRoleWithUserId(@Param("newId") int newId, @Param("oldId") int oldId);
	
	@Select("SELECT * FROM admin_user WHERE user_id = #{Id}")
	@ResultMap(value = {"AdminUserResult"})
	public AdminUser getUserById(int Id); 
	
	@Select("SELECT * FROM admin_role where user_id = #{id}")
	@ResultMap(value="AdminRoleResult")
	public AdminRole selectAdminRole(int id);
	
}
