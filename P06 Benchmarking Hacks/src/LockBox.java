//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Benchmarking Hacks - LockBox
// Course:   CS 300 Fall 2021
//
// Author:   Jingde Wan
// Email:    wan38@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    None
// Partner Email:   None
// Partner Lecturer's Name: None
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
/**
 * This models the object we will be hacking into
 * @author jingde Wan
 *
 */
public class LockBox {
  // random number generator
  protected static Random randGen;
  // password for the lockbox
  private String password;
  // the opening status of the lockbox
  private boolean isOpen;
  
  /**
   * Create the LockBox object with certain length password by random number generator
   * @param passwordLength The length of password for a lock box
   */
  public LockBox(int passwordLength) {
    // initialize the static random number generator IF AND ONLY IF it has not yet been initialized
    if (randGen == null) {
      randGen = new Random();
    }
    
    if (passwordLength <= 0) {
      throw new IllegalArgumentException("Invalid password length");
    } else {
      // generate a random password of numbers only, with length equal to passwordLength
      int max = (int) Math.pow(10, passwordLength);
      int min = (int) Math.pow(10, passwordLength-1);
      password = Integer.toString(randGen.nextInt(max-min) + min);
    }
  }
  
  /**
   * Checks the provided guess against the stored password
   * @param guess The guessed password
   */
  public void authenticate(String guess) {
    // Sets the instance field isOpen to true if the guess is correct
    if (password.equals(guess)) {
      isOpen = true;
    }
  }
  
  /**
   * Returns the stored password in plain text. 
   * @return the password of the lock box
   */
  public String hackMe() {
    return password;
  }
  
  /**
   * Accessor for the isOpen field, to check whether your authentication was successful
   * @return true if isOpen field is true, false otherwise
   */
  public boolean isOpen() {
    return isOpen;
  }
  
  /**
   * Resets the isOpen instance field to false
   */
  public void reset() {
    isOpen = false;
  }
  
}
