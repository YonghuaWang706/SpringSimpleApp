package com.example.spinrgrest_yonghua.service;

import com.example.spinrgrest_yonghua.dao.UserDao;
import com.example.spinrgrest_yonghua.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	private final UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public void registerUser(User user){
		userDao.add(user);
	}

	public int deleteUser(Long id){
		return userDao.deleteGivenID(id);
	}

	public int updateStatus(boolean newStatus, Long id){
		return userDao.updateStatus(newStatus, id);
	}

	public User findByID(Long id){
		return userDao.findById(id);
	}

	public List<User> getAll(){
		return userDao.getAll();
	}
}
