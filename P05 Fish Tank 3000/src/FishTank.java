import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class FishTank extends PApplet {
  private PImage backgroundImage; // PImage object which represents the background image
  protected ArrayList<TankListener> objects; // list storing interactive objects
  protected Random randGen; // Generator of random numbers
  
  
//sets the size of this PApplet to 800 width x 600 height
 @Override
 public void settings() {
   size(800, 600);
 }

 // Defines initial environment properties such as screen size and
 // loads the background image and fonts as the program starts.
 // It also initializes all data fields.
 // The above IS NOT a javadoc style method header!
 @Override
 public void setup() {
   // Set and display the title of the display window
   this.getSurface().setTitle("Fish Tank 3000");
   // Set the location from which images are drawn to CENTER
   this.imageMode(PApplet.CENTER);
   // Set the location from which rectangles are drawn.
   this.rectMode(PApplet.CORNERS);
   // rectMode(CORNERS) interprets the first two parameters of rect() method
   // as the location of one corner, and the third and fourth parameters as
   // the location of the opposite corner.
   // rect() method draws a rectangle to the display window

   this.focused = true; // Confirms that our Processing program is focused,
   // meaning that it is active and will accept mouse or keyboard input.

   // sets the text alignment to center
   this.textAlign(PApplet.CENTER, PApplet.CENTER);

   // TODO load the background image and store the loaded image to backgroundImage
   // Note that you can call the loadImage() method directly (this.loadImage())
   backgroundImage = this.loadImage("images" + File.separator + "background.png");

   // TODO create an empty array list of objects
   objects = new ArrayList<TankListener>();

   // TODO set randGen to the reference of a new Random objects
   randGen = new Random();
   
   // set up the tank object with fish tank object
   TankObject.setProcessing(this);
   
   // declare the four private instance fields of type TankObject named flower, log, shell, and ship
   TankObject flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
   TankObject log = new TankObject(580, 470, "images" + File.separator + "log.png");
   TankObject shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
   TankObject ship = new TankObject(280, 535, "images" + File.separator + "ship.png");
   
   // add the four TankObject objects, flower, log, ship, and shell to the arraylist objects
   objects.add(flower);
   objects.add(log);
   objects.add(shell);
   objects.add(ship);
   
   // create two instances of the BlackFish class
   BlackFish blackfish1 = new BlackFish(log, flower);
   BlackFish blackfish2 = new BlackFish(shell, flower);
   
   // add them to the objects arraylist
   objects.add(blackfish1);
   objects.add(blackfish2);
   
   // set up the Button with fish tank object
   Button.setProcessing(this);
   
   // create four buttons at the following positions
   AddBlueFishButton bluefish = new AddBlueFishButton(43, 16);
   AddOrangeFishButton orangefish = new AddOrangeFishButton(129, 16);
   AddYellowFishButton yellowfish = new AddYellowFishButton(215, 16);
   ClearTankButton cleartank = new ClearTankButton(301, 16);
   
   // add them to the objects arraylist
   objects.add(bluefish);
   objects.add(orangefish);
   objects.add(yellowfish);
   objects.add(cleartank);
   
   
 }

 // Continuously draws and updates the application display window
 @Override
 public void draw() {
   // TODO clear the display window by drawing the background image
   this.image(backgroundImage, this.width / 2, this.height / 2);
   // TODO traverse the objects list and draw each of the objects to this display window
   for (int i=0; i<objects.size(); i++) {
     objects.get(i).draw();
   }

 }

 // Callback method called each time the user presses the mouse
 @Override
 public void mousePressed() {
   // TODO traverse the objects list and call mousePressed method
   // of the first object being clicked in the list
   for (int i=0; i<objects.size(); i++) {
     // may refer to old fish tank // may be wrong
     objects.get(i).mousePressed();
//     break;
   }
 }

 // Callback method called each time the mouse is released
 @Override
 public void mouseReleased() {
   // TODO traverse the objects list and call each object's mouseReleased() method
   for (int i=0; i<objects.size(); i++) {
     // may refer to old fish tank
     objects.get(i).mouseReleased();
   }
   
 }

 // adds an instance of TankListener passed as input to the objects arraylist
 public void addObject(TankListener object) {
   objects.add(object);

 }

 // Callback method called each time the user presses a key
 @Override
 public void keyPressed() {

   // To be implemented later in the next sections
   switch (Character.toUpperCase(this.key)) {
     case 'O':
       Fish orange = new Fish();
       objects.add(orange);
       break;
     case 'Y':
       Fish yellow = new Fish(2, "images" + File.separator + "yellow.png");
       objects.add(yellow);
       break;
     case 'R':
       for (int i=0; i<objects.size(); i++) {
         if ( (objects.get(i) instanceof Fish) && (objects.get(i).isMouseOver()) ) {
           objects.remove(i);
           break;
         }
       }
       break;
     case 'S':
       for (int i=0; i<objects.size(); i++) {
         if (objects.get(i) instanceof Fish) {
           // may be wrong
           Fish fish = (Fish) objects.get(i);
           fish.startSwimming();
         }
       }
       break;
     case 'X':
       for (int i=0; i<objects.size(); i++) {
         if (objects.get(i) instanceof Fish) {
           Fish fish = (Fish) objects.get(i);
           fish.stopSwimming();;
         }
       }
       break;
     case 'C':
       this.clear();
       break;
     case 'B':
       BlueFish blue = new BlueFish();
       objects.add(blue);
   }

 }
 
 public void clear() {
   for (int i=0; i<objects.size(); i++) {
     if (objects.get(i) instanceof Fish) {
       objects.remove(i);
       i--;
     }
   }
 }
  
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    PApplet.main("FishTank"); // do not add any other statement to the main method
    // The PApplet.main() method takes a String input parameter which represents
    // the name of your PApplet class.

  }

}
