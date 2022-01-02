//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Tile Matching Game - TileMatchingGame
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
import java.util.Iterator;

/**
 * This class models the Tile matching game
 * 
 * @author jingde Wan
 *
 */
public class TileMatchingGame {
  // an array of TileStacks
  private TileStack[] columns;

  /**
   * Constructor: creates an TileMatchingGame of certain number of columns
   * 
   * @param columnCount the capacity of the array columns
   */
  public TileMatchingGame(int columnCount) {
    if (columnCount <= 0) {
      throw new IllegalArgumentException("column number is less than or equal to zero");
    }
    this.columns = new TileStack[columnCount];
    for (int i = 0; i < columnCount; i++) {
      columns[i] = new TileStack();
    }
  }

  /**
   * Removes all the tiles from a column with a given index
   * 
   * @param index of the column to clear
   */
  public void clearColumn(int index) {
    Iterator<Tile> itr = columns[index].iterator();
    while (itr.hasNext()) {
      if (columns[index].size() == 0) {
        break;
      }
      // System.out.println(this.column(0));
      columns[index].pop();
    }
    // for (int i=0; i<columns[index].size(); i++) {
    // columns[index].pop();
    // }
  }

  /**
   * Returns a string representation of the stack of tiles at a given column index, and an empty
   * string if the stack is empty.
   * 
   * @param index the index of a column in this game
   * @return a string representation of the column at a given index of this game
   */
  public String column(int index) {
    String output = "";
    // iterate through the whole stack of tiles
    Iterator<Tile> itr = columns[index].iterator();
    while (itr.hasNext()) {
      output = output + itr.next().toString() + " ";
    }
    output = output.strip();
    return output;
  }

  /**
   * Drops a tile at the top of the stack located at the given column index. If tile will be dropped
   * at the top of an equal tile (of same color), both tiles will be removed from the stack of tiles
   * at column index.
   * 
   * @param tile  a tile to drop
   * @param index column position of the stack of tiles where tile will be dropped
   */
  public void dropTile(Tile tile, int index) {
    // columns[index] = new TileStack();
    if (index > columns.length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (columns[index].isEmpty()) {
      columns[index].push(tile);
    } else if (columns[index].peek().equals(tile)) {
      columns[index].pop();
    } else {
      columns[index].push(tile);
    }
  }

  /**
   * Gets the number of columns in this tile matching game
   * 
   * @return the number of columns in this tile matching game
   */
  public int getColumnsNumber() {
    return columns.length;
  }

  /**
   * Restarts the game. All stacks of tiles in the different columns of this game will be empty
   */
  public void restartGame() {
    for (int i = 0; i < columns.length; i++) {
      this.clearColumn(i);
    }
  }

  /**
   * public java.lang.String toString() Returns a string representation of this tile matching game
   * The format of the returned string is as follows: GAME COLUMNS:\n [String representation of each
   * column separated by newline] For instance, a game with 4 columns will be represented as
   * follows. GAME COLUMNS: 0: 1: BLACK BLUE 2: ORANGE YELLOW 3: YELLOW
   * 
   * @return a string representation of the tile matching game
   */
  public String toString() {
    String output = "GAME COLUMNS:\n";
    for (int i = 0; i < columns.length; i++) {
      output = output + i + ": " + column(i) + "\n";
    }

    return output;
  }


}
