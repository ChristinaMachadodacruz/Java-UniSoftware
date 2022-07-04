// Assignment number 4
// Written by: Christina Machado da Cruz #40192915
// For COMP 248 Section W 2214- Winter 2022, April 8,2022

// This program allows the user to manipulate a classroom management system. It allows to add, remove, edit/update students and
// their particulars, as well as view their individual report cards or the whole class' report card.


package finalpackage;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

class COMP248secU {
	
	private static int classSize;
	private static String semesterYear;
	private static String lectureRoom;
	private static String instructorFname;
	private static String instructorLname;
	private String[] studFname;
	private String[] studLname;
	private int [] studID;
	private double [] assgt1;
	private double [] assgt2;
	private double [] assgt3;
	private double [] assgt4;
	private double [] labs;
	private double[] midTerm;
	private double [] finalExam;
	//int sizes; 
	// global sizes variable used for constructor below.
	
	int counter =0;
	// global counter variable used for addstudent() and delStudent() method below.
	
	double WeightScore;
	// global weightscore variable, contains the values of local WeightScore variable below in
	// computeweightscore() method. Used for case 127, classreportcard() method, in if statement.
	

	
	// constructor
	COMP248secU(String fname, String lname, String room, String semYr, int size) {
		
		instructorFname=fname;
		instructorLname=lname ;
		lectureRoom=room;
		semesterYear=semYr;
		classSize = size;
		studFname = new String [classSize];
		studLname = new String [classSize];
		this.studID = new int[classSize];
		assgt1 = new double [classSize];
		assgt2 = new double [classSize];
		assgt3 = new double [classSize];
		assgt4 = new double [classSize];
		labs = new double [classSize];
		midTerm = new double [classSize];
		finalExam = new double [classSize];
		
		
		System.out.println();
		System.out.println("Code => Description");
		System.out.println("---------------------");
		System.out.println("103 => Enrol New Student");
		System.out.println("106 => Find Student Position in Class List");
		System.out.println("109 => Retrieve Student's Information");
		System.out.println("112 => Unenrol Student");
		System.out.println("115 => Update Student's Particulars");
		System.out.println("118 => Update Assignment Scores");
		System.out.println("121 => Update Other Scores");
		System.out.println("124 => Display Student's Report Card");		
		System.out.println("127 => Display Class Report Card");
		System.out.println("0 ===> Exit");
		System.out.println();
		System.out.print("Please enter a Code, from the aforementioned, that corresponds to your task: ");
		
		

	
	
	
	}



	
public void addStudent(String fname, String lname, int studID, int arrIdx) {
		
	arrIdx = counter;
	if (counter > 0) {
	if (this.studID[counter-1] == 0) {
		
		counter = counter-1;
		
		
	}}
	
		studFname[arrIdx] = fname;
		studLname[arrIdx] = lname;
		this.studID[arrIdx] = studID;
		counter++;
		
//This method adds a student to the first name, last name and studID arrays. 
//If statement is executed if in the this.studID array, there is a 0 preceding any filled
//indexes. If that is the case, the statement pushes the filled value down one index, so that it
//follows immediately after another filled index. This if statement is useful for when a student
//is deleted (i.e. the delStudent() method), so that the values following the deleted student
//go down one index in order to have a continuous array of information.
	
	
	
}



public int getStudentIdx(int studID) {
	

	int index =0;

	for (int i=0; i < this.studID.length; i++) {
		if (this.studID[i] == studID) {
			index = i;
		}
	}

	return index;
	//This method uses the index of the studID in the this.studID array and returns that value to show to the user the position
	//of the student in the class.
}
	


public String[] getStudentInfo(int studID) {
  

		
	int index = this.getStudentIdx(studID);

	
	String indexlastname = "Student's First Name = " + studFname[index];
	String indexfirstname = "\nStudent's Last Name = " + studLname[index];
	String studentID = "\nStudent's ID = " + Integer.toString(studID);
	

	String ass1 = "\nScore in Assignment 1 = " + assgt1[index];
	String ass2 = "\nScore in Assignment 2 = " + assgt2[index];
	String ass3 = "\nScore in Assignment 3 = " + assgt3[index];
	String ass4 = "\nScore in Assignment 4 = " + assgt4[index];
	String cumullabs = "\nCumulative Score in Labs = " + labs[index];
	String MidTerms = "\nMid-Term Test Score = " + midTerm[index];
	String Finals = "\nFinal Examination Score= " + finalExam[index];
	

	String [] myarray = {indexlastname,indexfirstname,studentID, ass1, ass2, ass3, ass4, cumullabs, MidTerms, Finals};

	
	return myarray;
	
//This method uses the index of the studID in the this.studID array and uses that index in the first and last name arrays as well
//as the assessment arrays and prints out to the user the appropriate info for that index in those arrays.
	
	 
}

public int delStudent(int studID) {
  
	if (studID == this.studID[this.getStudentIdx(studID)]) {
		
		for (int i = this.getStudentIdx(studID) +1 ; i < classSize ; i++) {
			this.studID[i-1] = this.studID[i];
			studFname[i-1] = studFname[i];
			studLname[i-1]=studLname[i];
		}
	
	
		counter--;
		return 1;
	}
	else {
		return 2;
	}

//This method deletes the studID from the this.studID array. The for loop above brings down by one
//the index of each element after the studID deleted, so that there are no empty spots between different studIDs
//and there is continuous information in the this.studID array.


}

public int updateStudentPart(String fname, String lname, int studID) {
   
	
	
	int index = this.getStudentIdx(studID);
	
	
	studFname[index] = fname;
	studLname[index] = lname;

	
	return studID;

//this method updates the first and last name of the studID. The index of the studID in the this.studID array is used
//in the studFname and studLname arrays so that they can be updated with new information that the user inputs.

}

public int updateAssgtScore(double a1, double a2, double a3, double a4, int studID) {
  
	

	int index = this.getStudentIdx(studID);
	assgt1[index] = a1;
	assgt2[index] = a2;
	assgt3[index] = a3;
	assgt4[index] = a4;
	
	
	return studID;

//this method updates the four assignments of the studID. The index of the studID in the this.studID array is used
//in these arrays so that they can be updated with new information that the user inputs.


}

public int updateOtherScore(double lab, double test, double exam, int studID) {
	
	
	
	int index = this.getStudentIdx(studID);
	
	labs[index] = lab;
	midTerm[index]=test;
	finalExam[index]=exam;	
	
	
	
	return studID;


//this method updates the labs, midterm and final of the studID. The index of the studID in the this.studID array is used
//in these arrays so that they can be updated with new information that the user inputs.


}

public double computeWeightScore(int studID) {
	
int index =this.getStudentIdx(studID);
   
double weightsScore = assgt1[index]*0.02+ assgt2[index]*0.03+ assgt3[index]*0.05+assgt4[index]*0.08+labs[index]*0.12+midTerm[index]*0.3+finalExam[index]*0.40;

this.WeightScore = weightsScore;
	
return weightsScore;

//This method returns the cumulated weighted score of the studID. It uses the index of studID in the this.studID array, and takes 
//the information from the index in each of the assessment arrays, and then computes the score based on the appropriate weight
//of each assessment.

}

public static char computeGrade(double wgtScore) {
   char lettergrade = 0;
   
	
   if (wgtScore >= 88) {
		lettergrade = 'A';
	
   }
	else if (wgtScore < 88 && wgtScore >= 80 ) {
		lettergrade = 'B';
	}
	
	else if (wgtScore < 80 && wgtScore >= 67 ) {
		lettergrade = 'C';
	}
	else if (wgtScore < 67 && wgtScore >= 60 ) {
		lettergrade = 'D';
	}
	else if (wgtScore < 60 ) {
		lettergrade = 'F';
	}
	
	return lettergrade;
	
//this method uses and if statement to determine the appropriate letter grade of the studID according to the weightScore determined
//in the computerWeightScore() method.
}

public static double findMin(double[]dataArr) {
	
	 double minValue = dataArr[0]; 
	 
	    for(int i=1;i<dataArr.length;i++){ 
	      if(dataArr[i] < minValue){ 
	        minValue = dataArr[i]; 
	      }
	    }
	   
		return minValue;
		
}
//this method determines the minimum value of the double array input.
//It is rounded to two decimals by using the Math.round() method and multiplying and dividing the value by 100.00.

public static double findMax(double[]dataArr) {
  
	 double maxValue = dataArr[0]; 
	 
	    for(int i=1;i < dataArr.length;i++){ 
	      if(dataArr[i] > maxValue){ 
	         maxValue = dataArr[i]; 
	      }
	    }
	

		return maxValue;


//this method determines the maximum value of the double array input.
//It is rounded to two decimals by using the Math.round() method and multiplying and dividing the value by 100.00.

}

public static double findAvg(double[]dataArr) {
	
	
	double sum = 0.0;
	
   for (int i = 0; i < dataArr.length; i++) {
        sum += dataArr[i];
    }

	double average = sum/dataArr.length;
	
	
	return average;
	
//this method determines the average value of the double array input.
//It is rounded to two decimals by using the math.round() method and multiplying and dividing the value by 100.00.
}

public double[] getClassMin() {
   
	
this.findMin(assgt1);
this.findMin(assgt2);
this.findMin(assgt3);
this.findMin(assgt4);
this.findMin(labs);
this.findMin(midTerm);
this.findMin(finalExam);

double [] minimums = {this.findMin(assgt1),this.findMin(assgt2),this.findMin(assgt3),this.findMin(assgt4),this.findMin(labs),this.findMin(midTerm),this.findMin(finalExam)};

	return minimums;
	
	
//This method retrieves the minimum value of each assessment array and creates a new double array consisting just those
//values.
}

public double[] getClassMax() {

	this.findMax(assgt1);
	this.findMax(assgt2);
	this.findMax(assgt3);
	this.findMax(assgt4);
	this.findMax(labs);
	this.findMax(midTerm);
	this.findMax(finalExam);
	double [] maximums = {this.findMax(assgt1),this.findMax(assgt2),this.findMax(assgt3),this.findMax(assgt4),this.findMax(labs),this.findMax(midTerm),this.findMax(finalExam)};

	return maximums;
	
	
//This method retrieves the maximum value of each assessment array and creates a new double array consisting just those
//values.
}

public double[] getClassAvg() {
	this.findAvg(assgt1);
	this.findAvg(assgt2);
	this.findAvg(assgt3);
	this.findAvg(assgt4);
	this.findAvg(labs);
	this.findAvg(midTerm);
	this.findAvg(finalExam);
	double [] averages = {this.findAvg(assgt1),this.findAvg(assgt2),this.findAvg(assgt3),this.findAvg(assgt4),this.findAvg(labs),this.findAvg(midTerm),this.findAvg(finalExam)};

	return averages;
	

//This method retrieves the average value of each assessment array and creates a new double array consisting just those
//values.
	
}

public void classReportCard() {
	
System.out.println("--------------------------------------------------------------------------------------------------------------------------");
System.out.println("First name \tLast name \tStud. ID \ta1 \t a2 \t a3 \t a4 \t labs \t test \t exam \t wgt \t*");
System.out.println("--------------------------------------------------------------------------------------------------------------------------");


for (int i = 0; i < this.studID.length; i++) {
	if (studFname[i]!=null || studLname[i] != null || this.studID[i] != 0 || assgt1[i] != 0.0 || assgt2[i] != 0.0  || assgt3[i] != 0.0  || assgt4[i]!=0.0 ||labs[i]!=0.0 ||midTerm[i]!=0.0 ||finalExam[i]!=0.0 ||this.WeightScore!=0.0 ) {
		System.out.printf("%-16s", studFname[i]);
		System.out.printf("%-16s", studLname[i]);
		System.out.printf("%-16s",studID[i]);
		
		System.out.printf("%.2f \t", assgt1[i]);
		System.out.printf("%s%.2f \t", " ",assgt2[i]);
		System.out.printf("%s%.2f \t", " ",assgt3[i]);
		System.out.printf("%s%.2f \t", " ",assgt4[i]);
		System.out.printf("%s%.2f \t", " ",labs[i]);
		System.out.printf("%s%.2f \t", " ",midTerm[i]);
		System.out.printf("%s%.2f \t", " ",finalExam[i]);
		System.out.printf("%s%.2f \t", " ", this.computeWeightScore(this.studID[i]));
		System.out.print(this.computeGrade(this.computeWeightScore(this.studID[i])));
		System.out.println();

	}
   
} 
System.out.println("--------------------------------------------------------------------------------------------------------------------------");
System.out.printf("%39s", "Minimum Score in Class:" );
System.out.printf("%9s", "");

	System.out.printf("%s%.2f \t", "", this.getClassMin()[0]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMin()[1]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMin()[2]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMin()[3]);

	System.out.printf("%s%.2f \t", " ", this.getClassMin()[4]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMin()[5]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMin()[6]);
	System.out.println();
	System.out.printf("%39s", "Average Score in Class:" );
	System.out.printf("%9s", "");
	System.out.printf("%s%.2f \t", "", this.getClassAvg()[0]);

	System.out.printf("%s%.2f \t", " ", this.getClassAvg()[1]);

	System.out.printf("%s%.2f \t", " ", this.getClassAvg()[2]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassAvg()[3]);

	System.out.printf("%s%.2f \t", " ", this.getClassAvg()[4]);

	System.out.printf("%s%.2f \t", " ", this.getClassAvg()[5]);

	System.out.printf("%s%.2f \t", " ", this.getClassAvg()[6]);
	System.out.println();
	
	System.out.printf("%39s", "Maximum Score in Class:" );
	System.out.printf("%9s", "");
	
	System.out.printf("%s%.2f \t", "", this.getClassMax()[0]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMax()[1]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMax()[2]);

	System.out.printf("%s%.2f \t", " ", this.getClassMax()[3]);

	System.out.printf("%s%.2f \t", " ", this.getClassMax()[4]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMax()[5]);
	
	System.out.printf("%s%.2f \t", " ", this.getClassMax()[6]);

System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");

	
	return ;
	
	
//Finally, this method returns the whole class report card. It is formatted using the printf statement accordingly.
//The for loop and if statement above are used to determine if any of the arrays contain at any index a null or 0.0 value (if the array is a double array),
//then the method does not print anything. This is executed when the class list is empty.
	
	
	
}


}




