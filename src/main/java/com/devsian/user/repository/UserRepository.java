package com.devsian.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.devsian.user.entity.User;

@Mapper
public interface UserRepository {

	@Select("SELECT * FROM user")
	List<User> selectAll();

}
