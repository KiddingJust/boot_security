package org.kidding.security;

import java.util.stream.Collectors;

import org.kidding.domain.Member;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class KiddingSecurityUser extends User {



	private Member member;
	
	//map은 타입을 다른 애로 바꿔주는 것
	//각각의 auth를 simplegranted~ 로 바꾸고 이를 다시 collect로 모아
	public KiddingSecurityUser(Member member) {
		
		super(member.getMid(), member.getMpw(),
		member.getAuthList().stream()
		 .map(auth -> new SimpleGrantedAuthority("ROLE_" + auth.getAuth()))
		 .collect(Collectors.toList())
		);
		
		
		this.member = member;
	}
		
//	//안쓸거
//	public KiddingSecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//		// TODO Auto-generated constructor stub
//	}
	
	
}
