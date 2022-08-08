package com.example.spinrgrest_yonghua.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Builder
@Getter
@Setter
public class SingleUserResponse {
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;

}
