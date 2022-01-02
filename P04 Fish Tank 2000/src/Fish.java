//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 - Fish
// Course: CS 300 Fall 2021
//
// Author: Jingde Wan
// Email: wan38@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Daidan Lu
// Partner Email: dlu59@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

/**
 * The Fish class represents the data type for fish objects which will be created and used in the
 * FishTank application.
 *
 * @author Daidan Lu & Jingde Wan
 */
public class Fish {
  // stores the reference to the PApplet object which represents the display window of this
  // application
  private static PApplet processing;
  // stores the reference to the image object of this fish
  private PImage image;
  // represents the x-position of this fish
  private float x;
  // represents the y-position of this fish
  private float y;
  // represents the swimming speed of this fish
  private int speed;
  // indicated whether this fish is being dragged or not
  private boolean isDragging;
  // indicated whether this fish is swimming (moving) or not
  private boolean isSwimming;
  // stores the old x-position of the mouse
  private static int oldMouseX;
  // stores the old y-position of the mouse
  private static int oldMouseY;

  /**
   * Creates a new fish object located at a specific (x, y) position of the display window
   * @param processing PApplet object that represents the display window
   * @param x x-position of the image of this fish in the display window
   * @param y y-position of the image of this fish in the display window
   * @param speed the swimming speed of this fish
   * @param fishImageFileName file name of the image of the fish to be created
   */
  public Fish(PApplet processing, float x, float y, int speed, String fishImageFileName) {
    // processing PApplet object that represents the display window
    Fish.processing = processing;
    // x x-position of the image of this fish in the display window
    this.x = x;
    // y y-position of the image of this fish in the display window
    this.y = y;
    // speed the swimming speed of this fish
    this.speed = speed;
    this.isDragging = false;
    this.isSwimming = false;
    // fishImageFileName file name of the image of the fish to be created
    this.image = processing.loadImage(fishImageFileName);
  }

  /**
   * Creates a new fish object positioned at the center of the display window.
   * @param processing PApplet object that represents the display window
   */
  public Fish(PApplet processing) {
    // processing PApplet object that represents the display window
    Fish.processing = processing;
    // This constructor sets the image instance field to
    // a PImage whose file name is "images" + File.separator + "orange.png"
    this.image = processing.loadImage("images" + File.separator + "orange.png");
    // Sets speed instance field to 5
    this.speed = 5;
    // Sets the x and y position of the fish to the center of the display window
    this.x = processing.width / 2.0f;
    this.y = processing.height / 2.0f;
    // The created fish won’t be dragging nor swimming.
    this.isDragging = false;
    this.isSwimming = false;
  }

  /**
   * Get the image of type PImage of this fish
   * @return the image of type PImage of this fish
   */
  public PImage getImage() {
    // getter of the image instance field
    return this.image;
  }

  /**
   * Get the x-position of this fish in the display window
   * @return the x-position of this fish in the display window
   */
  public float getPositionX() {
    // getter of the x-position of this fish
    return this.x;
  }

  /**
   * Get the y-position of this fish in the display window
   * @return the y-position of this fish in the display window
   */
  public float getPositionY() {
    // getter of the y-position of this fish
    return this.y;
  }

  /**
   * Moves this fish with dx and dy
   * @param dx distance moving to the x-position of this fish
   * @param dy distance moving to the y-position of this fish
   */
  public void move(int dx, int dy) {
    // adds dx move to the x-position of this fish
    this.x += dx;
    // adds dy move to the y-position of this fish
    this.y += dy;
  }

  /**
   * Checks whether this fish is being dragged
   * @return true if the fishes is being dragged otherwise false
   */
  public boolean isDragging() {
    // a getter for the isDragging instance field
    return this.isDragging;
  }

  /**
   * Starts dragging this fish
   */
  public void startDragging() {
    // sets oldMouseX data field to the current x-position of the mouse
    Fish.oldMouseX = processing.mouseX;
    // sets oldMouseY data field to the current y-position of the mouse
    Fish.oldMouseY = processing.mouseY;
    // sets the isDragging data field of this fish to true
    this.isDragging = true;
  }

  /**
   * Stops dragging this fish
   */
  public void stopDragging() {
    // sets the isDragging data field of this fish to false
    this.isDragging = false;
  }

  /**
   * Draws this fish to the display window.
   * This method sets also the position of this fish to follow the moves of the mouse if it is being dragged
   */
  public void draw() {
    // 1. if this fish is dragging, move it with (dx, dy) to follow the moves of the mouse
    // [HINT] use the current position (processing.mouseX and processing.mouseY)
    // of the mouse with respect to the old position of the mouse to compute dx and dy moves
    // Make sure to update oldMouseX and oldMouseY after moving the fish
    if (this.isDragging) {
      move(processing.mouseX - Fish.oldMouseX, processing.mouseY - Fish.oldMouseY);
      Fish.oldMouseX = (int) this.x;
      Fish.oldMouseY = (int) this.y;
    }

    if (this.isSwimming) {
      this.swim();
    }

    // 2. draw this fish to the display window by calling processing.image() method
    processing.image(this.image, this.x, this.y);
  }

  /**
   * Checks if the mouse is over a given fish whose reference is provided as input parameter
   *
   * @return true if the mouse is over the given fish object (i.e. over the image of the fish),
   *         false otherwise
   */
  public boolean isMouseOver() {
    int fishWidth = this.getImage().width;
    int fishHeight = this.getImage().height;

    // checks if the mouse is over the provided fish
    return processing.mouseX >= this.getPositionX() - fishWidth / 2.0f
        && processing.mouseX <= this.getPositionX() + fishWidth / 2.0f
        && processing.mouseY >= this.getPositionY() - fishHeight / 2.0f
        && processing.mouseY <= this.getPositionY() + fishHeight / 2.0f;
  }

  /**
   * Starts swimming this fish
   */
  public void startSwimming() {
    // 1. stops dragging the fish
    this.isDragging = false;
    // 2. sets the isSwimming instance field to true
    this.isSwimming = true;
  }

  /**
   * Stops swimming this fish
   */
  public void stopSwimming() {
    // Sets the isSwimming instance field of this fish to false
    this.isSwimming = false;
  }

  /**
   * Moves horizontally the fish one speed step from left to right
   */
  public void swim() {
    // The speed step is the instance field speed defined for each fish
    // Note that x-position of the fish is bounded by the width of the display
    // window. If the x-position of this fish exceeds the width of the display
    // window, it is going to be set to zero. You may think of using the
    // modulo operator to implement this property.
    this.x += this.speed;
    this.x %= processing.width;
  }

}
