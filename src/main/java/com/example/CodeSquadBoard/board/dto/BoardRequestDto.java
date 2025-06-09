package com.example.CodeSquadBoard.board.dto;

import com.example.CodeSquadBoard.board.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardRequestDto {

	String title;
	String content;
	Long userId;
}
