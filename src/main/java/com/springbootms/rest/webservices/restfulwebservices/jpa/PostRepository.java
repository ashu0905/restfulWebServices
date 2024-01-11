package com.springbootms.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootms.rest.webservices.restfulwebservices.user.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{}