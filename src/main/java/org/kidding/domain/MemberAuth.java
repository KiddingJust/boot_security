package org.kidding.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_member_auth")
public class MemberAuth {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ano;
	
	private String auth;
	
	//alt + shift + s
	public MemberAuth(String auth) {
		super();
		this.auth = auth;
	}
}
