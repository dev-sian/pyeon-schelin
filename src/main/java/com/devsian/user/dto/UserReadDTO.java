package com.devsian.user.dto;

import com.devsian.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserReadDTO {
	String userId;
	String name;
	Integer tier;

	public UserReadDTO(User user) {
		userId = user.getUserId();
		name = user.getName();
		tier = user.getTier();
	}
}
