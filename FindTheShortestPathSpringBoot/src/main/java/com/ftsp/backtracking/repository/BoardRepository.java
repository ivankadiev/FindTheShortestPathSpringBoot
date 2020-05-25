package com.ftsp.backtracking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ftsp.backtracking.StaticParameters;
import com.ftsp.backtracking.model.BoardParameters;

@Repository
public interface BoardRepository extends CrudRepository<BoardParameters, String> {
	
	
	default void replaceByID(String boardName, BoardParameters newParameters) {
		BoardParameters parameters = findById(boardName).get();
		
		if(newParameters.getBoardName() != StaticParameters.EMPTY) {
			parameters.setBoardName(boardName);
		}
		
		if(newParameters.getxPixelSize() != 0) {
			parameters.setxPixelSize(newParameters.getxPixelSize());
		}
		
		if(newParameters.getyPixelSize() != 0) {
			parameters.setyPixelSize(newParameters.getyPixelSize());
		}
		
		if(newParameters.getxBoxes() != 0) {
			parameters.setxBoxes(newParameters.getxBoxes());
		}
		
		if(newParameters.getyBoxes() != 0) {
			parameters.setyBoxes(newParameters.getyBoxes());
		}
		
		if(newParameters.getInitialXPosition() != 0) {
			parameters.setInitialXPosition(newParameters.getInitialXPosition());
		}
		
		if(newParameters.getInitialYPosition() != 0) {
			parameters.setInitialYPosition(newParameters.getInitialYPosition());
		}
		
		if(newParameters.getFinalXPosition() != 0) {
			parameters.setFinalXPosition(newParameters.getFinalXPosition());
		}
		
		if(newParameters.getFinalYPosition() != 0) {
			parameters.setFinalYPosition(newParameters.getFinalYPosition());
		}
		
		if(newParameters.getPercentChance() != 0) {
			parameters.setPercentChance(newParameters.getPercentChance());
		}
		
		if(newParameters.getWait() != 0) {
			parameters.setWait(newParameters.getWait());
		}
		
		deleteById(boardName);
		save(parameters);
	}
}
