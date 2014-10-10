package com.salmon.scommerce.core.services.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salmon.scommerce.core.domain.NewUser;
import com.salmon.scommerce.core.services.NewUserService;
import com.salmon.scommerce.persistence.domain.AdminUser;
import com.salmon.scommerce.persistence.services.UserPersistenceService;

@Component
public class NewUserServiceHandler implements NewUserService {
    
	@Autowired
	UserPersistenceService userService;
	
	public NewUserServiceHandler(){}

	@Override
	public int registerNewUser(NewUser newUser) {
		
		AdminUser newAdminUser = new AdminUser();
		newAdminUser.setFirstname(newUser.getFirstname());
		newAdminUser.setLastname(newUser.getLastname());
		newAdminUser.setUsername(newUser.getUsername());
		newAdminUser.setPassword(newUser.getPassword());
		newAdminUser.setEmail(newUser.getEmail());
		
		List<AdminUser> oldAdminUsers = userService.findAdminUsers(newAdminUser);
		
		if(oldAdminUsers.size() > 0){
			System.out.println("Duplicated user profile!");
			
			return 0;
		}
		
		int created = userService.createAdminUser(newAdminUser);
		
		if(created < 1){
			System.out.println("Creating new User failed!");
			return 0;
		}
		
		return 1;
	}
	
}
