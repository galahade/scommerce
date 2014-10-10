package com.salmon.scommerce.core.services;

import com.salmon.scommerce.core.domain.NewUser;

public interface NewUserService {
	
	public int registerNewUser(NewUser newUser);
	
	public int loginUser(NewUser newUser);

}
