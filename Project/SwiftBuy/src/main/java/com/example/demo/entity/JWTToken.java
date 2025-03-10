package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tokens")
public class JWTToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer token_id;
	
	@ManyToOne
	@JoinColumn(name ="user_id", nullable = false )
	private Users user;
	
	@Column(name = "jwt_token" ,nullable = false)
	private String token;
	
	@Column(nullable = false)
	private LocalDateTime expires_at;
	
	public JWTToken() {
		
	}

	public JWTToken(Integer token_id, Users user, String token, LocalDateTime expires_at) {
		super();
		this.token_id = token_id;
		this.user = user;
		this.token = token;
		this.expires_at = expires_at;
	}

	public JWTToken(Users user, String token, LocalDateTime expires_at) {
		super();
		this.user = user;
		this.token = token;
		this.expires_at = expires_at;
	}

	public Integer getToken_id() {
		return token_id;
	}

	public void setToken_id(Integer token_id) {
		this.token_id = token_id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpires_at() {
		return expires_at;
	}

	public void setExpires_at(LocalDateTime expires_at) {
		this.expires_at = expires_at;
	}
}