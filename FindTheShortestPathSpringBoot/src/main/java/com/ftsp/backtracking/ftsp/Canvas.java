package com.ftsp.backtracking.ftsp;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ftsp.backtracking.StaticParameters;
import com.ftsp.backtracking.model.BoardParameters;

public class Canvas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private BoardParameters parameters;
    private JPanel panel;
    private JLabel[][] gridBoxes;
    private ImageIcon boulder, path, end;
    
    
    Canvas(BoardParameters parameters) {
    	this.parameters = parameters;
    	
    	createBoard();	
    }
    
    
    private void createBoard() {
    	setTitle("Find The Shortest Path"); 
    	setSize(parameters.getxPixelSize(), parameters.getyPixelSize());
    	
    	panel = new JPanel(new GridLayout(parameters.getxBoxes(), parameters.getyBoxes()));
    	panel.setBackground(Color.DARK_GRAY);
    	setContentPane(panel);
    	
    	loadImages();
    	initializeBoard();
    	
    	setResizable(false);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }

    
    private void loadImages() {
    	try {
    		boulder = new ImageIcon(ImageIO.read(new File("src\\main\\resources\\static\\icons\\boulder.png")));
    		path = new ImageIcon(ImageIO.read(new File("src\\main\\resources\\static\\icons\\path.png")));
    		end = new ImageIcon(ImageIO.read(new File("src\\main\\resources\\static\\icons\\end.png")));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
    private void initializeBoard() {
    	gridBoxes = new JLabel[parameters.getxBoxes()][parameters.getyBoxes()];
    	
    	for (int x=0; x<parameters.getxBoxes(); x++) {
    		for (int y=0; y<parameters.getyBoxes(); y++) {
    			gridBoxes[x][y] = new JLabel();
    			gridBoxes[x][y].setVerticalAlignment(JLabel.CENTER);
    			gridBoxes[x][y].setHorizontalAlignment(JLabel.CENTER);
    	    	panel.add(gridBoxes[x][y]);
    	    	
    	    	if ((x==0) || (x==parameters.getxBoxes()-1) || (y==0) || (y==parameters.getyBoxes()-1)) {
    	    		// Create a frame boulder around the board
    	    		changeLabelTo(StaticParameters.BOULDER, x, y);
    	    	} else if ((x==parameters.getInitialXPosition()) && (y==parameters.getInitialYPosition())) {
    	    		// Set initial position
    	    		changeLabelTo(StaticParameters.PATH, x, y);
    	    	} else if ((x==parameters.getFinalXPosition()) && (y==parameters.getFinalYPosition())) {
    	    		// Set Final position
    	    		changeLabelTo(StaticParameters.END, x, y);
    	    	} else {
    	    		// Put boulders on random positions on the board
    	    		Random rand = new Random();
    	    		double chanceOfBoulder = rand.nextDouble();
    	    		
    	    		if (chanceOfBoulder <= parameters.getPercentChance()) {
    	    			changeLabelTo(StaticParameters.BOULDER, x, y);
    	    		}
    	    	}
    		}
    	}
    }
    
    
    public void printBoard(JLabel[][] solution) {
    	for (int x=0; x<parameters.getxBoxes(); x++) {
    		for (int y=0; y<parameters.getyBoxes(); y++) {
    			gridBoxes[x][y].setIcon(solution[x][y].getIcon());
    		}
    		
    		changeLabelTo(StaticParameters.PATH, parameters.getFinalXPosition(), parameters.getFinalYPosition());
    	}
    }
    
    
    public void changeLabelTo(String object, int x, int y) {
    	switch(object) {
    	case StaticParameters.PATH: gridBoxes[x][y].setIcon(path); break;
    	case StaticParameters.BOULDER: gridBoxes[x][y].setIcon(boulder); break;
    	case StaticParameters.END: gridBoxes[x][y].setIcon(end); break;
    	case StaticParameters.EMPTY: gridBoxes[x][y].setIcon(new ImageIcon()); break;
    	}
    }
    
    public boolean isBoulder(int x, int y) {
    	return (boulder.equals(gridBoxes[x][y].getIcon()));
    }
    
    public boolean isEnd(int x, int y) {
    	return (end.equals(gridBoxes[x][y].getIcon()));
    }
    
    public JLabel getJLabel(int x, int y) {
    	return gridBoxes[x][y];
    }
}