public class A4_Q1_Q2 {

	

	public static void main(String[] args) {
	
		System.out.println("Welcome to the Simple Classroom Management System:");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("Enter instructor's particulars (FirstName, LastName, LectureRoom, Semester, MaxClassSize) as a single-line entry:");
		// Displaying welcome message to user to indicate the program has begun.
		// Asking the user to input the first and last name of instructor, as well as the lecture room, semester and the class size for that class.
	
		Scanner UserInput = new Scanner(System.in);
		String userinputfirstname = UserInput.next();
		String userinputlastname = UserInput.next();
		String userinputlectureroom = UserInput.next();
		String userinputsemester = UserInput.next();
		// Creating object of Scanner class to allow for user input.
		// Created String variables for the appropriate user inputs.
		if (UserInput.hasNextInt()) {
		// Verifying that the user's input is in fact of data type integer. If it is not, program goes to else statement
		// below.
			int userinputclasssize = UserInput.nextInt();
		// assigning the user's integer input to an appropriate variable name.
			
	
				
			
				
	COMP248secU section = new COMP248secU(userinputfirstname,userinputlastname,userinputlectureroom,userinputsemester,userinputclasssize);
	// creating an instance of the constructor class in order to assign each element of the user's input to the appropriate parameter in the constructor.
	
	int index =0;
	// creating an index that increases by one each time the while loop below executes an instance. This is so that the while
	// loop will keep executing until the index exceeds the class size input by the user, since the program mustn't allow additional
	// students if the number has exceeded the class size.
	
	
				while (index <= userinputclasssize) {
				// while loop that allows user to re-enter a new code after having an option already executed per the user's request.
				// so long as the the class size number is not exceeded.
				int userwriting = UserInput.nextInt();
				// assigning to an integer variable the user's input that would be the code number.
				
			
				if (userwriting <= 127 && userwriting >= -128) {
				// if statement to ensure that if the user's input is a byte value, then the program proceeds.
				//Else, the program prints an error and asks the user to retry again. (see below for else statement.)
					switch(userwriting) {
					// using a switch statement to execute the appropriate case depending on what the user inputs as a code.
					
				
			case 103:
			
				
					
			System.out.println("Enrolling New Student. . .");
			System.out.println("---------------------------");
			System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single-line entry: ");
			// First case enrolls the student. Therefore message appears so that user can enter first and last name as well
			// as student ID of the student they want to enroll.
			
			Scanner user103 = new Scanner(System.in);
			String userfname103 = user103.next();
			String userlname103 = user103.next();
			// creating appropriate variables to assign the user's input.
			
			if (user103.hasNextInt()) {
			// validating user's input to ensure it is of integer type. Otherwise else statement gets executed (see below).
				
				int userid103 = user103.nextInt();
				// assigning to appropriate variable the user's integer input.
				
			try {
				
				section.addStudent(userfname103, userlname103, userid103, index);
			
				
			System.out.println("Student with ID: " + userid103  + " added succesfully.");
			// Using try-catch statement so that the program calls the addStudent method and prints out a "success" message.
			// If user tries to add a student when the max class size amount has been reached, an exception error occurs.
			// Therefore a catch statement is implemented below.
			}
			
			catch (Exception e) {
		
			
				System.out.println("Student with ID: " + userid103 + " CANNOT be added. Class is already full.");
			// catch statement in case user tries to add another student to an already full class size.
			// Program prints out that user cannot add student anymore.
			
			}
				
			
		
			
			index++;
			// increasing index by one since one student has been added to class.
			
			
			}
			
			else {
				System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
			// else statement if user doesn't input an integer data type. Program asks user to try again with a valid integer.
				
			}
				
			break;
				
				case 106:
				
					
					
				System.out.println("Finding Student's Position in Class List. . .");
				System.out.println("----------------------------------------------");
				System.out.println("Enter StudentID:");
				Scanner user106 = new Scanner(System.in);
			// This case determines the student's position (or index) in the class.
			// The program asks for the user to enter the particular student's ID number.
				
				if(user106.hasNextInt()) {
				// if statement to validate whether the input of the user is in fact an integer. If not, else
				//statement below is executed.
					
					int user106id = user106.nextInt();
					
					try {
						section.getStudentIdx(user106id);
						System.out.println("The position of student with ID: " + user106id + ", in the class list, is: " + section.getStudentIdx(user106id));
					}
					catch (Exception e) {
						
						System.out.println("Student with ID: " + user106id + " does NOT exist");
						System.out.println( "Unable to retrieve information for Student with ID: " + user106id);
					}
					// Try-catch statement. Try statement is executed if the UserID the user input exists, and thereafter the index
					// or position of the userID in the studID array is printed out.
					//Catch statement will be executed if user entered a userID that does not exist.
					}
				else {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}
					// else statement is executed if user entered a non-integer data type.

				break;
					
				
				case 109:
					System.out.println("Retrieving Student's Information . . . ");
					System.out.println("----------------------------------------");
					System.out.println("Enter StudentID:");
					Scanner user109 = new Scanner(System.in);
					
					if (user109.hasNextInt()) {
					// If statement is executed if user enters a valid integer data-type.
						
						int userid109 = user109.nextInt();
					
					try {
					section.getStudentInfo(userid109);
						
						System.out.println(Arrays.toString(section.getStudentInfo(userid109)).replace(",", "").replace("[", "").replace("]", "").trim());
					
					} 
					catch (Exception e) {
						System.out.println("Student with ID: " + userid109 + " does NOT exist.");
						System.out.print("Unable to retrieve information for Student with ID: " + userid109);
					}
					// Try-catch statement. Try statement is executed if the UserID the user input exists, and thereafter the student's ID
					// index is used in the last and first name arrays, as well as the assessment arrays and the appropriate info is
					// printed out.
					// Catch statement will be executed if user entered a userID that does not exist.
					}
					else {
						System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
					}
					// Else statement is executed if user enters a non-integer data type.
					break;
					
				case 112:
					System.out.println("Unenrolling Student ...");
					System.out.println("------------------------");
					System.out.println("Enter StudentID:");
					Scanner user112 = new Scanner(System.in);
					//This case unenrolls the student.
					// If statement to validate the user's input. 
					
					if (user112.hasNextInt()) {
					// If statement is executed if user enters a valid integer data-type.
						int userid112 = user112.nextInt();
						
					if (section.delStudent(userid112)==1) {
					
						System.out.println("Successfully removed Student with ID: " + userid112);
					// If the user enters a student ID that exists, the if statement gets executed, and therefore the delStudent() method
					// is called.
					}
					else {
						
						System.out.println("Student with ID: " + userid112 + " does NOT exist.");
						System.out.println("Unable to retrieve information for Student with ID: " + userid112);
					}
					// Else statement is executed if the user input an ID that does not exist.
					}
					else {
						System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
						// Else statement is executed if user enters a non-integer data type.
					}
					break;
					
				case 115:
					
					System.out.println("Updating Student's Particulars. . . ");
					System.out.println("-------------------------------------");
					System.out.println("Enter update to student's particulats (FirstName, LastName, StudentID) as a single-line emtry:");
					Scanner user115 = new Scanner(System.in);
					String user115firstname = user115.next();
					String user115lastname = user115.next();
					// This case updates the student's first and last name info in the respective arrays.
					
					if(user115.hasNextInt()) {
						int user115id = user115.nextInt();
						try {
							section.updateStudentPart(user115firstname, user115lastname,user115id );
							System.out.println("Successfully updated identification particulars for Student with ID: " + user115id);
						}
						catch (Exception e) {
							
							System.out.println("Student with ID: " + user115id + " does NOT exist");
							System.out.println( "Unable to retrieve information for Student with ID: " + user115id);
						}
						// Try-catch statement. Try statement is executed if the UserID the user input exists, and thereafter the index
						// of the userID in the studID array is used in the first name and last name arrays and the info is updated.
						//Catch statement will be executed if user entered a userID that does not exist.
						}
					else {
						System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
					}
					// Else statement is executed if user enters a non-integer data type.
						
					break;
				case 118:
					
					System.out.println("Updating Assignment Scores. . . ");
					System.out.println("-------------------------------------");
					System.out.println("Enter update to student's Assignment scores (Assignment1, Assignment2, Assignment3, Assignment4, StudentID) as a single-line emtry:");
					Scanner user118 = new Scanner(System.in);
					int user118ass1 = user118.nextInt();
					int user118ass2 = user118.nextInt();
					int user118ass3 = user118.nextInt();
					int user118ass4 = user118.nextInt();
					// This case updates the student's assessment scores (assignment 1 to assignment 4).
					
					if(user118.hasNextInt()) {
					// If statement is executed if user enters a valid integer data-type.
						
						int user118id = user118.nextInt();
						try {
							section.updateAssgtScore(user118ass1, user118ass2, user118ass3, user118ass4, user118id);
							System.out.println("Successfully updated Assignments' scores for Student with ID: " + user118id);
						}
						catch (Exception e) {
							
							System.out.println("Student with ID: " + user118id + " does NOT exist");
							System.out.println( "Unable to retrieve information for Student with ID: " + user118id);
						}
						// Try-catch statement. Try statement is executed if the UserID the user input exists, and thereafter the index
						// of the userID in the studID array is used for each assessment array (assignment 1 to assignment 4) and the info is updated.
						//Catch statement will be executed if user entered a userID that does not exist.
						}
					else {
						System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
					}
					// Else statement is executed if user enters a non-integer data type.
					break;
					
					
				case 121:
					System.out.println("Updating Other Scores. . . ");
					System.out.println("-------------------------------------");
					System.out.println("Enter update to student's scores (CumulativeLabs, MidTerm, FinalExam, StudentID) as a single-line emtry:");
					Scanner user121 = new Scanner(System.in);
					int user121lab = user121.nextInt();
					int user121midterm = user121.nextInt();
					int user121final = user121.nextInt();
					// This case updates the student's assessment scores (labs, midterm and final).
			
					
					if(user121.hasNextInt()) {
					//If statement to validate that user entered an integer data-type.
						
						int user121id = user121.nextInt();
						try {
							section.updateOtherScore(user121lab, user121midterm, user121final, user121id);
							System.out.println("Successfully updated Assignments' scores for Student with ID: " + user121id);
						}
						catch (Exception e) {
							
							System.out.println("Student with ID: " + user121id + " does NOT exist");
							System.out.println( "Unable to retrieve information for Student with ID: " + user121id);
						}
						// Try-catch statement. Try statement is executed if the UserID the user input exists, and thereafter the index
						//  of the userID in the studID array is used in the midterm, labs and final arrays to update the appropriate information.
						//Catch statement will be executed if user entered a userID that does not exist.
						}
					else {
						System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
					}
					// Else statement is executed if user entered a non-integer data-type.
					break;
					
				case 124:
					
					System.out.println("Displaying Student's Report Card. . . ");
					System.out.println("---------------------------------------");
					System.out.println("Enter StudentID:");
					Scanner user124 = new Scanner(System.in);
					//This case is used to display the report card for a student only.
					
					if(user124.hasNextInt()) {
					// If statement to validate that the user entered an integer data-type.
						
						int user124id = user124.nextInt();
						try {
							section.getStudentInfo(user124id);
							
							System.out.println(Arrays.toString(section.getStudentInfo(user124id)).replace(",", "").replace("[", "").replace("]", "").trim());
							System.out.println("Student's Cumulative Weighted Score = " + Double.toString(section.computeWeightScore(user124id)));
							System.out.println("Student's Final Letter Grade = " + section.computeGrade(section.computeWeightScore(user124id)));
					
						}
						catch (Exception e) {
							
							System.out.println("Student with ID: " + user124id + " does NOT exist");
							System.out.println( "Unable to retrieve information for Student with ID: " + user124id);
						}
						// Try-catch statement. Try statement is executed if the UserID the user input exists, and thereafter the index
						// of the userID in the studID array is used to retrieve student info in getStudentInfo() method. That same index is
						// also used in the computerWeightScore() method and computerGrade() method so the cumulative weighted score is
						// assessed and therefore the appropriate letter grade can be determined and printed out.
						// Catch statement will be executed if user entered a userID that does not exist.
						}
					else {
						System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
					}
					// Else statement is executed if user enters a non-integer data type.
					break;
					
				
				case 127:
					System.out.println("Displaying Class Report Card . . . ");
					System.out.println("------------------------------------");
					
					section.classReportCard();
					
				// Final case displays class report card through the classReportCard() method.
					
					
					break;
	
				
				case 0:
					System.out.print("\nThank you for patronizing our Simple Classroom Management System.");
					System.exit(0);
					// If user enters 0, program exits and is terminated.
					
				default:
					
				System.out.print("\nThank you for patronizing our Simple Classroom Management System.");
				System.exit(0);
				// If user enters a code that is a byte data-type but doesn't correspond to a code listed above, programs exits
				// and is terminated.
				
					}// END OF SWITCH STATEMENT
				
				System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
				// Message to user to continue with program by entering another code after one has been executed. This keeps
				// printing out after each execution of code as long as while loop is still valid.
			
				}//INNER IF STATEMENT
				
				else { //ELSE FOR INNER IF STATEMENT
					System.out.print("Error: Your input/entry is not a valid integer between -128 to 127. Kindly retry again!");
					System.exit(0);
					// If user enters a value that is not a byte data-type, program exits and asks user to retry again. Program
					// is terminated.
				}
			
			} //WHILE LOOP
			
			} //OUTER IF STATEMENT
			
			
	
		else {
			System.out.println("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
			// Else statement is the user enters for the class size a non-integer data type.
		}
			
	
	
	}

}
