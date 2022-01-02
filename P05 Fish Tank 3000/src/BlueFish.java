import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class BlueFish extends Fish {
  
  public BlueFish () {
    super(2, "images" + File.separator + "blue.png");
  }
  
  @Override
  public void swim() {
    this.setX((this.getX() - this.speed() + tank.width) % tank.width);
  }
  
}
