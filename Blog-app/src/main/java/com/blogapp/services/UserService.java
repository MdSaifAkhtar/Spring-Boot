package com.blogapp.services;

import java.util.List;

import com.blogapp.payloads.UserDto;

public interface UserService {
	
	
	UserDto CreateUser(UserDto user);
	
	UserDto UpdateUser(UserDto user ,Integer userId);
	
	UserDto getUderById(Integer userId);
	
	List<UserDto> getAllUser();
	
	void DeleteUser(Integer userId);
	
	
	

}
