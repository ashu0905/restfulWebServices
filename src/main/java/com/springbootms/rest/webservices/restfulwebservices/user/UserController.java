package com.springbootms.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	public UserController(UserService userService, PostService postService) {
		this.userService = userService;
		this.postService = postService;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.createUser(user);

		/*
		 * URI location = ServletUriComponentsBuilder .fromCurrentRequest()
		 * .path("/{id}") .buildAndExpand(savedUser.getId()).toUri();
		 */
		
//		return ResponseEntity.created(location).build();
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		Optional<User> user = Optional.ofNullable(userService.getUser(id));
		if(user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			throw new UserNotFoundException("User with id: " + id + " doesn't exist");
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User with id: " + id + " deleted successfully", HttpStatus.OK);
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Post> createPost(@PathVariable("id") int id, @RequestBody Post post) {
		Optional<User> userOptional = Optional.ofNullable(userService.getUser(id));
		if(!userOptional.isPresent()) 
			throw new UserNotFoundException("User with id: " + id + " doesn't exist");
		User user = userOptional.get();
		Post savedPost = postService.createPost(user, post);
		return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}/posts")
	public ResponseEntity<List<Post>> getPosts(@PathVariable("id") int id) {
		Optional<User> userOptional = Optional.ofNullable(userService.getUser(id));
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User with id: " + id + " doesn't exist");
		}
		List<Post> posts = postService.getPosts(userOptional, id);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
}