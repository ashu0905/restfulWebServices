package com.springbootms.rest.webservices.restfulwebservices.user;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springbootms.rest.webservices.restfulwebservices.jpa.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	private static int usersCount = 3;
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User createUser(@RequestBody User user) {
		/*
		 * if (user.getId() == null) { user.setId(++usersCount); } users.add(user);
		 * return user;
		 */
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
//		return users;
		return userRepository.findAll();
	}

	@Override
	public User getUser(int id) {
//		for (User user : users) {
//			if (user.getId() == id) {
//				return user;
//			}
//		}
//		return null;
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteUser(int id) {
//		Iterator<User> iterator = users.iterator();
//		while (iterator.hasNext()) {
//			User user = iterator.next();
//			if (user.getId() == id) {
//				iterator.remove();
//				return user;
//			}
//		}
//		return null;
		userRepository.deleteById(id);
	}
}