package com.blogapp.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.entities.User;
import com.blogapp.payloads.UserDto;
import com.blogapp.repository.UserRepo;
import com.blogapp.services.UserService;
import com.blogapp.exception.*;

@Service
public class UsersServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDto CreateUser(UserDto user) {
		
		User user1 = this.dtoToUser(user);
		User saveUser = repo.save(user1);
		return this.userToUserDto(saveUser);
	
	}

	@Override
	public UserDto UpdateUser(UserDto userdto, Integer userId) {
	
		User user = repo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
	
	user.setName(userdto.getName());
	user.setAbout(userdto.getAbout());
	user.setEmail(userdto.getEmail());
	user.setPasword(userdto.getPasword());
	User updatedUser = this.repo.save(user);
      UserDto userToUserDto = userToUserDto(updatedUser);
      return userToUserDto;
	
	}

	@Override
	public UserDto getUderById(Integer userId) {
	
		User user = repo.findById(userId).orElseThrow(()-> new  ResourceNotFoundException("User", "id", userId));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User>  users= this.repo.findAll();
		 List<UserDto> userDtos = users.stream().map(user-> this.userToUserDto(user)).collect(Collectors.toList());
		 return userDtos;
	}

	@Override
	public void DeleteUser(Integer userId) {
		 User orElseThrow = repo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
          repo.delete(orElseThrow);
	}
	
	private User dtoToUser(UserDto userdto)
	{
		
		User map = this.mapper.map(userdto, User.class);
//		User user = new User();
//		user.setId(userdto.getId());
//		user.setName(userdto.getName());
//		user.setAbout(userdto.getAbout());
//		user.setPasword(userdto.getPasword());
//		user.setEmail(userdto.getEmail());
//		
		return map;
		
		
	}
	
	private UserDto userToUserDto(User user)
	{
		
		UserDto map = this.mapper.map(user, UserDto.class);
		
//		UserDto userdto = new UserDto();
//		
//		userdto.setId(user.getId());
//		userdto.setName(user.getName());
//		userdto.setAbout(user.getAbout());
//		userdto.setPasword(user.getPasword());
//		userdto.setEmail(user.getEmail());
//	
		return map;
		
		
	}
	
	

}
