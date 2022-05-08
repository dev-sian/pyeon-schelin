package com.devsian.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devsian.user.bo.UserBO;
import com.devsian.user.dto.UserCreateDTO;
import com.devsian.user.dto.UserReadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserBO userBO;

	@GetMapping("/v1.0/users")
	public ResponseEntity<List<UserReadDTO>> getUsers() {
		var userReadDTOList = userBO.selectAll();
		return ResponseEntity.ok(userReadDTOList);
	}


	@PostMapping("/v1.0/users")
	public ResponseEntity<UserReadDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
		log.info("user create requested. user={}", userCreateDTO);

		var userReadDTO = userBO.createUser(userCreateDTO);
		return ResponseEntity.ok(userReadDTO);
	}
}
