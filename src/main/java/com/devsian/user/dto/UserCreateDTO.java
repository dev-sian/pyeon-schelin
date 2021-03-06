package com.devsian.user.dto;

import javax.validation.constraints.NotBlank;

import com.devsian.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCreateDTO {
	@NotBlank
	String userId;

	@NotBlank
	String name;

	@NotBlank
	String password;

	public User toUser() {
		var user = new User();
		user.setUserId(userId);
		user.setName(name);
		user.setPassword(password);
		user.setTier(0);

		return user;
	}
}
