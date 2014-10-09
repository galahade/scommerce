package com.salmon.scommerce.test.shiro;


import junit.framework.Assert;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class EncodeTest {
	
	@Test
	public void testBase64Encode() {
		String str = "hello";
		
		String base64Encoded = Base64.encodeToString(str.getBytes());
		System.out.println(base64Encoded);
		String str2 = Base64.decodeToString(base64Encoded);
		Assert.assertEquals(str, str2);
		
	}
	
	@Test
	public void testhashEncode() {
		String str = "hello";
		String salt = "123";
		String md5 = new Md5Hash(str,salt).toString();
		System.out.println(md5);
	}

}
