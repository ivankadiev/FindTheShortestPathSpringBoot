package com.ftsp.backtracking.ftsp;

import javax.swing.JLabel;

import com.ftsp.backtracking.StaticParameters;
import com.ftsp.backtracking.model.BoardParameters;

public class Board {

	private Canvas board;
	private BoardParameters parameters;
	private JLabel[][] solution;
	
	private boolean[][] visitedCells;
	private int xPosition, yPosition;
	
	
	Board(BoardParameters parameters) {
		this.parameters = parameters;
		
		visitedCells = new boolean[this.parameters.getxBoxes()][this.parameters.getyBoxes()];
		solution = new JLabel[this.parameters.getxBoxes()][this.parameters.getyBoxes()];
		
		xPosition = this.parameters.getInitialXPosition();
		yPosition = this.parameters.getInitialYPosition();
		
		board = new Canvas(parameters);
	}		
	
	
	public void move(String direction) {
		switch (direction) {
		case StaticParameters.LEFT: updateVisuals(StaticParameters.PATH, xPosition, --yPosition); break;
		case StaticParameters.UP: updateVisuals(StaticParameters.PATH, --xPosition, yPosition); break;	
		case StaticParameters.RIGHT: updateVisuals(StaticParameters.PATH, xPosition, ++yPosition); break;	
		case StaticParameters.DOWN: updateVisuals(StaticParameters.PATH, ++xPosition, yPosition); break;
		} 
	}
	
	
	public void moveOppositeDirection(String direction) {
		switch (direction) {
		case StaticParameters.LEFT: updateVisuals(StaticParameters.EMPTY, xPosition, yPosition++); break;
		case StaticParameters.UP: updateVisuals(StaticParameters.EMPTY, xPosition++, yPosition); break;
		case StaticParameters.RIGHT: updateVisuals(StaticParameters.EMPTY, xPosition, yPosition--); break;
		case StaticParameters.DOWN: updateVisuals(StaticParameters.EMPTY, xPosition--, yPosition); break;
		} 
	}
	
	
	private void updateVisuals(String object, int x, int y) {
		try {
			Thread.sleep(parameters.getWait());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (!(board.isEnd(x, y))) {
			board.changeLabelTo(object, x, y);
		}
	}
	
	
	public void showEndVisuals() {
		board.changeLabelTo(StaticParameters.PATH, xPosition, yPosition);
		
		try {
			Thread.sleep(parameters.getWait());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		board.changeLabelTo(StaticParameters.END, xPosition, yPosition);
	}
	
	
	public boolean neighbourCellIsFree(String direction) {
		switch (direction) {
		case StaticParameters.LEFT: return (!(board.isBoulder(xPosition, yPosition-1))); 
		case StaticParameters.UP: return (!(board.isBoulder(xPosition-1, yPosition))); 
		case StaticParameters.RIGHT: return (!(board.isBoulder(xPosition, yPosition+1))); 
		case StaticParameters.DOWN: return (!(board.isBoulder(xPosition+1, yPosition)));
		} 
		
		System.out.println("Incorrect command.");
		System.exit(0);
		return true;
	}
	
	
	public boolean neighbourCellIsVisited(String direction) {
		switch (direction) {
		case StaticParameters.LEFT: return (visitedCells[xPosition][yPosition-1]); 
		case StaticParameters.UP: return (visitedCells[xPosition-1][yPosition]); 
		case StaticParameters.RIGHT: return (visitedCells[xPosition][yPosition+1]);
		case StaticParameters.DOWN: return (visitedCells[xPosition+1][yPosition]);
		} 
		
		System.out.println("Incorrect command.");
		System.exit(0);
		return true;
	}
	
	
	public void addCellVisited() {
		visitedCells[xPosition][yPosition] = true;
	}
	
	
	public void removeCellVisited() {
		visitedCells[xPosition][yPosition] = false;
	}
	
	
	public boolean goalReached() {
		return (board.isEnd(xPosition, yPosition));
	}
	
	
	public void saveSolution() {
		for (int x=0; x<parameters.getxBoxes(); x++) {
    		for (int y=0; y<parameters.getyBoxes(); y++) {
    			solution[x][y] = new JLabel();
    			solution[x][y].setIcon(board.getJLabel(x, y).getIcon()); 
    		}
    	}
	}
	
	
	public void printSolution() {
		board.printBoard(solution);
	}
}
