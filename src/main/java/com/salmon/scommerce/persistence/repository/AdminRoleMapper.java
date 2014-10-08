package com.salmon.scommerce.persistence.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.salmon.scommerce.persistence.domain.AdminRole;


public interface AdminRoleMapper {

	@Select("SELECT * FROM admin_role where role_id = #{id}")
	@ResultMap(value="AdminRoleResult")
	AdminRole getAdminRoleByRoleId(int id);
	
	@Select("SELECT * FROM admin_role where user_id = #{userId}")
	@ResultMap(value="AdminRoleResult")
	AdminRole getAdminRoleByUserId(int userId);
	
	@Update("UPDATE admin_role SET user_id = #{newId} WHERE user_id = #{oldId}")
	public int updateAdminRoleWithUserId(@Param("oldId") int oldId, @Param("newId") int newId);
	
	@Insert("INSERT INTO admin_role " +
			"(role_id,parent_id,tree_level,sort_order,role_type,user_id,role_name,gws_is_all) " +
			"VALUES (#{adminRole.roleId},#{adminRole.parentId},#{adminRole.treeLevel},#{adminRole.},#{adminRole.},#{adminRole.},#{adminRole.},#{adminRole.},)")
	void addAdminRole(@Param("user") AdminRole adminRole);
	
	
}
