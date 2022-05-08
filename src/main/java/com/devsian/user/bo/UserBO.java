package com.devsian.user.bo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devsian.user.dao.UserDAO;
import com.devsian.user.dto.UserCreateDTO;
import com.devsian.user.dto.UserReadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserBO {
	private final UserDAO userDAO;

	public List<UserReadDTO> selectAll() {
		var users = userDAO.selectAll();

		return users.stream()
			.map(UserReadDTO::new)
			.collect(Collectors.toList());
	}

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
