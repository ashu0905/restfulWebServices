package com.springbootms.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

public interface PostService {
	Post createPost(User user, Post post);

	List<Post> getPosts(Optional<User> userOptional, int id);
}