//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Climbing Tracker - ClimbingTracker
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
 * This class models a Climbing Tracker
 */
public class ClimbingTracker {
	
	/**
	 * Add a successfully-completed climb's grade to end of the array of success climb
	 * 
	 * @param send  A string oversize array containing grade of success climb
	 * @param numSend  Number of content in a send array
	 * @param grade  newly added send grade  
	 * @return the resulting size of the send oversize array
	 */
	public static int sendClimb(String[] send, int numSend, String grade) {
		if ( (numSend < send.length) //enough room for new grade
				&& (grade.substring(0, 1).equals("V")) // valid grade
				&& (Integer.parseInt(grade.substring(1))<=7)
				&& (Integer.parseInt(grade.substring(1))>=0)) {
			send[numSend] = grade;
			++numSend;
			return numSend;
		} else {
			return numSend;
		}
	}
	
	/**
	 * Add a unsuccessfully-completed climb's grade to end of the array of unsuccessful climb
	 * 
	 * @param fail  A string oversize array containing grade of unsuccessful climb
	 * @param numFail  Number of content in a fail array
	 * @param grade  newly added fail grade  
	 * @return the resulting size of the fail oversize array
	 */
	public static int failClimb(String[] fail, int numFail, String grade) {
		if ( (numFail < fail.length) //enough room for new grade
				&& (grade.substring(0, 1).equals("V")) // valid grade
				&& (Integer.parseInt(grade.substring(1))<=7)
				&& (Integer.parseInt(grade.substring(1))>=0)) {
			fail[numFail] = grade;
			++numFail;
			return numFail;
		} else {
			return numFail;
		}
	}
	
	
	/**
	 * Creates a formatted String containing the average (mean) climb grade over
	 * the most recent historyLength number of climbs in each of the send and fail arrays
	 * 
	 * @param send  A string oversize array containing grade of unsuccessful climb
	 * @param numSend  Number of content in a fail array
	 * @param fail  A string oversize array containing grade of unsuccessful climb
	 * @param numFail  Number of content in a fail array
	 * @param historyLength  The most recent historyLength number of climbs in each of the send 
	 * and fail arrays
	 * @return a formatted String containing the average (mean) climb grade over
	 * the most recent historyLength number of climbs in each of the send and fail arrays
	 */
	public static String getStats(String[] send, int numSend, String[] fail, 
			int numFail, int historyLength) {
		
		int historySend = historyLength;
		int historyFail = historyLength;
		boolean isSendError = false;
		boolean isFailError = false;
		double avgSend;
		double avgFail;
		
		if (historyLength > numSend) {
			historySend = numSend;
		}
		if (historyLength > numFail) {
			historyFail = numFail;
		}
		if (numSend == 0) {
			isSendError = true;
		}
		if (numFail == 0) {
			isFailError = true;
		}
		if (historyLength <= 0) {
			isSendError = true;
			isFailError = true;
		}
		// if have valid input
		if (!isSendError && !isFailError) {
			int totalSend = 0;
			int totalFail = 0;
			
			for (int i=0; i<historySend; i++) {
				totalSend = totalSend + Integer.parseInt(send[numSend-1-i].substring(1));
			}
			avgSend = (double)totalSend/(double)historySend;
			
			for (int i=0; i<historyFail; i++) {
				totalFail = totalFail + Integer.parseInt(fail[numFail-1-i].substring(1));
			}
			avgFail = (double)totalFail/ (double)historyFail;
			return "send: " + avgSend + "\nfail: " + avgFail;
		} else if ((isSendError==true) && (isFailError==false)) {
			int totalFail = 0;
			
			for (int i=0; i<historyFail; i++) {
				totalFail = totalFail + Integer.parseInt(fail[numFail-1-i].substring(1));
			}
			avgFail = (double)totalFail/ (double)historyFail;
			return "send: --" + "\nfail: " + avgFail;
		} else if ((isSendError==false) && (isFailError==true)) {
			int totalSend = 0;
			
			for (int i=0; i<historySend; i++) {
				totalSend = totalSend + Integer.parseInt(send[numSend-1-i].substring(1));
			}
			avgSend = (double)totalSend/ (double)historySend;
			return "send: " + avgSend + "\nfail: --";
		} else {
			return "send: --" + "\nfail: --";
		}
		
	}
	
	/**
	 * Creates and returns a formatted String containing the number of climbs at each grade
	 * from V0 to the highest graded climb in either array
	 * 
	 * @param send  A string oversize array containing grade of unsuccessful climb
	 * @param numSend  Number of content in a fail array
	 * @param fail  A string oversize array containing grade of unsuccessful climb
	 * @param numFail  Number of content in a fail array
	 * @return a formatted String containing the number of climbs at each grade
	 * from V0 to the highest graded climb in either array
	 */
	public static String getHistogram(String[] send, int numSend, String[] fail, int numFail) {
		if (numSend == 0 && numFail == 0) {
			return "Error: no data to display";
		}
		
		int maxGrade = 0;
		
		//find max grade for send array
		for (int i=0; i<numSend; i++) {
			if (Integer.parseInt(send[i].substring(1)) > maxGrade) {
				maxGrade = Integer.parseInt(send[i].substring(1));
			}
		}
		
		//find max grade for both send and fail
		for (int i=0; i<numFail; i++) {
			if (Integer.parseInt(fail[i].substring(1)) > maxGrade) {
				maxGrade = Integer.parseInt(fail[i].substring(1));
			}
		}
		
		
		int numTotal = maxGrade + 1; 
		String[] gradeRecord = new String[numTotal];
		
		// set each element of gradeRecord array as empty string
		for (int i=0; i<gradeRecord.length; i++) {
			gradeRecord[i] = "";
		}
		
		// add fail record
		for (int i=0; i<numFail; i++) {
			for (int j=0; j<numTotal; j++) {
				if (Integer.parseInt(fail[i].substring(1)) == j) {
					gradeRecord[j] = gradeRecord[j] + " -";
				}
			}
		}
		
		// add send record
		for (int i=0; i<numSend; i++) {
			for (int j=0; j<numTotal; j++) {
				if (Integer.parseInt(send[i].substring(1)) == j) {
					gradeRecord[j] = gradeRecord[j] + " +";
				}
			}
		}
		
		String output = "";
		for (int i=0; i<numTotal-1; i++) {
			output = output + "V" + i + ":" + gradeRecord[i] + "\n";
		}
		output = output + "V" + maxGrade + ":" + gradeRecord[numTotal-1];
		
		return output;
		
		
		
	}
	
	
	
}
