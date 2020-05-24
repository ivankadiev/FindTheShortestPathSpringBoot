package com.ftsp.backtracking.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftsp.backtracking.model.BoardParameters;
import com.ftsp.backtracking.service.BoardService;

@RequestMapping("board_parameters")
@RestController
public class Controller {

	private final BoardService boardService;
	
	@Autowired
	public Controller(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping
	public List<BoardParameters> showAllBoardEntries() {
		return boardService.showAllBoardEntries();
	}
	
	@GetMapping(path = "{name}")
	public BoardParameters showBoardEntry(@PathVariable("name") String boardName) {
		return boardService.showBoardEntry(boardName);
	}
	
	@GetMapping(path = "/run")
	public void executeFTSP() {
		boardService.runFTSP();
	}
	
	@PostMapping
	public void insertBoardEntry(@RequestBody BoardParameters parameters) {
		boardService.insertBoardEntry(parameters);
	}
	
	@PutMapping(path = "{name}")
	public BoardParameters changeParameters(@PathVariable("name") String boardName) {
		return boardService.replaceParameters(boardName);
	}
}
