package com.salmon.scommerce.test.shiro;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

public class RoleTest extends BaseTest {

	 @Test
	    public void testHasRole() {
	        login("classpath:shiro-role.ini", "zhang", "123");
	        //ÅÐ¶ÏÓµÓÐ½ÇÉ«£ºrole1
	        Assert.assertTrue(subject().hasRole("role1"));
	        //ÅÐ¶ÏÓµÓÐ½ÇÉ«£ºrole1 and role2
	        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
	        //ÅÐ¶ÏÓµÓÐ½ÇÉ«£ºrole1 and role2 and !role3
	        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
	        Assert.assertEquals(true, result[0]);
	        Assert.assertEquals(true, result[1]);
	        Assert.assertEquals(false, result[2]);
	    }

	    @Test(expected = UnauthorizedException.class)
	    public void testCheckRole() {
	        login("classpath:shiro-role.ini", "zhang", "123");
	        //¶ÏÑÔÓµÓÐ½ÇÉ«£ºrole1
	        subject().checkRole("role1");
	        //¶ÏÑÔÓµÓÐ½ÇÉ«£ºrole1 and role3 Ê§°ÜÅ×³öÒì³£
	        subject().checkRoles("role1", "role3");
	    }
}
