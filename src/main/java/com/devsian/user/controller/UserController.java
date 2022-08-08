package com.devsian.user.controller;

import com.devsian.user.SessionConst;
import com.devsian.user.bo.UserBO;
import com.devsian.user.dto.UserCreateDTO;
import com.devsian.user.dto.UserLoginDTO;
import com.devsian.user.dto.UserReadDTO;
import com.devsian.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserBO userBO;


	@GetMapping("/v1.0/users/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			// 세션 삭제
			log.info("sessionId={}", session.getId());
			log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
			log.info("creationTime={}", new Date(session.getCreationTime()));
			log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
			log.info("isNew={}", session.isNew());
			session.invalidate();
		}

		return ResponseEntity.status(200).body("logout success");
	}

	@GetMapping("/v1.0/users")
	public ResponseEntity<List<UserReadDTO>> getUsers() {
		var userReadDTOList = userBO.selectAll();
		return ResponseEntity.ok(userReadDTOList);
	}

	@PostMapping("/v1.0/users/login")
	public ResponseEntity<Void> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
		UserReadDTO loginUser = userBO.login(userLoginDTO.getUserId(), userLoginDTO.getPassword());
		if(loginUser == null) {
			// 해당 유저가 없는 경우 로그인 실패, 인증되지 않음. --> 403
			return ResponseEntity.status(403).build();
		}

		// 세션 매니저를 통해 세션 생성 및 회원정보 보관
		log.info("creating session... user = {}", loginUser);
		HttpSession session = request.getSession(true);
		session.setAttribute(SessionConst.LOGIN_USER, loginUser);

		log.info("sessionId={}", session.getId());
		log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
		log.info("creationTime={}", new Date(session.getCreationTime()));
		log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
		log.info("isNew={}", session.isNew());

		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@PostMapping("/v1.0/users")
	public ResponseEntity<Void> createUser(@RequestBody UserCreateDTO userCreateDTO, HttpServletRequest request) throws IOException {
		log.info("user create requested... user={}", userCreateDTO);
		if(!userBO.isUserIdDuplicated(userCreateDTO)){
			userBO.createUser(userCreateDTO);
			/*
			TODO : 회원가입 완료 후 FE에 다른 창으로 이동하라고 어떻게 알려줄 것인가
			 */
			return ResponseEntity.noContent().build();
		}
		// 유저 중복으로 가입이 안되는 경우 인증되지 않음 --> 403
		return ResponseEntity.status(403).build();
	}

	@GetMapping("/v1.0/user/test")
	public String homeLogin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "fail";
		}

		UserReadDTO loginUser = (UserReadDTO) session.getAttribute(SessionConst.LOGIN_USER);
		if(loginUser == null) {
			return "login*UserFail";
		}
		return loginUser.getUserId();
	}

}
