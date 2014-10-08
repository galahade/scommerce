package com.salmon.scommerce.test.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

public class PermissionTest  extends BaseTest {
	
    @Test  
    public void testIsPermitted() {  
        login("classpath:shiro-permission.ini", "zhang", "123");  
        //�ж�ӵ��Ȩ�ޣ�user:create  
        Assert.assertTrue(subject().isPermitted("user:create"));  
        //�ж�ӵ��Ȩ�ޣ�user:update and user:delete  
        Assert.assertTrue(subject().isPermittedAll("user:update", "user:delete"));  
        //�ж�û��Ȩ�ޣ�user:view  
        Assert.assertFalse(subject().isPermitted("user:view"));  
    }   
    @Test(expected = UnauthorizedException.class)  
    public void testCheckPermission () {  
        login("classpath:shiro-permission.ini", "zhang", "123");  
        //����ӵ��Ȩ�ޣ�user:create  
        subject().checkPermission("user:create");  
        //����ӵ��Ȩ�ޣ�user:delete and user:update  
        subject().checkPermissions("user:delete", "user:update");  
        //����ӵ��Ȩ�ޣ�user:view ʧ���׳��쳣  
        subject().checkPermissions("user:view");  
    } 
    
    

}
