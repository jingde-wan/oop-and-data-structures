//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P11 Assignment Planner - AssignmentQueueTester
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
import java.util.NoSuchElementException;

/**
 * Tester class for the AssignmentQueue implementation of PriorityQueueADT
 */
public class AssignmentQueueTester {
  /**
   * Tests the functionality of the constructor for AssignmentQueue Should implement at least the
   * following tests:
   *
   * - Calling the AssignmentQueue with an invalid capacity should throw an IllegalArgumentException
   * - Calling the AssignmentQueue with a valid capacity should not throw any errors, and should
   * result in a new AssignmentQueue which is empty, and has size 0
   *
   * @return true if the constructor of AssignmentQueue functions properly
   * @see AssignmentQueue#AssignmentQueue(int)
   */
  public static boolean testConstructor() {
    try {
      // Scenario 1: Calling the AssignmentQueue with an invalid capacity should 
      // throw an IllegalArgumentException
      AssignmentQueue queueA = new AssignmentQueue(-2);
      
      
      // Scenario 2: Calling the AssignmentQueue with a valid capacity
      AssignmentQueue queueB = new AssignmentQueue(10);
      if (!queueB.isEmpty() || !(queueB.size()==0)) {
        return false;
      }
    
    } catch (IllegalArgumentException iae) {
      
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testConstructor() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Tests the functionality of the enqueue() and peek() methods Should implement at least the
   * following tests:
   *
   * - Calling peek on an empty queue should throw a NoSuchElementException 
   * - Calling enqueue on a queue which is empty should add the Assignment, and increment the size 
   *   of the queue
   * - Calling enqueue on a non-empty queue should add the Assignment at the proper position, 
   *   and increment the size of the queue. Try add at least 5 assignments 
   * - Calling peek on a non-empty queue should always return the Assignment with the earliest due date
   * - Calling enqueue on a full queue should throw an IllegalStateException 
   * - Calling enqueue with a null Assignment should throw a NullPointerException
   *
   * @return true if AssignmentQueue.enqueue() and AssignmentQueue.peek() function properly
   */
  public static boolean testEnqueue() {
    try {
      // Scenario 1: Calling the AssignmentQueue with a valid capacity
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwA = queueA.peek();

    } catch (NoSuchElementException nsee) {
//      return true;
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testEnqueue() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    // Scenario 2: Calling enqueue on a queue which is empty should add the Assignment
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwB = new Assignment("HW1", 7, 24, 1);
      queueA.enqueue(hwB);
      String expected = "HW1 (Due 07-24 1AM)\n";
      // System.out.println(queueA.size());
      // System.out.println(queueA);

      if (!(queueA.size() == 1) || !(queueA.toString().equals(expected))) {
        return false;
      }
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testEnqueue() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }


    // Scenario 3: Calling enqueue on a non-empty queue should add the Assignment at the proper
    // position
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwB = new Assignment("HW1", 7, 24, 1);
      Assignment hwC = new Assignment("HW2", 7, 25, 1);
      Assignment hwD = new Assignment("HW3", 7, 26, 1);
      Assignment hwE = new Assignment("HW4", 7, 27, 1);
      Assignment hwF = new Assignment("HW6", 7, 29, 1);
      Assignment hwG = new Assignment("HW7", 7, 30, 1);
      Assignment hwH = new Assignment("HW5", 7, 28, 1);
      String expected = "HW1 (Due 07-24 1AM)\n" + "HW2 (Due 07-25 1AM)\n" + "HW3 (Due 07-26 1AM)\n"
          + "HW4 (Due 07-27 1AM)\n" + "HW5 (Due 07-28 1AM)\n" + "HW6 (Due 07-29 1AM)\n"
          + "HW7 (Due 07-30 1AM)\n";

      queueA.enqueue(hwB);
      queueA.enqueue(hwD);
      queueA.enqueue(hwH);
      queueA.enqueue(hwC);
      queueA.enqueue(hwG);
      queueA.enqueue(hwE);
      queueA.enqueue(hwF);

       System.out.println(queueA);

      if (!(queueA.size() == 7) || !(queueA.toString().equals(expected))) {
        return false;
      }

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testEnqueue() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }


    // Scenario 4: Calling peek on a non-empty queue should always return the Assignment
    // with the earliest due date
    try {

      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwB = new Assignment("HW1", 7, 24, 1);
      Assignment hwC = new Assignment("HW2", 7, 25, 1);
      Assignment hwD = new Assignment("HW3", 7, 26, 1);
      Assignment hwE = new Assignment("HW4", 7, 27, 1);
      Assignment hwF = new Assignment("HW6", 7, 29, 1);
      Assignment hwG = new Assignment("HW7", 7, 30, 1);
      Assignment hwH = new Assignment("HW5", 7, 28, 1);

      queueA.enqueue(hwB);
      queueA.enqueue(hwC);
      queueA.enqueue(hwD);
      queueA.enqueue(hwE);
      queueA.enqueue(hwF);
      queueA.enqueue(hwG);
      queueA.enqueue(hwH);



      Assignment newHW = queueA.peek();
      Assignment expectedHW = new Assignment("HW1", 7, 24, 1);
      if (!newHW.equals(expectedHW)) {
        return false;
      }

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testEnqueue() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    // Scenario 5: Calling enqueue on a full queue should throw an IllegalStateException
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwB = new Assignment("HW1", 7, 24, 1);
      Assignment hwC = new Assignment("HW2", 7, 25, 1);
      Assignment hwD = new Assignment("HW3", 7, 26, 1);
      Assignment hwE = new Assignment("HW4", 7, 27, 1);
      Assignment hwF = new Assignment("HW6", 7, 29, 1);
      Assignment hwG = new Assignment("HW7", 7, 30, 1);
      Assignment hwH = new Assignment("HW5", 7, 28, 1);

      queueA.enqueue(hwB);
      queueA.enqueue(hwC);
      queueA.enqueue(hwD);
      queueA.enqueue(hwE);
      queueA.enqueue(hwF);
      queueA.enqueue(hwG);
      queueA.enqueue(hwH);

      Assignment HWHonors = new Assignment("HW1", 8, 1, 1);
      queueA.enqueue(HWHonors);

    } catch (IllegalStateException ise) {
      // ise.printStackTrace();
//      return true;
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testEnqueue() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    // Scenario 6: Calling enqueue with a null Assignment should throw a NullPointerException
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwB = new Assignment("HW1", 7, 24, 1);
      Assignment hwC = new Assignment("HW2", 7, 25, 1);
      Assignment hwD = new Assignment("HW3", 7, 26, 1);
      Assignment hwE = new Assignment("HW4", 7, 27, 1);
      Assignment hwF = new Assignment("HW6", 7, 29, 1);
      Assignment hwG = new Assignment("HW7", 7, 30, 1);
      Assignment hwH = new Assignment("HW5", 7, 28, 1);

      queueA.enqueue(hwB);
      queueA.enqueue(hwC);
      queueA.enqueue(hwD);
      queueA.enqueue(hwE);
      queueA.enqueue(hwF);
      queueA.enqueue(hwG);
      queueA.enqueue(hwH);
      Assignment HWNull = null;
      queueA.enqueue(HWNull);

    } catch (NullPointerException npe) {
      // npe.printStackTrace();
//      return true;
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testEnqueue() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    

    return true;
  }

  /**
   * Tests the functionality of dequeue() and peek() methods. The peek() method must return without
   * removing the assignment with the highest priority in the queue. The dequeue() method must
   * remove, and return the assignment with the highest priority in the queue. The size must be
   * decremented by one, each time the dequeue() method is successfully called. Try to check the
   * edge cases (calling peek and dequeue on an empty queue, and calling dequeue on a queue of size
   * one). For normal cases, try to consider dequeuing from a queue whose size is at least 6. Try to
   * consider cases where percolate-down recurses on left and right.
   * 
   * @return true if AssignmentQueue.dequeue() and AssignmentQueue.peek() function properly
   */
  public static boolean testDequeuePeek() {
    // Scenario 1: calling dequeue on an empty queue
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment newHW = queueA.dequeue();
    
    
    } catch (NoSuchElementException nsee) {
      
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testDequeuePeek() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    
    
    // Scenario 2: calling dequeue on a queue of size one
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwB = new Assignment("HW1", 7, 24, 1);
      queueA.enqueue(hwB);
      Assignment newHW = queueA.dequeue();
      
      if (!newHW.equals(hwB)) {
        return false;
      }
      
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testDequeuePeek() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    
    // Scenario 3: normal case
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwB = new Assignment("HW1", 7, 24, 1);
      Assignment hwC = new Assignment("HW2", 7, 25, 1);
      Assignment hwD = new Assignment("HW3", 7, 26, 1);
      Assignment hwE = new Assignment("HW4", 7, 27, 1);
      Assignment hwF = new Assignment("HW6", 7, 29, 1);
      Assignment hwG = new Assignment("HW7", 7, 30, 1);
      Assignment hwH = new Assignment("HW5", 7, 28, 1);

      queueA.enqueue(hwB);
      queueA.enqueue(hwC);
      queueA.enqueue(hwD);
      queueA.enqueue(hwE);
      queueA.enqueue(hwF);
      queueA.enqueue(hwG);
      queueA.enqueue(hwH);
      
      String expected = "HW2 (Due 07-25 1AM)\n" + "HW3 (Due 07-26 1AM)\n"
          + "HW4 (Due 07-27 1AM)\n" + "HW5 (Due 07-28 1AM)\n" + "HW6 (Due 07-29 1AM)\n"
          + "HW7 (Due 07-30 1AM)\n";
      Assignment newHW = queueA.dequeue();
      Assignment expectedHW = new Assignment("HW1", 7, 24, 1);
      if (!queueA.toString().equals(expected) || (!newHW.equals(expectedHW)) || (queueA.size() != 6)) {
        return false;
      }
      
      Assignment newHWA = queueA.dequeue();
      Assignment newHWB = queueA.dequeue();
      Assignment newHWC = queueA.dequeue();
      expected = "HW5 (Due 07-28 1AM)\n" + "HW6 (Due 07-29 1AM)\n"
          + "HW7 (Due 07-30 1AM)\n";
      if (!queueA.toString().equals(expected) || (queueA.size() != 3)) {
        return false;
      }

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testEnqueue() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Tests the functionality of the clear() method Should implement at least the following scenarios: 
   * - clear can be called on an empty queue with no errors 
   *  - clear can be called on a non-empty queue with no errors - After calling clear, the queue should contain no Assignments
   *
   * @return true if AssignmentQueue.clear() functions properly
   */
  public static boolean testClear() {
    // Scenario 1: called on an empty queue with no errors 
    
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      queueA.clear();
      
      if (!queueA.isEmpty()) {
        return false;
      }
      
    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testDequeuePeek() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    
    // Scenario 2: called on a non-empty queue with no errors
    try {
      AssignmentQueue queueA = new AssignmentQueue(7);
      Assignment hwB = new Assignment("HW1", 7, 24, 1);
      Assignment hwC = new Assignment("HW2", 7, 25, 1);
      Assignment hwD = new Assignment("HW3", 7, 26, 1);
      Assignment hwE = new Assignment("HW4", 7, 27, 1);
      Assignment hwF = new Assignment("HW6", 7, 29, 1);
      Assignment hwG = new Assignment("HW7", 7, 30, 1);
      Assignment hwH = new Assignment("HW5", 7, 28, 1);

      queueA.enqueue(hwB);
      queueA.enqueue(hwC);
      queueA.enqueue(hwD);
      queueA.enqueue(hwE);
      queueA.enqueue(hwF);
      queueA.enqueue(hwG);
      queueA.enqueue(hwH);
      
      queueA.clear();
      
      if (!queueA.isEmpty()) {
        return false;
      }

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your testEnqueue() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Tests all the methods of the AssignmentQueue class
   * 
   */
  public static boolean runAllTests() {
    try {
      if (!testConstructor()) {
        return false;
      }
      if (!testClear()) {
        return false;
      }
      if (!testEnqueue()) {
        return false;
      }
      if (!testDequeuePeek()) {
        return false;
      }

    } catch (Exception e) {
      System.out.println(
          "Problem detected: Your runAllTests() has thrown" + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }
  
  /**
   * Main method
   * @param args input arguments if any
   */
  public static void main(String[] args) {
//    System.out.println(runAllTests());
    runAllTests();
  }
}
