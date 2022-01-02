//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Fish Tank 1000
// Course:   CS 300 Fall 2021
//
// Author:   Jingde Wan
// Email:    wan38@wisc.edu
// Lecturer: Dr. Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    None
// Partner Email:   None
// Partner Lecturer's Name: None
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class models a Fish Tank
 */
public class FishTank {
	private static PApplet processing; // PApplet object that represents the graphic
	// interface of the JunglePark application
	private static PImage backgroundImage; // PImage object that represents the
	// background image
	private static Fish[] fishes; // perfect size array storing the different fish present
	// in the fish tank. These fish can be of different species.
	private static Random randGen; // Generator of random numbers
	
	
	/**
	* Defines the initial environment properties of this application
	* @param processingObj a reference to the graphic display window of this application
	*/
	public static void setup(PApplet processingObj) {
//		System.out.println("Erdai Bro");
		processing = processingObj;
		// load the image of the background
		backgroundImage = processing.loadImage("images/background.png");
		
		fishes = new Fish[8];
		
		// set first of fishes array to a Fish object at a random position of the screen
		randGen = new Random();
		
	}
	
	
	/**
	* Draws and updates the application display window.
	* This callback method called in an infinite loop.
	*/
	public static void draw() {
				
		// Draw the background image at the center of the screen
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		// width [resp. height]: System variable of the processing library that stores
		// the width [resp. height] of the display window.
		
		for (int i=0; i<fishes.length; i++) {
			if (fishes[i] != null) {
				fishes[i].draw();
			}
		}
		
	}
	
	
	/**
	* Checks if the mouse is over a specific Fish whose reference is provided
	* as input parameter
	*
	* @param Fish reference to a specific fish
	* @return true if the mouse is over the specific Fish object (i.e. over
	* the image of the Fish), false otherwise
	*/
	public static boolean isMouseOver(Fish Fish) {
		
		// To avoid null exception error
		if (Fish != null) {
			float fishWidth = Fish.getImage().width;
			float fishHeight = Fish.getImage().height;
			
			// the coordinate of mouse is within the rectangular of fish
			if (Fish.getPositionX() + fishWidth/2 > processing.mouseX 
					&& Fish.getPositionX() - fishWidth/2 < processing.mouseX 
					&& Fish.getPositionY() + fishHeight/2 > processing.mouseY
					&& Fish.getPositionY() - fishHeight/2 < processing.mouseY) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	* Callback method called each time the user presses the mouse
	*/
	public static void mousePressed() {
		
		for (int i=0; i<fishes.length; i++) {
			if (isMouseOver(fishes[i])) {
				fishes[i].setDragging(true);
				break; // MAY BE WRONG
			}
		}
	}
	/**
	* Callback method called each time the mouse is released
	*/
	public static void mouseReleased() {
		for (int i=0; i<fishes.length; i++) {
			if (fishes[i] != null) {
				fishes[i].setDragging(false);
			}
		}
	}
	
	/**
	* Callback method called each time the user presses a key
	*/
	public static void keyPressed() {
		float randomX = (float)randGen.nextInt(processing.width);
		float randomY = (float)randGen.nextInt(processing.height);
		
		// add fish by pressing F/f
		if (processing.key == 'F' || processing.key == 'f') {
			for (int i=0; i<fishes.length; i++) {
				if (fishes[i] == null) {
					fishes[i] = new Fish(processing, randomX, randomY);
					break;
				}
			}
		}
		
		// remove fish where mouse is over by pressing R/r
		if (processing.key == 'R' || processing.key == 'r') {
			for (int i=0; i<fishes.length; i++) {
				if (isMouseOver(fishes[i])) {
					fishes[i] = null;
					break;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Utility.startApplication();
	}

}
