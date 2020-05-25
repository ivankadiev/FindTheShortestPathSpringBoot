package com.ftsp.backtracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ftsp.backtracking.ftsp.Algorithm;
import com.ftsp.backtracking.model.BoardParameters;
import com.ftsp.backtracking.repository.BoardRepository;

@Service
public class BoardService {
	
	private final BoardRepository DB;
	
	
	@Autowired
	public BoardService(BoardRepository DB) {
		this.DB = DB;
	}
	
	
	public ResponseEntity<String> runFTSP(String boardName) {
		Algorithm ftps = new Algorithm(DB.findById(boardName).get());
		int shortestLength = ftps.run();
		
		if (shortestLength != Integer.MAX_VALUE) {
			return ResponseEntity.ok("This is the shortest path with a length of " + shortestLength + "!");
		} else {
			return ResponseEntity.ok("This rendering does not have a solution!");
		}
	}
	
	
	public List<BoardParameters> showAllBoardEntries() {
		return (List<BoardParameters>) DB.findAll();
	}
	
	
	public BoardParameters showBoardEntry(String boardName) {
		if (DB.existsById(boardName)) {			
			return DB.findById(boardName).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	
	public ResponseEntity<String> insertBoardEntry(BoardParameters parameters) {
		if (!DB.existsById(parameters.getBoardName())) {
			DB.save(parameters); 
			
			return ResponseEntity.ok(parameters.getBoardName() + " saved successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(parameters.getBoardName() + " already exists in the database.");
		}
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
	
	
	public ResponseEntity<String> deleteBoardEntry(String boardName) {
		if (DB.existsById(boardName)) {
			DB.deleteById(boardName);
			
			return ResponseEntity.ok(boardName + " deleted successfully.");
		} else {
			String badRequest = ("The board entry (" + boardName + ") does not exists in the database.\n"
							   + "Please create the entry " + boardName + " first in order to delete it.");
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((badRequest));
		}
	}
	
	
	public ResponseEntity<String> deleteAllBoardEntries() {
		DB.deleteAll();
		
		return ResponseEntity.ok("All board entries deleted successfully.");
	}	
}