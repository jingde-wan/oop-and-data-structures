import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class AddBlueFishButton extends Button {
  
  public AddBlueFishButton (float x, float y) {
    super("Add Blue", x, y);
  }
  
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      BlueFish blue = new BlueFish();
      tank.objects.add(blue);
    }
  }
  
}
