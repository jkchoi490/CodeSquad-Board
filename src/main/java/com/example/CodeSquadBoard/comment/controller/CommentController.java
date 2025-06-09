package com.example.CodeSquadBoard.comment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CodeSquadBoard.comment.dto.CommentRequestDto;
import com.example.CodeSquadBoard.comment.repository.CommentRepository;
import com.example.CodeSquadBoard.comment.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/api/comment/save")
	public ResponseEntity<Long> saveComment(
		@RequestBody CommentRequestDto commentRequestDto
	){
		try {
			Long id = commentService.saveComment(commentRequestDto);
			return ResponseEntity.ok(id);
		} catch (Exception e) {
			throw new IllegalArgumentException("게시글 저장 오류");
		}
	}

}
