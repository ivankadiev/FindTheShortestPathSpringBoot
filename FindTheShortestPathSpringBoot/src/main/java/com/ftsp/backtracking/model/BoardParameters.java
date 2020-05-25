package com.ftsp.backtracking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftsp.backtracking.StaticParameters;

@Entity
@Table(name = "boardparameters")
public class BoardParameters {
	
	@Id
	@Column(name = "BOARDNAME")
	private String boardName;
	
	@Column(name = "XPIXELSIZE")
	private int xPixelSize; // Set the number of pixels the JPanel displays on the x axis
	
	@Column(name = "YPIXELSIZE")
	private int yPixelSize; // Set the number of pixels the JPanel displays on the y axis
	
	@Column(name = "XBOXES")
	private int xBoxes; // Set the number of boxes the JPanel grid has on the x axis
	
	@Column(name = "YBOXES")
	private int yBoxes; // Set the number of boxes the JPanel grid has on the y axis
	
	@Column(name = "INITIALXPOSITION")
	private int initialXPosition; // Set the initial position of the path on the x axis
	
	@Column(name = "INITIALYPOSITION")
	private int initialYPosition; // Set the initial position of the path on the y axis
	
	@Column(name = "FINALXPOSITION")
	private int finalXPosition; // Set the final position of the path on the x axis
	
	@Column(name = "FINALYPOSITION")
	private int finalYPosition; // Set the final position of the path on the y axis
	
	@Column(name = "PERCENTCHANCE")
	private double percentChance; // Set the percentage chance of a random boulder being placed on the board
	
	@Column(name = "WAIT")
	private int wait; // Control the animation speed
	
	
	protected BoardParameters() {}
	
	
	// For creating a new object with a name
	public BoardParameters(@JsonProperty("name") String boardName,
						   @JsonProperty("xpixels") int xPixelSize, 
						   @JsonProperty("ypixels") int yPixelSize, 
						   @JsonProperty("xboxes") int xBoxes, 
						   @JsonProperty("yboxes") int yBoxes, 
						   @JsonProperty("initxpos") int initialXPosition,
						   @JsonProperty("initypos") int initialYPosition, 
						   @JsonProperty("finalxpos") int finalXPosition, 
						   @JsonProperty("finalypos") int finalYPosition, 
						   @JsonProperty("chance") double percentChance, 
						   @JsonProperty("wait") int wait) {		
		this.boardName = boardName;
		this.xPixelSize = xPixelSize;
		this.yPixelSize = yPixelSize;
		this.xBoxes = xBoxes;
		this.yBoxes = yBoxes;
		this.initialXPosition = initialXPosition;
		this.initialYPosition = initialYPosition;
		this.finalXPosition = finalXPosition;
		this.finalYPosition = finalYPosition;
		this.percentChance = percentChance;
		this.wait = wait;
	}
	
	
	// For creating a new object without a name
	public BoardParameters(@JsonProperty("xpixels") int xPixelSize, 
						  @JsonProperty("ypixels") int yPixelSize, 
						  @JsonProperty("xboxes") int xBoxes, 
						  @JsonProperty("yboxes") int yBoxes, 
						  @JsonProperty("initxpos") int initialXPosition,
						  @JsonProperty("initypos") int initialYPosition, 
						  @JsonProperty("finalxpos") int finalXPosition, 
						  @JsonProperty("finalypos") int finalYPosition, 
						  @JsonProperty("chance") double percentChance, 
						  @JsonProperty("wait") int wait) {		
		this.boardName = StaticParameters.EMPTY;
		this.xPixelSize = xPixelSize;
		this.yPixelSize = yPixelSize;
		this.xBoxes = xBoxes;
		this.yBoxes = yBoxes;
		this.initialXPosition = initialXPosition;
		this.initialYPosition = initialYPosition;
		this.finalXPosition = finalXPosition;
		this.finalYPosition = finalYPosition;
		this.percentChance = percentChance;
		this.wait = wait;
	}
	
		
	public String getBoardName() {
		return boardName;
	}
	
	
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	

	public int getxPixelSize() {
		return xPixelSize;
	}
	

	public void setxPixelSize(int xPixelSize) {
		this.xPixelSize = xPixelSize;
	}
	

	public int getyPixelSize() {
		return yPixelSize;
	}
	

	public void setyPixelSize(int yPixelSize) {
		this.yPixelSize = yPixelSize;
	}
	

	public int getxBoxes() {
		return xBoxes;
	}

	
	public void setxBoxes(int xBoxes) {
		this.xBoxes = xBoxes;
	}
	

	public int getyBoxes() {
		return yBoxes;
	}
	

	public void setyBoxes(int yBoxes) {
		this.yBoxes = yBoxes;
	}
	

	public int getInitialXPosition() {
		return initialXPosition;
	}
	

	public void setInitialXPosition(int initialXPosition) {
		this.initialXPosition = initialXPosition;
	}
	

	public int getInitialYPosition() {
		return initialYPosition;
	}
	

	public void setInitialYPosition(int initialYPosition) {
		this.initialYPosition = initialYPosition;
	}
	

	public int getFinalXPosition() {
		return finalXPosition;
	}
	

	public void setFinalXPosition(int finalXPosition) {
		this.finalXPosition = finalXPosition;
	}
	

	public int getFinalYPosition() {
		return finalYPosition;
	}
	

	public void setFinalYPosition(int finalYPosition) {
		this.finalYPosition = finalYPosition;
	}
	

	public double getPercentChance() {
		return percentChance;
	}
	

	public void setPercentChance(double percentChance) {
		this.percentChance = percentChance;
	}
	

	public int getWait() {
		return wait;
	}
	

	public void setWait(int wait) {
		this.wait = wait;
	}	
}
