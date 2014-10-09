package com.salmon.scommerce.security.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.salmon.scommerce.core.domain.User;

public class PasswordHelper {
	
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName;
    private int hashIterations;
    
    public PasswordHelper(String algorithmName, int hashIterations, RandomNumberGenerator randomNumberGenerator) {
    	this.algorithmName = algorithmName;
    	this.hashIterations = hashIterations;
    	this.randomNumberGenerator = randomNumberGenerator;
    }

    public void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }

}
