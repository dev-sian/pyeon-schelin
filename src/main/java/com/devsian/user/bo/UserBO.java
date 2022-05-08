package com.devsian.user.bo;

import org.springframework.stereotype.Service;

import com.devsian.user.dto.UserCreateDTO;
import com.devsian.user.dto.UserReadDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserBO {
	public UserReadDTO createUser(UserCreateDTO dto) {
		var user = dto.toUser();
		try {
			/**
			 * TODO - userDAO.createUser(user) 구현
			 * TODO - 비밀번호 암호화
			 */
			var createdUser = user;
		} catch (Exception e) {
			log.error("user create fail. user={}, e=",
				user, e);
		}
		return new UserReadDTO(user);
	}
}
