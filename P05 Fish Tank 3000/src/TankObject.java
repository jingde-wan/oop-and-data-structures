import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class TankObject implements TankListener {
  protected static FishTank tank; // PApplet object which represents
  //the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object
  //is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse
  
  // constructor
  public TankObject(float x, float y, String imageFileName) {
    // set the image of TankObject
    this.image = tank.loadImage(imageFileName);
    // sets the position of this TankObject
    this.x = x;
    this.y = y;
    // initially the fish is not dragging
    this.isDragging = false; 
  }
  
  // Sets the PApplet graphic display window for all TankObjects
  public static void setProcessing(FishTank tank) {
    TankObject.tank = tank;  
  }

  // Moves this tank object with dx and dy
  // dx move to the x-position of this tank object
  // dy move to the y-position of this tank object
  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  // Returns the x-position of this tank object
  public float getX() {
    return this.x;
  }

  // Returns the y-position of this tank object
  public float getY() {
    return this.y;
  }

  // Sets the x-position of this object
  public void setX(float x) {
    this.x = x;
  }

  // Sets the y-position of this object
  public void setY(float y) {
    this.y = y;
  }
  
  // Returns the image of this tank object
  public PImage getImage() {
    return this.image;
  }

  // Getter of the isDragging field.
  // returns true if this object is being dragged, false otherwise
  public boolean isDragging() {
    return this.isDragging;
  }

  // Starts dragging this tank object
  public void startDragging() {
    oldMouseX = tank.mouseX;
    oldMouseY = tank.mouseY;
    this.isDragging = true;
  }

  // Stops dragging this tank object
  public void stopDragging() {
    this.isDragging = false;
  }
  
  //draws this tank object to the display window
  @Override
  public void draw() {
    if (this.isDragging) {
      int dx = tank.mouseX - oldMouseX;
      int dy = tank.mouseY - oldMouseY;
      move(dx, dy);
      oldMouseX = tank.mouseX;
      oldMouseY = tank.mouseY;
    }
    
    tank.image(this.image, this.x, this.y);
  }
  
  //checks whether the mouse is over this Tank GUI
  // return true if the mouse is over this tank GUI object, false otherwise
  @Override
  public boolean isMouseOver() {
    return tank.mouseX >= x - image.width / 2 && tank.mouseX <= x + image.width / 2
        && tank.mouseY >= y - image.height / 2 && tank.mouseY <= y + image.height / 2;
  }
  
  //called each time the mouse is Pressed
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      this.startDragging();
    }
  }
  
  //called each time the mouse is Released
  @Override
  public void mouseReleased() {
    this.stopDragging();
  }
}
