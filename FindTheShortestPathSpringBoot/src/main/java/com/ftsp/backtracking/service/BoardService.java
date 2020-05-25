package com.ftsp.backtracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ftsp.backtracking.ftsp.Algorithm;
import com.ftsp.backtracking.model.BoardParameters;
import com.ftsp.backtracking.rep.BoardRepository;

@Service
public class BoardService {
private final BoardRepository DB;
	
	@Autowired
	public BoardService(BoardRepository DB) {
		this.DB = DB;
	}
	
	public void runFTSP() {
		Algorithm ftps = new Algorithm();
		ftps.run();
	}
	
	public ResponseEntity<String> insertBoardEntry(BoardParameters parameters) {
		if (!DB.existsById(parameters.getBoardName())) {
			DB.save(parameters); 
			return ResponseEntity.ok(parameters.getBoardName() + " saved successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The following board size already exists in the database: " + parameters.getBoardName());
		}
	}
	
	public List<BoardParameters> showAllBoardEntries() {
		return (List<BoardParameters>) DB.findAll();
	}
	
	public BoardParameters replaceParameters(String boardName) {
		DB.findById(boardName);
		return null;
	}
	
	public BoardParameters showBoardEntry(String boardName) {
		return DB.findById(boardName).get();
	}
}
