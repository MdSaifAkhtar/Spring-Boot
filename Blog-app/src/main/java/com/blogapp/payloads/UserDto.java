package com.blogapp.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
@Setter
@Getter

@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	@NonNull
	@Size(min = 4,message = "username must of 4 character")
	private String name;
	@NonNull
	@Size(max = 6,min = 4, message = "pasword must of min 4  characterand max 6 character" )
	private String pasword;
	@NotNull
	private String about;
	@Email(message = " Email address is not valid")
	private String email;

}
