package com.blogapp.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourcename;
	String fileldName;
	long fildValue;
	
	public ResourceNotFoundException(String resourcename, String fileldName, long fildValue) {
		super(String.format( "%s not found  with %s : %s",resourcename ,fileldName,fildValue));
		this.resourcename = resourcename;
		this.fileldName = fileldName;
		this.fildValue = fildValue;
	}

	
}
