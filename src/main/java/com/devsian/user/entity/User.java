package com.devsian.user.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	Integer id;
	String userId;
	String name;
	String password;
	Integer tier;

	public User(Integer id) {
		this.id = id;
	}
}
