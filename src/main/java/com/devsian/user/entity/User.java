package com.devsian.user.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	String id;
	String userId;
	String name;
	String password;
	Integer tier;
}
