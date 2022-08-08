package com.example.spinrgrest_yonghua.controller;

import com.example.spinrgrest_yonghua.domain.User;
import com.example.spinrgrest_yonghua.domain.UserDetail;
import com.example.spinrgrest_yonghua.dto.AllUserInfo;
import com.example.spinrgrest_yonghua.dto.SingleUserResponse;
import com.example.spinrgrest_yonghua.exception.UserNotFoundException;
import com.example.spinrgrest_yonghua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAccountController {
	//User Registration
	//• Endpoint: POST /user
	//• Request Body: YES (You should pass in a JSON object that contains all the information
	//needed during the user registration, including username, password, first name, last name,
	//and email)
	//- Delete a User
	//• Endpoint: DELETE /user
	//• Request Parameter: userId - int
	//• Sample Request URL: http://{domain}/user?userId=3
	//- Activate/Deactivate a User
	//• Endpoint: PATCH /user/{userId}/status
	//• Path Variable: userId - int
	//• Request Parameter: activate - boolean
	//• Sample Request URL: http://{domain}/user/1/status?activate=false
	//- List all Users
	//• Endpoint: GET /user
	//• Note: Should list only the userId and username while returning the result
	//- Get User By user Id• Endpoint: GET /user/info/{userId}
	//• Path Variable: userId - int
	//• Note: Should return a JSON object contains user id, username, first name, last name, and
	//email.

	private final UserService service;

	@Autowired
	public UserAccountController(UserService service) {
		this.service = service;
	}


	@GetMapping
	public List<AllUserInfo> getAllUsers(){
		List<User> users = service.getAll();
		return AllUserInfo.parseInfoFromUsers(users);
	}

	@PostMapping
	public String registerUser(@ModelAttribute User user, @ModelAttribute UserDetail userDetail){
		user.setUserDetail(userDetail);
		user.setStatus(true);
		userDetail.setUser(user);
		service.registerUser(user);
		return "registration successful!";
	}

	@DeleteMapping
	public String deleteUser(@RequestParam(name = "userID") Long id) throws UserNotFoundException {
		int code = service.deleteUser(id);
		if(code == 1) return "delete successful!";
		throw new UserNotFoundException("user with id " + id + "not exists, delete fails");
		//return "user does not exist";
	}

	@PatchMapping(path = "/{userId}/status")
	public String updateUserStatus(@PathVariable(name = "userId") Long id, @RequestParam(name = "status") boolean status) throws UserNotFoundException {
		int code = service.updateStatus(status, id);
		if(code == 1) return "update successful!";
		throw new UserNotFoundException("user with id " + id + "not exists, update fails");
		//return "user does not exist";
	}

	@GetMapping(path = "/info/{userId}")
	public String getUserInfo(@PathVariable(name = "userId") Long id){
		User user = service.findByID(id);
		//if(user==null) return null;
//		return SingleUserResponse.builder().id(id).firstname(user.getUserDetail().getFirstname())
//				.lastname(user.getUserDetail().getLastname()).email(user.getUserDetail().getEmail())
//				.username(user.getUsername()).build();
		System.out.println(user);
		return "test";
	}


}
