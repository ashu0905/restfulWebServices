package com.springbootms.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private Date birth_date;

	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Post> posts;

	protected User() {

	}

	public User(Integer id, String name, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.birth_date = birth_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public List<Post> getPosts() {
		return posts;
	}

//	public void setPosts(List<Post> posts) {
//		this.posts = posts;
//	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birth_date=%s]", id, name, birth_date);
	}
}