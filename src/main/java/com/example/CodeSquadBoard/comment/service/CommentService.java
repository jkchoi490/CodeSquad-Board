package com.example.CodeSquadBoard.comment.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CodeSquadBoard.board.entity.Board;
import com.example.CodeSquadBoard.board.repository.BoardRepository;
import com.example.CodeSquadBoard.comment.dto.CommentRequestDto;
import com.example.CodeSquadBoard.comment.entity.Comment;
import com.example.CodeSquadBoard.comment.repository.CommentRepository;
import com.example.CodeSquadBoard.user.entity.User;
import com.example.CodeSquadBoard.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	private final CommentRepository commentRepository;

	@Transactional
	public Long saveComment(CommentRequestDto commentRequestDto){
		Long boardId = commentRequestDto.getBoardId();
		Long userId = commentRequestDto.getUserId();

		//게시글 조회
		Board board = boardRepository.findById(boardId)
			.orElseThrow(()-> new IllegalArgumentException("게시글이 존재하지 않습니다"));

		User user = userRepository.findById(userId)
			.orElseThrow(()-> new IllegalArgumentException("유저가 존재하지 않습니다"));
		Comment comment = Comment.builder()
			.content(commentRequestDto.getContent())
			.createdAt(LocalDateTime.now())
			.updatedAt(LocalDateTime.now())
			.user(user)
			.board(board)
			.build();

		Comment savedComment = commentRepository.save(comment);



		return savedComment.getId();
	}


}
