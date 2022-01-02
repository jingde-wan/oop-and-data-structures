//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Tile Matching Game - TileListIterator
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
import java.util.NoSuchElementException;

/**
 * This class models an iterator that iterates through any chain of linked nodes (instances of our
 * Node class) starting from its head
 * 
 * @author jingde Wan
 *
 */
public class TileListIterator implements Iterator<Tile> {
  // To keep track of the next element in the iteration
  private Node current;

  /**
   * Constructor: creates an iterator starting from its head
   * 
   * @param head
   */
  public TileListIterator(Node head) {
    this.current = head;
  }

  /**
   * Returns true if the iteration has more elements. (In other words, returns true if next() would
   * return an element rather than throwing an exception.)
   * 
   * @return true if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return current != null;
  }


  /**
   * Returns the next element in the iteration.
   * 
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Tile next() {
    if (current == null) {
      throw new NoSuchElementException("No next element in the iteration");
    }

    Tile data = current.getTile();
    current = current.getNext();
    return data;
  }

}
