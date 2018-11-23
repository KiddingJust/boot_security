package org.kidding.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kidding.domain.UserVO;
import org.kidding.service.KakaoLogin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.java.Log;

@RestController
@Log
public class KakaoLoginController {

	@RequestMapping(value = "/kakaologin" , produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public void kakaoLogin(@RequestParam("code") String code , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{

	  JsonNode token = KakaoLogin.getAccessToken(code);
	  log.info("=====" + code);
	  log.info("=====" + token);
	  
	  JsonNode profile = KakaoLogin.getKakaoUserInfo(token.path("access_token").toString());
	  System.out.println("profile: " + profile);
	  
	  UserVO vo = KakaoLogin.changeData(profile);

	  System.out.println("session: " + session);
	  session.setAttribute("login", vo);
	  System.out.println(vo.toString());
	  
	 
	}
}
