package com.example.CodeSquadBoard.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.CodeSquadBoard.user.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
