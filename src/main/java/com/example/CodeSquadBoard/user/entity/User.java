package com.example.CodeSquadBoard.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "login_id",nullable = false)
	private String loginId;

	@Column(name = "nickname",nullable = false)
	private String nickname;

	@Column(name = "email",nullable = false)
	private String email;

	@Column(name = "password",nullable = false)
	private String password;

}
