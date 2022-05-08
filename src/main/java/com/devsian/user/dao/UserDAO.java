package com.devsian.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.devsian.user.entity.User;

@Mapper
public interface UserDAO {

	@Select("SELECT * FROM user")
	List<User> selectAll();

}
