import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class AddYellowFishButton extends Button {
  
  public AddYellowFishButton (float x, float y) {
    super("Add Yellow", x, y);
  }
  
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      Fish yellow = new Fish(2, "images" + File.separator + "yellow.png");
      tank.objects.add(yellow);
    }
  }
  
}
