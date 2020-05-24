package com.ftsp.backtracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void insertBoardEntry(BoardParameters parameters) {
		DB.save(parameters);
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
