package com.ftsp.backtracking.ftsp;

import com.ftsp.backtracking.StaticParameters;
import com.ftsp.backtracking.model.BoardParameters;

public class Algorithm {
	
	private Board board;
	private int currentLength, shortestLength;

	
	public Algorithm(BoardParameters parameters) {
		board = new Board(parameters);
	}
	
	
	public void findShortestPath(String direction) {		
		currentLength++;
		board.move(direction);
		board.addCellVisited();
		
		if (board.goalReached()) {
			if (currentLength < shortestLength) {
				shortestLength = currentLength;
				board.saveSolution();
			}
			
			System.out.println("A solution was found with length " + currentLength + "!");
			board.showEndVisuals();
		} else {
			if (board.neighbourCellIsFree(StaticParameters.LEFT) && (!board.neighbourCellIsVisited(StaticParameters.LEFT))) {
				findShortestPath(StaticParameters.LEFT);
			}
			if (board.neighbourCellIsFree(StaticParameters.UP) && (!board.neighbourCellIsVisited(StaticParameters.UP))) {
				findShortestPath(StaticParameters.UP);
			}
			if (board.neighbourCellIsFree(StaticParameters.RIGHT) && (!board.neighbourCellIsVisited(StaticParameters.RIGHT))) {
				findShortestPath(StaticParameters.RIGHT);
			}
			if (board.neighbourCellIsFree(StaticParameters.DOWN) && (!board.neighbourCellIsVisited(StaticParameters.DOWN))) {
				findShortestPath(StaticParameters.DOWN); 
			}
		}
		
		board.removeCellVisited();
		board.moveOppositeDirection(direction);
		currentLength--;
	}
	
	
	public void run() {
		shortestLength = Integer.MAX_VALUE;
		currentLength = 0;
		
		findShortestPath(StaticParameters.INITIALIZE);
		
		if (!(shortestLength == Integer.MAX_VALUE)) {
			System.out.println("\nThis is (one of) the shortest path(s) with a length of " + shortestLength + "!");
			board.printSolution();
		} else {
			System.out.println("\nThis rendering does not have a solution!");
		}
	}
}
