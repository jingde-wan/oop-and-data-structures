import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class Fish extends TankObject {
  private int speed;
  private boolean isSwimming;
  
  
  // constructor 1
  public Fish(int speed, String fishImageFileName){
    super(tank.randGen.nextInt(tank.width), tank.randGen.nextInt(tank.height), fishImageFileName);
    
    if (speed <= 0) {
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    }
    
    this.speed = speed;
    
  }
  
  // constructor 2
  public Fish() {
    this(5, "images" + File.separator + "orange.png");
  }
  
  // Overrides the draw() method implemented in the parent class.
  // This method sets the position of this fish to follow the
  // mouse moves if it is dragging, calls its swim() method
  // if it is swimming, and draws it to the display window.
  // You can use a partial overriding (call draw() method of
  // the super class and adds the behavior specific to drawing a fish.
  public void draw() {
    // may be wrong
    super.draw();
    if (this.isSwimming) {
      swim();
    }
    tank.image(this.image, this.getX(), this.getY());
  }

  // Checks whether this fish is swimming
  public boolean isSwimming() {
    return this.isSwimming;
  }

  // Starts swimming this fish
  public void startSwimming() {
    this.stopDragging();
    this.isSwimming = true;
  }

  // Stops swimming this fish
  public void stopSwimming() {
    this.isSwimming = false;
  }

  // Gets the speed of this fish
  public int speed() {
    return this.speed;
  }

  // Moves horizontally the fish one speed step from left to right.
  public void swim() {
    this.setX((this.getX() + this.speed) % tank.width);
  }
  
}
