//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Climbing Tracker - ClimbingTrackerTester
// Course:   CS 300 Fall 2020
//
// Author:   Jingde Wan
// Email:    wan38@wisc.edu
// Lecturer: Dr. Hobbes LeGault
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
 * This class models a Climbing Tracker Tester
 */
public class ClimbingTrackerTester {
	/**
	 * Create an oversize array of Strings to test the sendClimb() method
	 * 
	 * @return true if ALL of the return values from sendClimb() match the expectations;
	 * false otherwise
	 */
	public static boolean testSendClimb() {
		
		boolean error = false;
		
		{//empty array
			String[] sendTest = {null, null, null, null, null};
			int numSendTest = 0;
			String gradeTest = "V1";
			int expected = 1;
			
			if (ClimbingTracker.sendClimb(sendTest, numSendTest, gradeTest) != expected) {
				error = true;
			} 
		}
		
		{//partially-filled array
			String[] sendTest = {"V1", "V2", "V1", null, null};
			int numSendTest = 3;
			String gradeTest = "V1";
			int expected = 4;
			
			if (ClimbingTracker.sendClimb(sendTest, numSendTest, gradeTest) != expected) {
				error = true;
			}
		}
		
		{//full array
			String[] sendTest = {"V1", "V2", "V1", "V3", "V3"};
			int numSendTest = 5;
			String gradeTest = "V1";
			int expected = 5;
			
			if (ClimbingTracker.sendClimb(sendTest, numSendTest, gradeTest) != expected) {
				error = true;
			}
		}
		
		{//invalid grade
			String[] sendTest = {"V1", "V2", "V1", "V3", null};
			int numSendTest = 4;
			String gradeTest = "V22";
			int expected = 4;
			
			if (ClimbingTracker.sendClimb(sendTest, numSendTest, gradeTest) != expected) {
				error = true;
			}
		}
		
		if (error) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Create an oversized array of Strings to test the failClimb() method
	 * 
	 * @return true if ALL of the return values from failClimb() match the expectations;
	 * false otherwise
	 */
	public static boolean testFailClimb() {
		
		boolean error = false;
		
		{//empty array
			String[] failTest = {null, null, null, null, null};
			int numFailTest = 0;
			String gradeTest = "V1";
			int expected = 1;
			
			if (ClimbingTracker.failClimb(failTest, numFailTest, gradeTest) != expected) {
				error = true;
				System.out.println("error");
			} 
		}
		
		{//partially-filled array
			String[] failTest = {"V1", "V2", "V1", null, null};
			int numFailTest = 3;
			String gradeTest = "V1";
			int expected = 4;
			
			if (ClimbingTracker.failClimb(failTest, numFailTest, gradeTest) != expected) {
				error = true;
				System.out.println("error");
			} 
		}
		
		{//full array
			String[] failTest = {"V1", "V2", "V1", "V3", "V3"};
			int numFailTest = 5;
			String gradeTest = "V1";
			int expected = 5;
			
			if (ClimbingTracker.failClimb(failTest, numFailTest, gradeTest) != expected) {
				error = true;
				System.out.println("error");
			}
		}
		
		{//invalid grade
			String[] failTest = {"V1", "V2", "V1", "V3", null};
			int numFailTest = 4;
			String gradeTest = "V22";
			int expected = 4;
			
			if (ClimbingTracker.failClimb(failTest, numFailTest, gradeTest) != expected) {
				error = true;
				System.out.println("error");
			}
		}
		
		if (error) {
			return false;
		} else {
			return true;
		}
		
	}
	
	/**
	 * Create oversized arrays of Strings to test the getStats() method
	 * 
	 * @return true if ALL of the return values from getStats() match the expectations;
	 * false otherwise
	 */
	public static boolean testGetStats() {
		boolean error = false;
		{//a mix of grades in both
			String[] send = {"V0", "V1", "V0", "V0", null};
			int numSend = 4;
			String[] fail = {"V2", "V1", null, null, null};
			int numFail = 2;
			int historyLength = 3;
			String expected = "send: "+ 1.0/3.0 + "\nfail: 1.5";
//			System.out.println(expected);
			if (!(ClimbingTracker.getStats(send, numSend, fail, numFail, historyLength).equals(expected))) {
				error = true;
				System.out.println("error");
			}
		}
		
		{//one grade in both
			String[] send = {"V0", null, null, null, null};
			int numSend = 1;
			String[] fail = {"V2", null, null, null, null};
			int numFail = 1;
			int historyLength = 3;
			String expected = "send: "+ 0.0 + "\nfail: 2.0";
//			System.out.println(expected);
			if (!(ClimbingTracker.getStats(send, numSend, fail, numFail, historyLength).equals(expected))) {
				error = true;
				System.out.println("error");
			}
		}
		
		{//empty array
			String[] send = {null, null, null, null, null};
			int numSend = 0;
			String[] fail = {"V2", null, null, null, null};
			int numFail = 1;
			int historyLength = 3;
			String expected = "send: "+ "--" + "\nfail: 2.0";
//			System.out.println(expected);
			if (!(ClimbingTracker.getStats(send, numSend, fail, numFail, historyLength).equals(expected))) {
				error = true;
				System.out.println("error");
			}
		}
		
		
		if (error) {
			return false;
		} else {
			return true;
		}
		
	}
	
	/**
	 * Create oversized arrays of Strings to test the getHistogram() method
	 * 
	 * @return true if ALL of the return values from getHistogram() match the expectations;
	 * false otherwise
	 */
	public static boolean testGetHistogram() {
		
		boolean error = false;
		{//a mix of grades in both
			String[] send = {"V0", "V1", "V0", "V0", null};
			int numSend = 4;
			String[] fail = {"V2", "V1", null, null, null};
			int numFail = 2;
			
			String expected = "V0: + + +" + "\nV1: - +" + "\nV2: -";
//			System.out.println(expected);
			if (!(ClimbingTracker.getHistogram(send, numSend, fail, numFail).equals(expected))) {
				error = true;
				System.out.println("error");
			}
		}
		
		{//one grade in both
			String[] send = {"V0", null, null, null, null};
			int numSend = 1;
			String[] fail = {"V2", null, null, null, null};
			int numFail = 1;
			
			String expected = "V0: +" + "\nV1:" + "\nV2: -";
//			System.out.println(expected);
			if (!(ClimbingTracker.getHistogram(send, numSend, fail, numFail).equals(expected))) {
				error = true;
				System.out.println("error");
			}
		}
		
		{//empty array
			String[] send = {null, null, null, null, null};
			int numSend = 0;
			String[] fail = {"V2", null, null, null, null};
			int numFail = 1;
			
			String expected = "V0:" + "\nV1:" + "\nV2: -";
//			System.out.println(expected);
			if (!(ClimbingTracker.getHistogram(send, numSend, fail, numFail).equals(expected))) {
				error = true;
				System.out.println("error");
			}
		}
		
		
		if (error) {
			return false;
		} else {
			return true;
		}
		
		
	}
	
	/**
	 * Contains one call to each test method above
	 * 
	 * @return true if and only if all test methods return true; false otherwise.
	 */
	public static boolean runAllTests() {
		if (testSendClimb() && testFailClimb() && testGetStats() && testGetHistogram()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
     * This main method runs the selected tests.
     *
     * @param args unused
     */
	public static void main(String[] args) {
		runAllTests();
	}	

//	public static void main(String[] args) {
//		if (runAllTests()) {
//			System.out.println("All Tests passed!");
//		} else {
//			System.out.println("Test failed!");
//		}
//	}

}
