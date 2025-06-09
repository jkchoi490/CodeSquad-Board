package com.example.CodeSquadBoard.comment.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

	String content;
	Long userId;
	Long boardId;
}
