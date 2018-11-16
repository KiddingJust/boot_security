package org.kidding.persistence;

import org.kidding.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String>{
	
	
}
