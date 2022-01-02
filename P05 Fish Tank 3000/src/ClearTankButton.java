import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class ClearTankButton extends Button {

  public ClearTankButton (float x, float y) {
    super("clear", x, y);
  }
  
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      tank.clear();
    }
  }
}
