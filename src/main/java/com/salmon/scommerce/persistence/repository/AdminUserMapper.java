package com.salmon.scommerce.persistence.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.salmon.scommerce.persistence.domain.AdminUser;

public interface AdminUserMapper {
	
	@Update("UPDATE admin_user SET user_id = #{newId} WHERE user_id = #{oldId}")
	public int updateAdminUserWithUserId(@Param("oldId") int oldId, @Param("newId") int newId);
	
	@Select("SELECT * FROM admin_user WHERE user_id = #{Id}")
	@ResultMap(value = {"AdminUserResult"})
	public AdminUser getAdminUserByUserId(@Param("Id") int Id); 
	
	public int addAdminUser(AdminUser adminuser);
	
	public int addAdminUserInc(AdminUser adminuser);
	
	public int deleteAdminUser(AdminUser adminuser);
	
	public int updateAdminUser(AdminUser adminuser);
	
	public List<AdminUser> getAdminUsers(AdminUser adminuser);
		
}
