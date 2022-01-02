//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Tile Matching Game - TileStack
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
 * This class models a linked stack of tiles
 * 
 * @author jingde Wan
 *
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile> {
  private Node top;
  private int size;

  /**
   * Constructor: creates an empty stack of tiles
   */
  public TileStack() {
    this.top = null;
    this.size = 0;
  }

  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws java.lang.IllegalArgumentException with a descriptive error message if the input
   *                                            element is null
   */
  @Override
  public void push(Tile element) {

    if (element == null) {
      throw new IllegalArgumentException("the element added is null");
    }

    Node newNode = new Node(element);
    newNode.setNext(top);
    top = newNode;
    // top = new Node(element, top);

    size++;



    // if (isEmpty()) {
    // this.top = new Node(element);
    // }
    // // otherwise adds element to new node with head as its next node, then sets head to new node
    // else {
    // Node newNode = new Node(element, this.top);
    // this.top = newNode;
    // }
    // // increment size
    // size++;

  }


  /**
   * Remove the element on the top of this stack and return it
   * 
   * @return the element removed from the top of the stack
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  @Override
  public Tile pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    // If the linked list is not empty
    // Remove the element on the top of this stack and return it
    Node temp = top;
    top = top.getNext();
    size--;
    return temp.getTile();



    // // stores stack head's DrawingChange
    // Tile popped = this.top.getTile();
    // // if only 1 element in stack, sets head to null
    // if (this.top.getNext() == null) {
    // this.top = null;
    // }
    // // otherwise sets head to current head's next node
    // else {
    // this.top = this.top.getNext();
    // }
    // // decrement size
    // size--;
    // return popped;

  }

  /**
   * Get the element on the top of this stack
   * 
   * @return the element on the stack top
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  @Override
  public Tile peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    return top.getTile();

  }

  /**
   * Check whether this stack is empty or not
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }


  /**
   * Get the number of elements in this stack
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Get the iterator of TileStack
   * 
   * @return the iterator of TileStack
   */
  @Override
  public Iterator<Tile> iterator() {
    return new TileListIterator(top);
  }

}
