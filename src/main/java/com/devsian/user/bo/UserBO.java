package com.devsian.user.bo;

import com.devsian.user.dao.UserDAO;
import com.devsian.user.dto.UserCreateDTO;
import com.devsian.user.dto.UserReadDTO;
import com.devsian.user.entity.User;
import com.devsian.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserBO {
	private final UserDAO userDAO;
	private final String salt = BCrypt.gensalt();
	public UserReadDTO login(String userId, String password) {
		User user = userDAO.selectByUserIdAndPassword(userId, BCrypt.hashpw(password, salt));
		if(user == null) return null;
		return new UserReadDTO(user);
	}

	public List<UserReadDTO> selectAll() {
		var users = userDAO.selectAll();

		return users.stream()
			.map(UserReadDTO::new)
			.collect(Collectors.toList());
	}

	@Transactional
	public Boolean isUserIdDuplicated(UserCreateDTO userCreateDTO) {
		UserVO userVO = userDAO.selectByUserId(userCreateDTO.getUserId());
		if(userVO != null) {
			// 해당 유저가 이미 있는 경우
			return true;
		} else return false;
	}

	@Transactional
	public UserReadDTO createUser(UserCreateDTO dto) {
		User user = dto.toUser();
		user.setPassword(BCrypt.hashpw(user.getPassword(), salt));
		try {
			userDAO.insert(user);
		} catch (Exception e) {
			log.error("user create fail. user={}, e=",
				user, e);
		}
		return new UserReadDTO(user);
	}
}
