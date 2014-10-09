package com.salmon.scommerce.core.services;

import com.salmon.scommerce.core.domain.Permission;

public interface PermissionService {

	public Permission createPermission(Permission permission);
	
	public void deletePermission(Long permissionId);
}
