package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MUser {
	private String userId;
	private String password;
	private String userName;
	private Integer age;
	private Date birthday;
	private Integer gender;
	private String role;
	
}
