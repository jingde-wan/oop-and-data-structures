//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P11 Assignment Planner - AssignmentQueue
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
 * Array-based heap implementation of a priority queue containing Assignments. Guarantees the
 * min-heap invariant, so that the Assignment at the root should have the earliest due date, and
 * children always have a due date after or at the same time as their parent. The root of a
 * non-empty queue is always at index 0 of this array-heap.
 */
public class AssignmentQueue implements PriorityQueueADT<Assignment>, Iterable<Assignment> {
  private Assignment[] queue; // array min-heap of assignments representing this priority queue
  private int size; // size of this priority queue


  /**
   * Creates a new empty AssignmentQueue with the given capacity
   * 
   * @param capacity Capacity of this AssignmentQueue
   * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
   *                                  positive integer
   */
  public AssignmentQueue(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException();
    }
    queue = new Assignment[capacity];
    size = 0;
  }

  /**
   * Checks whether this AssignmentQueue is empty
   * 
   * @return {@code true} if this AssignmentQueue is empty
   */
  @Override
  public boolean isEmpty() {
    // TODO complete this implementation
    if (size == 0) {
      return true;
    }
    return false; // default return statement added to resolve compile errors
  }

  /**
   * Returns the size of this AssignmentQueue
   * 
   * @return the size of this AssignmentQueue
   */
  @Override
  public int size() {
    // TODO complete this implementation
    return size;
  }

  /**
   * Returns the capacity of this AssignmentQueue
   * 
   * @return the capacity of this AssignmentQueue
   */
  public int capacity() {
    // TODO complete this implementation
    return queue.length; // default return statement added to resolve compile errors
  }
  
  
  /**
   * Removes all elements from this AssignmentQueue
   */
  @Override
  public void clear() {
    queue = new Assignment[queue.length];
    size = 0;
    // TODO complete this implementation
  }
  
  /**
   * Returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment with the
   * earliest due date.
   * 
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException if this AssignmentQueue is empty
   */
  @Override
  public Assignment peek() {
    // TODO complete this implementation
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return queue[0]; // default return statement added to resolve compile errors
  }


  /**
   * Adds the given Assignment to this AssignmentQueue at the correct position based on the min-heap
   * ordering. This queue should maintain the min-heap invariant, so that the Assignment at each
   * index has an earlier or equivalent due-date than the Assignments in its child nodes.
   * Assignments should be compared using the Assignment.compareTo() method.
   * 
   * @param e Assignment to add to this AssignmentQueue
   * @throws NullPointerException  if the given Assignment is null
   * @throws IllegalStateException with a descriptive error message if this AssignmentQueue is full
   */
  @Override
  public void enqueue(Assignment e) {
    if (e == null) {
      throw new NullPointerException();
    }
    if (size == queue.length) {
      throw new IllegalStateException("The AssignmentQueue is full!");
    }
    if (isEmpty()) {
      queue[0] = e;
    } else {
      queue[size] = e;
      percolateUp(size); //may be wrong
    }
    size++;
  }

  /**
   * Removes and returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment
   * with the earliest due date.
   * 
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException with a descriptive error message if this AssignmentQueue is
   *                                empty
   */
  @Override
  public Assignment dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("The AssignmentQueue is empty!");
    }
    Assignment temp = queue[0];
    queue[0] = queue[size-1];
    queue[size-1] = null;
    size--;
    percolateDown(0);
    
    return temp;
  }

  /**
   * Recursive implementation of percolateDown() method. Restores the min-heap invariant of a given
   * subtree by percolating its root down the tree. If the element at the given index does not
   * violate the min-heap invariant (it is due before its children), then this method does not
   * modify the heap. Otherwise, if there is a heap violation, then swap the element with the
   * correct child and continue percolating the element down the heap.
   * 
   * @param i index of the element in the heap to percolate downwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateDown(int i) {
    // TODO provide the worst-case runtime complexity of this method assuming that the problem size
    // N is the size of this queue
    // Time complexity: O(log(n))

    int index = i;
    int leftIndex = 2*index + 1;
    int rightIndex = 2*index + 2;
    int smallestIndex = index;
    
    // find the largest Assignment in the child nodes and swap it w/ the parent node
    // if left child node exists and is larger than the parent node, reassign the index of largest node
    if (leftIndex < size && queue[leftIndex].compareTo(queue[smallestIndex]) < 0) {
      smallestIndex = leftIndex;
    }
    // if right child node exists and is larger than the current largest node
    if (rightIndex < size && queue[rightIndex].compareTo(queue[smallestIndex]) < 0) {
      smallestIndex = rightIndex;
    }
    
    // if one of child nodes is smaller than the parent index
    if (smallestIndex != index) {
      Assignment temp = queue[smallestIndex];
      queue[smallestIndex] = queue[index];
      queue[index] = temp;
      percolateDown(smallestIndex);
    }
    
    
  }

  /**
   * Recursive implementation of percolateUp() method. Restores the min-heap invariant of the tree
   * by percolating a leaf up the tree. If the element at the given index does not violate the
   * min-heap invariant (it occurs after its parent), then this method does not modify the heap.
   * Otherwise, if there is a heap violation, swap the element with its parent and continue
   * percolating the element up the heap.
   * 
   * @param i index of the element in the heap to percolate upwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateUp(int i) {
    // TODO provide the worst-case runtime complexity of this method assuming that the problem size
    // N is the size of this queue
    // Time complexity: O(log(n))
    
    int index = i;
    int parentIndex = (index - 1) / 2;
    
    if (queue[index].compareTo(queue[parentIndex]) < 0) {
      Assignment temp = queue[index];
      queue[index] = queue[parentIndex];
      queue[parentIndex] = temp;
      
      percolateUp(parentIndex);
    }
    
  }
  
  /**
   * Returns a deep copy of this AssignmentQueue containing all of its elements in the same order.
   * This method does not return the deepest copy, meaning that you do not need to duplicate 
   * assignments. Only the instance of the heap (including the array and its size) will be duplicated.
   * 
   * @return a deep copy of this AssignmentQueue. The returned new assignment queue has the same
   *         length and size as this queue.
   */
  public AssignmentQueue deepCopy() {
    AssignmentQueue copy = new AssignmentQueue(queue.length);
    for (int i=0; i<size; i++) {
      copy.enqueue(queue[i]);
    }
    
    return copy; // default return statement added to resolve compiler errors
  }

  /**
   * Returns a String representing this AssignmentQueue, where each element (assignment) of the
   * queue is listed on a separate line, in order from earliest to latest.
   * 
   * @see Assignment#toString()
   * @see AssignmentIterator
   * @return a String representing this AssignmentQueue
   */
  public String toString() {
    StringBuilder val = new StringBuilder();

    for (Assignment a : this) {
      val.append(a).append("\n");
    }

    return val.toString();
  }

  /**
   * Returns an Iterator for this AssignmentQueue which proceeds from the earliest to the latest
   * Assignment in the queue.
   * 
   * @see AssignmentIterator
   * @return an Iterator for this AssignmentQueue
   */
  @Override
  public Iterator<Assignment> iterator() {
    return new AssignmentIterator(this);
  }
}