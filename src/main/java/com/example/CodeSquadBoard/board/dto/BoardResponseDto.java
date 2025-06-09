package com.example.CodeSquadBoard.board.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.CodeSquadBoard.comment.entity.Comment;

public class BoardResponseDto {

	Long id;
	String title;
	String content;
	String author;
	int viewCount;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;
	List<Comment> comments;
}
