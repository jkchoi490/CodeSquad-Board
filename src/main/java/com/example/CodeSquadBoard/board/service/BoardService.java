package com.example.CodeSquadBoard.board.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CodeSquadBoard.board.dto.BoardRequestDto;
import com.example.CodeSquadBoard.board.entity.Board;
import com.example.CodeSquadBoard.board.repository.BoardRepository;
import com.example.CodeSquadBoard.user.entity.User;
import com.example.CodeSquadBoard.user.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;

	//게시글 생성
	@Transactional
	public Long save(BoardRequestDto boardRequestDto){

		Long userId = boardRequestDto.getUserId();
		//1. 작성자 조회
		 User user = userRepository.findById(userId)
			 .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 ID 입니다"));
		 System.out.println("userId : "+userId);
		Board board = Board.builder()
			.user(user)
			.title(boardRequestDto.getTitle())
			.content(boardRequestDto.getContent())
			.author(user.getNickname())
			.viewCount(0)
			.createdAt(LocalDateTime.now())
			.updatedAt(LocalDateTime.now())
			.comments(new ArrayList<>())
			.build();

		Board savedBoard = boardRepository.save(board);

		return savedBoard.getId();
	}

}
