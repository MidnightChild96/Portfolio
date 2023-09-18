import java.text.DecimalFormat;
import java.util.Scanner;

/* This has been an interesting project to solve. There are many variables to keep track of since everything is located in the main function it 
got pretty messy sometimes. While personally I believe this could be streamlined even further, the program works as intended with very few issues
if any exist. The printed messages are copied directly from the project outline, but the code itself is my own.*/

public class GradeCalculator {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##"); // for flavor this is used to print only 2 decimals out instead of
        // long floating numbers.
        int students; // Majority of the variables are declared here except for local variables.
        String[] studentList; // An array seemed to easiest to use to print every student back out at the end.
        int exams;
        double[][] studentScores; // A matrix was used for the scores using the same placement for the students
        String name;
        double highScore = -1; // both of these are declared to -1 in case if a student did get a score of 0 it
                               // wouldn't interfere if it printed -1 something has gone wrong
        double lowScore = -1;
        double classAverage = 0;
        Scanner input = new Scanner(System.in);
        System.out
                .println("I certify this is my own work Kevin Nguyen -nguyenk10@csp.edu.\nWelcome to GradeCalculator!");
        System.out.println("Please enter the number of students:");
        students = input.nextInt();
        studentList = new String[students]; // the list of students are given the size based on the user input
        System.out.println("Please enter the number of exams:");
        exams = input.nextInt();
        studentScores = new double[students][exams]; // the matrix of student scores is created based on student and
                                                     // exam amounts
        input.nextLine(); // the nextInt() does get rid of the \n character therefore this resets the
                          // input
        for (int i = 0; i < students; i++) {// sets all scores to -1 since 0 scores are possible
            for (int j = 0; j < exams; j++) {
                studentScores[i][j] = -1;
            }
        }
        for (int i = 0; i < students; i++) { // for loops were the most efficient way of going in down a line
            double score;
            double totalScore = 0;
            System.out.println("Enter student " + (i + 1) + "'s name:");
            name = input.nextLine();
            studentList[i] = name; // this adds the students name to the array for later
            System.out.println("Enter exam scores:");
            for (int j = 0; j < exams; j++) {
                score = input.nextDouble();
                if (score < 0) { // if the score is less than 0 it'll reset the loop and ignore the rest of the
                                 // user input and make the user insert a new input
                    System.out.println("Invalid exam scores. Please re-enter:");
                    j = -1; // this is set to -1 as it is still part of the loop and will reset back to 0
                            // when it has finished the loop
                    totalScore = 0;
                    input.nextLine(); // this ignores the rest of the input and forces the user to insert new exam
                                      // scores
                } else {
                    if (studentScores[i][0] > score || studentScores[i][0] == -1) {// changes student's lowest score
                                                                                   // value
                        studentScores[i][0] = score;
                    }
                    if (studentScores[i][1] < score || studentScores[i][1] == -1) {// changes student's highest score
                                                                                   // value
                        studentScores[i][1] = score;
                    }
                    totalScore += score; // all exam scores are added together before averaging
                }
            }
            studentScores[i][2] = totalScore / (double) exams; // this is added to the average list and finally averages
                                                               // the total score of the exams
            classAverage += studentScores[i][2];
            if (highScore == -1 || studentScores[i][1] > highScore) { // will update the highest average score if there
                                                                      // is
                                                                      // no score there currently or is greater than the
                                                                      // previous
                highScore = studentScores[i][1];
            }
            if (lowScore == -1 || studentScores[i][0] < lowScore) { // will update the lowest average score if none is
                                                                    // present or less than the previous score
                lowScore = studentScores[i][0];
            }
            input.nextLine(); // this resets the input again as the \n character is still there
        }
        input.close(); // no more user input is necessary from this point onward
        classAverage = classAverage / (double) students;
        for (int i = 0; i < students; i++) { // this loop is used to print every student's grades and assigns them a
                                             // letter grade.
            System.out.println("Grade statistics for " + studentList[i]);
            System.out.println("Average: " + df.format(studentScores[i][2])); // prints student's average score
            System.out.println("Lowest Score: " + studentScores[i][0]); // prints student's lowest score
            System.out.println("Highest Score: " + studentScores[i][1]); // prints student's highest score
            char grade;
            if (studentScores[i][2] > 89) { // A letter grade is assigned based on the average's threshold
                grade = 'A';
            } else {
                if (studentScores[i][2] > 79) {
                    grade = 'B';
                } else {
                    if (studentScores[i][2] > 69) {
                        grade = 'C';
                    } else {
                        if (studentScores[i][2] > 59) {
                            grade = 'D';
                        } else {
                            grade = 'F';
                        }
                    }
                }
            }
            switch (grade) { // a switch was used to assign messages to print based on the student's grade
                case 'A':
                    System.out.println("Letter Grade: A");
                    System.out.println(studentList[i] + " gets 4 stars. ****");
                    break;
                case 'B':
                    System.out.println("Letter Grade: B");
                    System.out.println(studentList[i] + " gets 3 stars. ***");
                    break;
                case 'C':
                    System.out.println("Letter Grade: C");
                    System.out.println(studentList[i] + " gets 2 stars. **");
                    break;
                case 'D':
                    System.out.println("Letter Grade: D");
                    System.out.println(studentList[i] + " gets 1 star. *");
                    break;
                default:
                    System.out.println("Letter Grade: F");
                    System.out.println(studentList[i] + " gets 0 stars. ");
            }
        }
        System.out.println("Class statistics:"); // this prints the class statistic which is only needed to be done
                                                 // once.
        System.out.println("Average: " + df.format(classAverage)); // prints class average
        System.out.println("Lowest: " + df.format(lowScore)); // prints class lowest
        System.out.println("Highest: " + df.format(highScore));// prints class highest
        System.out.println("Done. Good bye!"); // Exiting message
    }
}