//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 - Decoration
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

/**
 * The Decoration class represents the data type for fish objects which will be created and used in the
 * FishTank application.
 *
 * @author Daidan Lu & Jingde Wan
 */
public class Decoration {
  // stores the reference to the PApplet object which represents the display window of this
  // application
  private static PApplet processing;
  // stores the reference to the image object of this fish
  private PImage image;
  // represents the x-position of this fish
  private float x;
  // represents the y-position of this fish
  private float y;
  // indicated whether this fish is being dragged or not
  private boolean isDragging;
  // stores the old x-position of the mouse
  private static int oldMouseX;
  // stores the old y-position of the mouse
  private static int oldMouseY;
  
  /**
   * Creates a new decoration object located at a specific (x, y) position of the display window
   * @param processing PApplet object that represents the display window
   * @param x x-position of the image of this fish in the display window
   * @param y y-position of the image of this fish in the display window
   * @param ImageFileName file name of the image of the fish to be created
   */
  public Decoration(PApplet processing, float x, float y, String imageFileName) {
    // processing: PApplet reference to the display window of the Fish Tank
    // application
    Decoration.processing = processing;
    // x: x-position of this decoration object
    this.x = x;
    // y: y-position of this decoration object
    this.y = y;
    // imageFileName: filename of the image to be loaded for this object
    this.image = processing.loadImage(imageFileName);
  }

  /**
   * Get the image of this decoration object
   * @return the image of this decoration object
   */
  public PImage getImage() {
    return this.image;
  }

  /**
   * Get the x-position of this decoration object
   * @return the x-position of this decoration object
   */
  public float getPositionX() {
    return this.x;
  }

  /**
   * Get the y-position of this decoration object
   * @return the y-position of this decoration object
   */
  public float getPositionY() {
    return this.y;
  }

  /**
   * Checks whether this decoration object is being dragged
   * @return true if the object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return this.isDragging;
  }

  /**
   * Starts dragging this decoration object
   * Sets the oldMouseX and oldMouseY to the current position of the mouse
   */
  public void startDragging() {
    // sets oldMouseX data field to the current x-position of the mouse
    processing.mouseX = Decoration.oldMouseX;
    // sets oldMouseY data field to the current y-position of the mouse
    processing.mouseY = Decoration.oldMouseY;
    // sets the isDragging data field of this fish to true
    this.isDragging = true;
  }

  /**
   * Stops dragging this decoration object
   */
  public void stopDragging() {
    // sets the isDragging data field of this fish to false
    this.isDragging = false;
  }

  /**
   * Checks whether the mouse is over this decoration object
   * @return true if the mouse is over this decoration object false otherwise
   */
  public boolean isMouseOver() {
    int decorationWidth = this.getImage().width;
    int decorationHeight = this.getImage().height;

    // checks if the mouse is over the provided fish
    return processing.mouseX >= this.getPositionX() - decorationWidth / 2.0f
        && processing.mouseX <= this.getPositionX() + decorationWidth / 2.0f
        && processing.mouseY >= this.getPositionY() - decorationHeight / 2.0f
        && processing.mouseY <= this.getPositionY() + decorationHeight / 2.0f;
  }

  /**
   * Moves this decoration object with dx and dy
   * @param dx distance moving to the x-position of this fish
   * @param dy distance moving to the y-position of this fish
   */
  public void move(int dx, int dy) {
    // dx move to the x-position of this decoration object
    // dy move to the y-position of this decoration object
    // adds dx move to the x-position of this fish
    this.x += dx;
    // adds dy move to the y-position of this fish
    this.y += dy;
  }

  /**
   * Draws this decoration to the display window.
   * This method sets also the position of this object to follow the moves of the mouse if it is being dragged
   */
  public void draw() {
    if (this.isDragging) {
      move(processing.mouseX - Decoration.oldMouseX, processing.mouseY - Decoration.oldMouseY);
      Decoration.oldMouseX = (int) this.x;
      Decoration.oldMouseY = (int) this.y;
    }

    // 2. draw this decoration to the display window by calling processing.image() method
    processing.image(this.image, this.x, this.y);
  }
}
