package com.example.spinrgrest_yonghua.dto;

import com.example.spinrgrest_yonghua.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
public class AllUserInfo {
	private final Long id;
	private final String username;

	public static List<AllUserInfo> parseInfoFromUsers(List<User> users){
		return users.stream().map(e-> AllUserInfo.builder().id(e.getId()).username(e.getUsername()).build()).collect(Collectors.toList());
	}
}
