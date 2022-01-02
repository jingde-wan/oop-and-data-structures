//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 - Exceptional Climbing Tester
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
import java.util.zip.DataFormatException;

/**
 * This class models a Exceptional Climbing Tracker Tester
 */
public class ExceptionalClimbingTester {
	/**
	 * Create an oversize array of Strings to test the sendClimb() method
	 * 
	 * @return true if ALL of the return values from sendClimb() match the expectations;
	 * false otherwise
	 */
	public static boolean testSendClimb() {
		
		//Invalid grade causes IllegalArgumentException
		String[] sendTest = {"V0", null, null, null, null};
		int numSendTest = 1;
		String gradeTest = "V8";
		String expected = "V8 is not a valid grade";
		
		try {
			int sizeTest = ExceptionalClimbing.sendClimb(sendTest, numSendTest, gradeTest);
			return false;
		} catch (IllegalArgumentException iae) {
			// ensure message does exist
			if (iae.getMessage() == null || iae.getMessage().length() == 0) {
				return false;
			}
			String message = iae.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

		
		//Full array causes IllegalArgumentException
		String[] sendTest1 = {"V0", "V1", "V1", "V2", "V2"};
		numSendTest = 5;
		gradeTest = "V2";
		expected = "cannot add new value to full length 5 array";
				
		try {
			int sizeTest = ExceptionalClimbing.sendClimb(sendTest1, numSendTest, gradeTest);
			return false;
		} catch (IllegalArgumentException iae) {
			if (iae.getMessage() == null || iae.getMessage().length() == 0) {
				return false;
			}
			String message = iae.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		
		//Array with null elements or invalid size causes DataFormatException
		String[] sendTest2 = {"V0", null, "V1", "V2", null};
		numSendTest = 4;
		gradeTest = "V2";
		expected = "invalid oversize array";
				
		try {
			int sizeTest = ExceptionalClimbing.sendClimb(sendTest2, numSendTest, gradeTest);
			return false;
		} catch (DataFormatException dfe) {
			if (dfe.getMessage() == null || dfe.getMessage().length() == 0) {
				return false;
			}
			String message = dfe.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		// Valid input causes no exceptions
		String[] sendTest3 = {"V0", "V2", null, null, null};
		numSendTest = 2;
		gradeTest = "V2";
				
		try {
			int sizeTest = ExceptionalClimbing.sendClimb(sendTest3, numSendTest, gradeTest);
		} catch (Exception e) {
			return false;
		}
		
		
		// Combinations of these error conditions
		String[] sendTest4 = {"V0", null, "V1", "V2", "V2"};
		numSendTest = 5;
		gradeTest = "V8";
		expected = "V8 is not a valid grade";
				
		try {
			int sizeTest = ExceptionalClimbing.sendClimb(sendTest4, numSendTest, gradeTest);
			return false;
		} catch (IllegalArgumentException iae) {
			if (iae.getMessage() == null || iae.getMessage().length() == 0) {
				return false;
			}
			String message = iae.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (DataFormatException dfe) {
			return false;
		} catch (Exception e) {
			return false;
		}
		
		
		return true;
		
	}
	
	/**
	 * Create an oversized array of Strings to test the failClimb() method
	 * 
	 * @return true if ALL of the return values from failClimb() match the expectations;
	 * false otherwise
	 */
	public static boolean testFailClimb() {
		
		//Invalid grade causes IllegalArgumentException
		String[] failTest = {"V0", null, null, null, null};
		int numFailTest = 1;
		String gradeTest = "V8";
		String expected = "V8 is not a valid grade";
		
		try {
			int sizeTest = ExceptionalClimbing.failClimb(failTest, numFailTest, gradeTest);
			return false;
		} catch (IllegalArgumentException iae) {
			if (iae.getMessage() == null || iae.getMessage().length() == 0) {
				return false;
			}
			String message = iae.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

		
		//Full array causes IllegalArgumentException
		String[] failTest1 = {"V0", "V1", "V1", "V2", "V2"};
		numFailTest = 5;
		gradeTest = "V2";
		expected = "cannot add new value to full length 5 array";
				
		try {
			int sizeTest = ExceptionalClimbing.failClimb(failTest1, numFailTest, gradeTest);
			return false;
		} catch (IllegalArgumentException iae) {
			if (iae.getMessage() == null || iae.getMessage().length() == 0) {
				return false;
			}
			String message = iae.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		
		//Array with null elements or invalid size causes DataFormatException
		String[] failTest2 = {"V0", null, "V1", "V2", null};
		numFailTest = 4;
		gradeTest = "V2";
		expected = "invalid oversize array";
				
		try {
			int sizeTest = ExceptionalClimbing.failClimb(failTest2, numFailTest, gradeTest);
			return false;
		} catch (DataFormatException dfe) {
			if (dfe.getMessage() == null || dfe.getMessage().length() == 0) {
				return false;
			}
			String message = dfe.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
			
			return false;
		}
		
		// Valid input causes no exceptions
		String[] failTest3 = {"V0", "V2", null, null, null};
		numFailTest = 2;
		gradeTest = "V2";
				
		try {
			int sizeTest = ExceptionalClimbing.failClimb(failTest3, numFailTest, gradeTest);
		} catch (Exception e) {
			return false;
		}
		
		
		// Combinations of these error conditions
		String[] failTest4 = {"V0", null, "V1", "V2", "V2"};
		numFailTest = 5;
		gradeTest = "V8";
		expected = "V8 is not a valid grade";
				
		try {
			int sizeTest = ExceptionalClimbing.failClimb(failTest4, numFailTest, gradeTest);
			return false;
		} catch (IllegalArgumentException iae) {
			if (iae.getMessage() == null || iae.getMessage().length() == 0) {
				return false;
			}
			String message = iae.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		
		} catch (DataFormatException dfe) {
			return false;
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Create oversized arrays of Strings to test the getStats() method
	 * 
	 * @return true if ALL of the return values from getStats() match the expectations;
	 * false otherwise
	 */
	public static boolean testGetStats() {
		
		// Check if valid input causes no exceptions
		String[] send = {"V0", "V2", null, null, null};
		int numSend = 2;
		String[] fail = {"V1", "V0", "V2","V1", null};
		int numFail = 4;
		int historyLength = 3;
						
		try {
			String Averages = ExceptionalClimbing.getStats(send, numSend, fail, numFail, historyLength);
		} catch (Exception e) {
			return false;
		}
		
		
		// Check if both arrays empty causes RuntimeException
		String[] send1 = {"V0", "V2", null, null, null};
		numSend = 0;
		String[] fail1 = {"V1", "V0", "V2","V1", null};
		numFail = 0;
		historyLength = 3;
		String expected = "no climbs provided";
								
		try {
			String Averages = ExceptionalClimbing.getStats(send1, numSend, fail1, numFail, historyLength);
			return false;
		} catch (IllegalArgumentException iae) {// ensure fake iae will not be caught by re catch block
			return false;
		} catch (RuntimeException re) {
			if (re.getMessage() == null || re.getMessage().length() == 0) {
				return false;
			}
			String message = re.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		
		// Check if negative or 0 historyLength causes IllegalArgumentException
		String[] send2 = {"V0", "V2", null, null, null};
		numSend = 2;
		String[] fail2 = {"V1", "V0", "V2","V1", null};
		numFail = 4;
		historyLength = 0;
		expected = "0 is not a valid history length";
								
		try {
			String Averages = ExceptionalClimbing.getStats(send2, numSend, fail2, numFail, historyLength);
			return false;
		} catch (IllegalArgumentException iae) {
			if (iae.getMessage() == null || iae.getMessage().length() == 0) {
				return false;
			}
			String message = iae.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
//			e.printStackTrace(System.out);
			return false;
		}
			
		
		// Combinations of these error conditions
		String[] send3 = {"V0", "V2", null, null, null};
		numSend = 0;
		String[] fail3 = {"V1", "V0", "V2","V1", null};
		numFail = 0;
		historyLength = 0;
		expected = "no climbs provided";
								
		try {
			String Averages = ExceptionalClimbing.getStats(send3, numSend, fail3, numFail, historyLength);
			return false;
		} catch (IllegalArgumentException iae) {
			return false;
		} catch (RuntimeException re) {
			if (re.getMessage() == null || re.getMessage().length() == 0) {
				return false;
			}
			String message = re.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}	
		
		} catch (Exception e) {
//			e.printStackTrace(System.out);
			return false;
		}
		
		
		
		return true;
		
	}
	
	/**
	 * Create oversized arrays of Strings to test the getHistogram() method
	 * 
	 * @return true if ALL of the return values from getHistogram() match the expectations;
	 * false otherwise
	 */
	public static boolean testGetHistogram() {
		
		// Valid input causes no exceptions
		String[] send = {"V0", "V2", null, null, null};
		int numSend = 2;
		String[] fail = {"V1", "V0", "V2","V1", null};
		int numFail = 4;
		
		try {
			String Histogram = ExceptionalClimbing.getHistogram(send, numSend, fail, numFail);
		} catch (Exception e) {
//			e.printStackTrace(System.out);
			return false;
		}
		
		// Both arrays empty causes RuntimeException
		String[] send1 = {"V0", "V2", null, null, null};
		numSend = 0;
		String[] fail1 = {"V1", "V0", "V2","V1", null};
		numFail = 0;
		String expected = "no climbs provided";
		
		try {
			String Histogram = ExceptionalClimbing.getHistogram(send1, numSend, fail1, numFail);
			return false;
		} catch (RuntimeException re) {
			if (re.getMessage() == null || re.getMessage().length() == 0) {
				return false;
			}
			String message = re.getMessage();
//			System.out.println(message);
			if (!message.equals(expected)) {
				return false;
			}
		} catch (Exception e) {
//			e.printStackTrace(System.out);
			return false;
		}
		
		
		return true;
	}
	
	/**
	 * Contains one call to each test method above
	 * 
	 * @return true if and only if all test methods return true; false otherwise.
	 */
	public static boolean runAllTests() {
		if (!testSendClimb()) {
			return false;
		}
		if (!testFailClimb()) {
			return false;
		}
		if (!testGetStats()) {
			return false;
		}
		if (!testGetHistogram()) {
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
		runAllTests();
	}

}
