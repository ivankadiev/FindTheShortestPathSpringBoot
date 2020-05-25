package com.ftsp.backtracking.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftsp.backtracking.model.BoardParameters;
import com.ftsp.backtracking.service.BoardService;

@RequestMapping("board_db")
@RestController
public class Controller {

	private final BoardService boardService;

	
	@Autowired
	public Controller(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@GetMapping(path = "/all")
	public List<BoardParameters> showAllBoardEntries() {
		return boardService.showAllBoardEntries();
	}
	
	
	@GetMapping(path = "{name}")
	public BoardParameters showBoardEntry(@PathVariable("name") String boardName) {
		return boardService.showBoardEntry(boardName);
	}
	
	
	@GetMapping(path = "{name}/run")
	public ResponseEntity<String> executeFTSP(@PathVariable("name") String boardName) {
		return boardService.runFTSP(boardName);
	}
	
	
	@PostMapping
	public ResponseEntity<String> insertBoardEntry(@RequestBody BoardParameters parameters) {
		return boardService.insertBoardEntry(parameters);
	}
	
	
	@PutMapping(path = "{name}")
	public ResponseEntity<String> changeParameters(@PathVariable("name") String boardName, @RequestBody BoardParameters parameters) {
		return boardService.replaceParameters(boardName, parameters);
	}
	
	
	@DeleteMapping(path = "{name}")
	public ResponseEntity<String> deleteBoardEntry(@PathVariable("name") String boardName) {
		return boardService.deleteBoardEntry(boardName);
	}
	
	
	@DeleteMapping(path = "/all")
	public ResponseEntity<String> deleteAllBoardEntries() {
		return boardService.deleteAllBoardEntries();
	}
}
