import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class BlackFish extends Fish {
  private TankObject source;
  private TankObject destination;
  
  public BlackFish(TankObject source, TankObject destination) {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
  }
  
  // makes one speed move towards destination
  // see hints below
  public void moveTowardsDestination() {
    float dx = destination.getX() - this.getX();
    float dy = destination.getY() - this.getY();
    int d = (int) Math.sqrt(dx*dx + dy*dy);
    this.setX(this.getX() + this.speed() * dx / d);
    this.setY(this.getY() + this.speed() * dy / d);
  }

  // returns true if this black fish is over another tank object, and false otherwise
  // see hints below
  public boolean isOver(TankObject other) {
    float x1 = this.getX() - this.image.width / 2;
    float y1 = this.getY() - this.image.height / 2;
    float x2 = this.getX() + this.image.width / 2;
    float y2 = this.getY() + this.image.height / 2;
    float x3 = other.getX() - other.image.width / 2;
    float y3 = other.getY() - other.image.height / 2;
    float x4 = other.getX() + other.image.width / 2;
    float y4 = other.getY() + other.image.height / 2;
    
    
    return (x1 < x4) && (x3 < x2) && (y1 < y4) && (y3 < y2);
  }

  // Overrides Fish.swim() method
  @Override
  public void swim() {
    // move the fish towards its destination
    // if destination is reached (meaning this fish is over its destination,
    // switch source and destination
    
    if (!this.isOver(destination)) {
      moveTowardsDestination();
    } else {
      TankObject temp = source;
      this.source = this.destination;
      this.destination = temp;
      moveTowardsDestination();
    }
    // may be wrong
  }

  
}
