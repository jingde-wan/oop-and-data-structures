import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;
public class AddOrangeFishButton extends Button {
  
  public AddOrangeFishButton (float x, float y) {
    super("Add Orange", x, y);
  }
  
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      Fish orange = new Fish();
      tank.objects.add(orange);
    }
  }
}
