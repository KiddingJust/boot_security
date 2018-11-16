package org.kidding.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

//어노테이션 만으로도 셋팅 가능해지도록
@EnableWebSecurity
@Log
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new KiddingUserService();
	}

	//얘는 이제 필요 없는 코드 (스프링 업데이트 되면서,,,)
//	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
//		log.warning("================configureGlobal===============");
//		
//		auth.userDetailsService(userDetailsService())
//			.passwordEncoder(passwordEncoder());
//		
//	}
	
	
	//없으면 모든 페이지 접속 시 로그인 창으로 이동함. 스프링부트의 기본 셋팅
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("-----------------------------------------");
		log.info("configure");
		log.info("-----------------------------------------");
		
		http.formLogin();
		http.rememberMe().tokenValiditySeconds(60*60*24);
	}
	
}
