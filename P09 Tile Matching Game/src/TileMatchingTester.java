//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Tile Matching Game - TileMatchingTester
// Course: CS 300 Fall 2021
//
// Author: Jingde Wan
// Email: wan38@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: None
// Partner Email: None
// Partner Lecturer's Name: None
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * This class models the tester for TileMatching.
 * 
 * @author jingde Wan
 *
 */
public class TileMatchingTester {

  /**
   * Create Tile objects to test the equals() method
   * 
   * @return true if equals() works as expected; false otherwise
   */
  public static boolean tileEqualsTester() {
    try {
      Tile tileA = new Tile(Color.BLACK);
      Tile tileB = new Tile(Color.BLUE);
      Tile tileC = new Tile(Color.BLACK);
      String tileD = "AAA";

      // Scenario 1: compare a tile to an object of String
      if (tileA.equals(tileD)) {
        return false;
      }

      // Scenario 2: compare a tile to another tile of the same color
      if (!tileA.equals(tileC)) {
        return false;
      }

      // Scenario 2: compare a tile to another tile of the different color
      if (tileA.equals(tileB)) {
        return false;
      }

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your tileEqualsTester() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Create Tile objects to test the TileListIterator class
   * 
   * @return true if next() and hasNext() work as expected; false otherwise
   */
  public static boolean tileListIteratorTester() {
    try {

      Tile tileA = new Tile(Color.BLACK);
      Tile tileB = new Tile(Color.BLUE);
      Tile tileC = new Tile(Color.ORANGE);
      Tile tileD = new Tile(Color.YELLOW);

      Node nodeA = new Node(tileA);
      Node nodeB = new Node(tileB);
      Node nodeC = new Node(tileC);
      Node nodeD = new Node(tileD);

      nodeA.setNext(nodeB);
      nodeB.setNext(nodeC);
      nodeC.setNext(nodeD);

      // Test the whole iteration
      Iterator<Tile> iter = new TileListIterator(nodeA);
      String output = "";
      String expected = "BLACK BLUE ORANGE YELLOW ";
      while (iter.hasNext()) {
        output = output + iter.next().toString() + " ";
        // System.out.print(iter.next() + " ");
      }
      // System.out.println(output);
      if (!output.equals(expected)) {
        return false;
      }

      // Test hasNext() and next()
      Iterator<Tile> iterA = new TileListIterator(nodeA);
      if (!iterA.hasNext()) {
        return false;
      }

      if (!iterA.next().toString().equals("BLACK")) {
        return false;
      }

    } catch (Exception e) {
      System.out.println("Problem detected: Your tileListIteratorTester() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Create Tile objects to test the TileStack class
   * 
   * @return true if each method work as expected; false otherwise
   */
  public static boolean tileStackTester() {
    Tile tileA = new Tile(Color.BLACK);
    Tile tileB = new Tile(Color.BLUE);
    Tile tileC = null;
    Tile tileD = new Tile(Color.YELLOW);

    // Check push() with invalid input
    TileStack newStack = new TileStack();
    String expected = "the element added is null";
    try {
      newStack.push(tileC);
      return false;
    } catch (IllegalArgumentException iae) {
      String message = iae.getMessage();
      if (!message.equals(expected)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    // Check push(), iterator() and pop() with valid input
    try {
      newStack = new TileStack();
      newStack.push(tileA);
      newStack.push(tileB);
      newStack.push(tileD);
      newStack.pop();
      String output = "";
      expected = "BLUE BLACK ";
      Iterator<Tile> itr = newStack.iterator();
      while (itr.hasNext()) {
        output = output + itr.next().toString() + " ";
      }
      // System.out.println(output);
      if (!output.equals(expected)) {
        return false;
      }
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your PushPopTester() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }


    // Check pop() when empty stack
    try {
      newStack = new TileStack();
      newStack.pop();
      return false;
    } catch (EmptyStackException ese) {

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your PushPopTester() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }


    // Check peek() when empty stack
    try {
      newStack = new TileStack();
      newStack.peek();
      return false;
    } catch (EmptyStackException ese) {

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your PushPopTester() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }


    // Check peek(), isEmpty(), size() when empty stack
    try {
      newStack = new TileStack();
      newStack.push(tileA);
      newStack.push(tileB);
      expected = "BLUE";
      if (!newStack.peek().toString().equals(expected)) {
        return false;
      }

      if (newStack.isEmpty()) {
        return false;
      }

      if (newStack.size() != 2) {
        return false;
      }

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your PushPopTester() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Create Tile objects to test the TileMatchingGame class
   * 
   * @return true if each method work as expected; false otherwise
   */
  public static boolean tileMatchingGameTester() {
    Tile tileA = new Tile(Color.BLACK);
    Tile tileB = new Tile(Color.BLUE);
    Tile tileC = new Tile(Color.ORANGE);
    Tile tileD = new Tile(Color.YELLOW);

    // Check column() and dropTile()
    try {
      String expected = "YELLOW ORANGE BLUE BLACK";
      TileMatchingGame gameA = new TileMatchingGame(5);
      gameA.dropTile(tileA, 0);
      gameA.dropTile(tileB, 0);
      gameA.dropTile(tileC, 0);
      gameA.dropTile(tileD, 0);

      // System.out.println(gameA.column(0));
      if (!gameA.column(0).equals(expected)) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Problem detected: Your tileMatchingGameTester() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    // Check column() and dropTile() with tile of same color
    try {
      String expected = "";
      TileMatchingGame gameA = new TileMatchingGame(5);
      gameA.dropTile(tileA, 0);
      gameA.dropTile(tileA, 0);

      // System.out.println(gameA.column(0));
      if (!gameA.column(0).equals(expected)) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Problem detected: Your tileMatchingGameTester() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    // Check clearColumn() and dropTile() with tile of same color
    try {
      String expected = "";
      TileMatchingGame gameA = new TileMatchingGame(5);
      gameA.dropTile(tileA, 0);
      gameA.dropTile(tileB, 0);
      gameA.dropTile(tileC, 0);
      gameA.dropTile(tileD, 0);
      // System.out.println(gameA.column(0));

      gameA.clearColumn(0);

      // System.out.println(gameA.column(0));
      if (!gameA.column(0).equals(expected)) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Problem detected: Your tileMatchingGameTester() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }


    // Check restartGame(),toString() and dropTile() with tile of same color
    try {
      String expected = "";
      TileMatchingGame gameA = new TileMatchingGame(5);
      gameA.dropTile(tileA, 0);
      gameA.dropTile(tileB, 0);
      gameA.dropTile(tileC, 1);
      gameA.dropTile(tileD, 1);

      // check toString()
      String expected2 = "GAME COLUMNS:\n" + "0: BLUE BLACK\n" + "1: YELLOW ORANGE\n" + "2: \n"
          + "3: \n" + "4: \n";
      System.out.println(gameA.toString());
      if (!gameA.toString().equals(expected2)) {
        return false;
      }

      // Check restartGame()
      gameA.restartGame();

      // System.out.println(gameA.column(0));
      if (!gameA.column(0).equals(expected) || !gameA.column(1).equals(expected)) {
        return false;
      }
      if (gameA.getColumnsNumber() != 5) {
        return false;
      }


    } catch (Exception e) {
      System.out.println("Problem detected: Your tileMatchingGameTester() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;

  }

  /**
   * This main method runs the selected tests.
   *
   * @param args unused
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // System.out.print(tileListIteratorTester());
    System.out.print(tileMatchingGameTester());
  }

}
