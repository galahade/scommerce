package com.salmon.scommerce.test.shiro;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

public class RoleTest extends BaseTest {

	 @Test
	    public void testHasRole() {
	        login("classpath:shiro-role.ini", "zhang", "123");
	        //�ж�ӵ�н�ɫ��role1
	        Assert.assertTrue(subject().hasRole("role1"));
	        //�ж�ӵ�н�ɫ��role1 and role2
	        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
	        //�ж�ӵ�н�ɫ��role1 and role2 and !role3
	        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
	        Assert.assertEquals(true, result[0]);
	        Assert.assertEquals(true, result[1]);
	        Assert.assertEquals(false, result[2]);
	    }

	    @Test(expected = UnauthorizedException.class)
	    public void testCheckRole() {
	        login("classpath:shiro-role.ini", "zhang", "123");
	        //����ӵ�н�ɫ��role1
	        subject().checkRole("role1");
	        //����ӵ�н�ɫ��role1 and role3 ʧ���׳��쳣
	        subject().checkRoles("role1", "role3");
	    }
}
