package com.ftsp.backtracking.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ftsp.backtracking.model.BoardParameters;
import com.ftsp.backtracking.service.BoardService;

@RestController
public class Controller {

	private final BoardService boardService;
	
	@Autowired
	public Controller(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping(path = "/run")
	public void executeFTSP() {
		boardService.runFTSP();
	}
	
	@GetMapping
	public List<BoardParameters> showAllBoardEntries() {
		return boardService.showAllBoardEntries();
	}
	
	@PostMapping
	public void insertBoardEntry(@RequestBody BoardParameters parameters) {
		boardService.insertBoardEntry(parameters);
	}
}
