package com.devsian.user.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsian.user.entity.User;
import com.devsian.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDAO {
	private final UserRepository userRepository;

	public List<User> selectAll() {
		return userRepository.selectAll();
	}
}
