package com.blogapp.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.payloads.ApiResponse;
import com.blogapp.payloads.UserDto;
import com.blogapp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto)
	{
		UserDto createUser = this.userservice.CreateUser(userdto);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto, @PathVariable("userId") Integer uid)
	{
		UserDto updateUser = this.userservice.UpdateUser(userdto, uid);
		return ResponseEntity.ok(updateUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<UserDto> DeleteUser( @PathVariable("userId") Integer uid)
	{
		this.userservice.DeleteUser(uid);
	 return new ResponseEntity( new ApiResponse("user Deleted Sucessfully",true),HttpStatus.OK);
	
}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getsingle( @PathVariable("userId") Integer uid)
	{
		return new ResponseEntity(userservice.getUderById(uid),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		return new ResponseEntity(userservice.getAllUser(),HttpStatus.OK);
	}
	
		
	}

