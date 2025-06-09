package com.example.CodeSquadBoard.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.CodeSquadBoard.board.dto.BoardRequestDto;
import com.example.CodeSquadBoard.board.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {


	private final BoardService boardService;

	@PostMapping("/api/board/save")
	public ResponseEntity<Long> saveBoard(
		@RequestBody BoardRequestDto dto) {
		log.info(dto.getTitle()," ",dto.getContent()," ",dto.getUserId());
		try {
		Long id = boardService.save(dto);
			return ResponseEntity.ok(id);
		} catch (Exception e) {
			throw new IllegalArgumentException("게시글 저장 오류");
		}
	}


}
