package org.kidding.security;

import org.kidding.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
public class KiddingUserService implements UserDetailsService{

	@Setter(onMethod_= @Autowired)
	private MemberRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warning("==========================================");
		log.warning("==========================================");
		//username은 부트에서는 id에 해당함
		log.warning("loadUser " + username);
		log.warning("==========================================");
		log.warning("==========================================");

		return repo.findById(username)
				.filter(vo -> vo != null)
				.map(vo -> new KiddingSecurityUser(vo))
				.get();
		
//		Member member = repo.findById(username).get();
//		
//		log.warning("" + member);
//
//		log.warning("==========================================");
//		log.warning("==========================================");
	}

	
	
}
