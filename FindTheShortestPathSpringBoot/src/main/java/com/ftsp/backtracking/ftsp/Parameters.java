package com.ftsp.backtracking.ftsp;

import com.ftsp.backtracking.model.BoardParameters;

public class Parameters {

	public final int X_PIXEL_SIZE; // Set the number of pixels the JPanel displays on the x axis
	public final int Y_PIXEL_SIZE; // Set the number of pixels the JPanel displays on the y axis
	public final int X_BOXES; // Set the number of boxes the JPanel grid has on the x axis
	public final int Y_BOXES; // Set the number of boxes the JPanel grid has on the y axis
	public final int INITIAL_X_POSITION; // Set the initial position of the path on the x axis
	public final int INITIAL_Y_POSITION; // Set the initial position of the path on the y axis
	public final int FINAL_X_POSITION; // Set the final position of the path on the x axis
	public final int FINAL_Y_POSITION; // Set the final position of the path on the y axis
	
	public final double PERCENT_CHANCE; // Set the percentage chance of a random boulder being placed on the board
	public final int WAIT; // Control the animation speed
	
	public Parameters(BoardParameters parameters) {
		X_PIXEL_SIZE = parameters.getxPixelSize();
		Y_PIXEL_SIZE = parameters.getyPixelSize();
		X_BOXES = parameters.getxBoxes();
		Y_BOXES = parameters.getyBoxes();
		INITIAL_X_POSITION = parameters.getInitialXPosition();
		INITIAL_Y_POSITION = parameters.getInitialYPosition();
		FINAL_X_POSITION = parameters.getFinalXPosition();
		FINAL_Y_POSITION = parameters.getFinalYPosition();
		PERCENT_CHANCE = parameters.getPercentChance();
		WAIT = parameters.getWait();
	}
}