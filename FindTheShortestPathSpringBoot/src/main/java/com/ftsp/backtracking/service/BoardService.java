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
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(parameters.getBoardName() + " already exists in the database.");
		}
	}
	
	public List<BoardParameters> showAllBoardEntries() {
		return (List<BoardParameters>) DB.findAll();
	}
	
	public ResponseEntity<String> replaceParameters(String boardName, BoardParameters parameters) {
		if (DB.existsById(boardName)) {
			DB.replaceByID(boardName, parameters); 
			return ResponseEntity.ok(boardName + " updated successfully.");
		} else {
			String badRequest = ("The board entry (" + boardName + ") does not exists in the database.\n"
							   + "Please create the entry " + boardName + " first in order to update it.");
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((badRequest));
		}
	}
	
	public BoardParameters showBoardEntry(String boardName) {
		return DB.findById(boardName).get();
	}
}
