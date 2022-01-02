//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Benchmarking Hacks - Benchmarker
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
 * This class is used to timing two hacking approaches
 * @author jingde Wan
 *
 */
public class Benchmarker {
  
  /**
   * Record the time in long before and after 
   * calling the PasswordHackers bruteForce() method
   * @param ph PasswordHacker object
   * @return The time in long before and after calling the PasswordHackers bruteForce() method
   */
  public static long timeBruteForce(PasswordHacker ph) {
    // time before implementing the bruteForece() method
    long a = System.currentTimeMillis();
    ph.bruteForce();
    // time after implementing the bruteForece() method
    long b = System.currentTimeMillis();
    
    return b-a;
  }
  
  /**
   * Record the time in long before and after 
   * calling the PasswordHackers Hack() method
   * @param ph PasswordHacker object
   * @return The time in long before and after calling the PasswordHackers Hack() method
   */
  public static long timeHack(PasswordHacker ph) {
    // time before implementing the Hack() method
    long a = System.currentTimeMillis();
    ph.hack();
    // time after implementing the Hack() method
    long b = System.currentTimeMillis();
    
    return b-a;
  }
  
  /**
   * Race the two approaches against each other, using the previous two methods
   * @param passwordLength The length of the password for a lock box
   * @param numRuns The number of PasswordHacker created
   * @return the results of this race as a String with the following format: 
   * "Brute force N: time\nHack N: time"
   */
  public static String race(int passwordLength, int numRuns) {
    // create the array storing PasswordHacker object
    PasswordHacker[] PWHackerArray = new PasswordHacker[numRuns];
    // create the array storing the BruteFore() time for PasswordHacker object
    long[] BruteForceTime = new long[numRuns];
    // create the array storing the Hack() time for PasswordHacker object
    long[] HackTime = new long[numRuns];
    
    for (int i=0; i<numRuns; i++) {
      PWHackerArray[i] = new PasswordHacker(passwordLength);
    }
    
    for (int i=0; i<numRuns; i++) {
      BruteForceTime[i] = timeBruteForce(PWHackerArray[i]);
    }
    
    for (int i=0; i<numRuns; i++) {
      HackTime[i] = timeHack(PWHackerArray[i]);
    } 
    
    // Calculate the average elapsed time for BruteForce() approach over all objects
    long sumBruteForceTime = 0;
    long avgBruteForceTime = 0;
    for (int i=0; i<numRuns; i++) {
      sumBruteForceTime += BruteForceTime[i];
    }
    avgBruteForceTime = sumBruteForceTime / (long) numRuns;
    
    // Calculate the average elapsed time for Hack() approach over all objects
    long sumHackTime = 0;
    long avgHackTime = 0;
    for (int i=0; i<numRuns; i++) {
      sumHackTime += HackTime[i];
    }
    avgHackTime = sumHackTime / (long) numRuns;
    
    return "Brute force " + passwordLength + ": " + Float.toString(avgBruteForceTime) + "\nHack " 
    + passwordLength + ": " + Float.toString(avgHackTime); 
    
  }
  
  
  public static void main(String[] args) {
    // example 1
    String result = race(5, 5);
    System.out.println(result);
  }

}
