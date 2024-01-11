package com.springbootms.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootms.rest.webservices.restfulwebservices.jpa.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	private PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Post createPost(User user, Post post) {
		post.setUser(user);
		return postRepository.save(post);
	}

	@Override
	public List<Post> getPosts(Optional<User> userOptional, int id) {
		User user = userOptional.get();
		return user.getPosts();
	}
}