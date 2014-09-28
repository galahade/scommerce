package com.salmon.scommerce.respository.mybatis.config;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.salmon.scommerce.respository.domain.AdminRole;

public interface AdminRoleMapper {

	@Select("SELECT * FROM admin_role where role_id = #{id}")
	@ResultMap(value="AdminRoleResult")
	AdminRole selectAdminRole(int id);
}
