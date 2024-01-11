package com.springbootms.rest.webservices.restfulwebservices.user;

import java.util.List;

public interface UserService {
	User createUser(User user);
	
	List<User> getUsers();
	
	User getUser(int id);
	
	void deleteUser(int id);
}