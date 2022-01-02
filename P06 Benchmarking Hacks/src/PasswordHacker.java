//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Benchmarking Hacks - PasswordHacker
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
/**
 * This models the object we are hacking with
 * @author jingde Wan
 *
 */
public class PasswordHacker {
  private LockBox toPick;
  private int passwordLength;
  
  /**
   * Create a PasswordHacker object for a lock box with certain length password
   * @param passwordLength The length of password for a lock box
   */
  public PasswordHacker(int passwordLength) {
    this.passwordLength = passwordLength;
    this.toPick = new LockBox(this.passwordLength);
  }
  
  
  /**
   * hack and open the lock box
   * Complexity: O( 1 ) 
   */
  public void hack() {
    toPick.reset();
    String password = toPick.hackMe();
    toPick.authenticate(password);
  }
  
  /**
   * use brute force to open the lock box
   * Complexity: O( n*10^n )
   */
  public void bruteForce() {
    toPick.reset();
    for (int i=0; i<Math.pow(10, passwordLength); i++) {
      String test = generateGuess(i);
      toPick.authenticate(test);
      
      if (toPick.isOpen()==true) {
        break;
      }
    }
  }
  
  /**
   * generate a guessed password given the number of times you've guessed a password (count)
   * @param count The number of times you have guessed a password
   * @return the guessed password string
   */
  public String generateGuess(int count) {
    String guess = "";
    
    for (int i = 0; i < passwordLength; i++) {
      guess = (count % 10) + guess;
      count = count / 10;
    }
    return guess;
  }
  
  
  
  
  
}
