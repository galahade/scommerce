package com.salmon.scommerce.persistence.repository.dao;

import com.salmon.scommerce.persistence.domain.Api2AclUser;

public interface IApiAclUserDao<T> {
	
	public Api2AclUser selectOne(Class<T> clazz, int aclUserId);
	
	public Api2AclUser selectOne(Api2AclUser api2AclUser);
	
	public void otherQueryMethod();
	
	public int add(Api2AclUser api2AclUser);
	
	public int update(Api2AclUser api2AclUser);
	
	public int delete(Class<T> clazz,int aclUserId);
	
	

}
