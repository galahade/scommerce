package com.salmon.scommerce.core.services;

import com.salmon.scommerce.core.domain.Role;

public interface RoleService {

	 public Role createRole(Role role);  
	    public void deleteRole(Long roleId);  
	    //��ӽ�ɫ-Ȩ��֮���ϵ  
	    public void correlationPermissions(Long roleId, Long... permissionIds);  
	    //�Ƴ���ɫ-Ȩ��֮���ϵ  
	    public void uncorrelationPermissions(Long roleId, Long... permissionIds);//  
}
