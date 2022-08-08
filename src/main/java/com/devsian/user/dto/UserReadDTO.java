package com.devsian.user.dto;

import com.devsian.user.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
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
