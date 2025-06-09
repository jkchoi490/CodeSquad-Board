package com.example.CodeSquadBoard.comment.dto;

import java.time.LocalDateTime;

public class CommentResponseDto {

	String id;
	String content;

	String writer;

	Long boardId;

	LocalDateTime createdAt;

	LocalDateTime updatedAt;

}
