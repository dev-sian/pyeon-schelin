package com.devsian.user.dao;

import java.util.List;

import com.devsian.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.devsian.user.entity.User;

@Mapper
public interface UserDAO {

	@Select("SELECT * FROM user")
	List<User> selectAll();

	UserVO selectByUserId(String userId);

	User selectByUserIdAndPassword(String userId, String password);

	void insert(User user);

}
