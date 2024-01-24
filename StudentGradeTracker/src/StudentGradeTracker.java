
import java.util.*;

public class StudentGradeTracker {

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totStudents = 40;

        // this array stores the name of 40 students
        String[] student_name = new String[totStudents];

        int[][] student_marks = new int[totStudents][5]; // 5 subject marks of 40 students

        // counter for the tot students
        int student = 0;

        int choice;

        do {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("\nMenu");
            System.out.println("1.Add Student Details");
            System.out.println("2.Display the grade");
            System.out.println("3.Display Student details");
            System.out.println("4.Exit");
            System.out.println("--------------------------------------------------------------------------");

            System.out.println("Enter your choice (1 - 4): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (student < totStudents) {
                        addStudentDetails(sc, student_name, student_marks, student);
                        student++;
                    } else {
                        System.out.println("\n------------Maximum number of students reached!------------\n");
                    }
                    break;

                case 2:
                    displayGrades(student_name, student_marks, student);
                    break;

                case 3:
                    displayStudentDetails(student_name, student_marks, student);
                    break;

                case 4:
                    System.out.println("\n------------Exiting the Program. Bye !!!-------------\n \t------------*******------------");
                    break;

                default:
                    System.out.println("Incorrect choice! Please enter the correct choice.");
            }
        } while (choice != 4);

        sc.close();
    }



    // Create method to add the student details
    public static void addStudentDetails(Scanner sc, String[] student_name, int[][] student_marks, int index) {

        System.out.print("Enter student name: ");
        student_name[index] = sc.next();

        System.out.println("Enter the marks for 5 subjects (out of 100): ");
        for (int i = 0; i < 5; i++) {
            System.out.print(getSubjectName(i) + ": ");
            student_marks[index][i] = sc.nextInt();
        }

        System.out.println("\n---------Student details added successfully!-----------\n\n");
    }



    // create a method for the display grades
    public static void displayGrades(String[] student_name, int[][] student_marks, int student) {
        System.out.println("\nGrades");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s%-20s%-15s%-10s\n", "Index  ", "Student Name", "Percentage", "Grade");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < student; i++) {
            System.out.printf("%-10s%-20s", (i + 1), student_name[i]);
            // Calculate percentage
            double percentage = calculatePercentage(student_marks[i]);

            // Determine the grade based on the percentage
            char grade = determineGrade(percentage);

            System.out.printf("%-15.2f%-10s\n", percentage, grade);

        }
        System.out.println("---------------------------------------------------------------");
    }



    // Method to display student details
    public static void displayStudentDetails(String[] student_name, int[][] student_marks, int student) {
        System.out.println("\nStudent Details:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-10s%-20s%-10s%-10s%-10s%-10s%-10s\n", "Index  ", "Student Name", "Physics", "Chemistry", "Math", "Biology", "English");
        System.out.println("-----------------------------------------------------------------------------");

        for (int i = 0; i < student; i++) {
            System.out.printf("%-10s%-20s", (i + 1), student_name[i]);

            // Display subject-wise marks
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-10s", student_marks[i][j]);
            }

            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------------------");
    }


    // method to calculate percentage
    public static double calculatePercentage(int marks[]) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return (totalMarks / (double) (5 * 100)) * 100;
    }



    // method to determine the grade based on percentage
    public static char determineGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else if(percentage >= 40){
            return 'E';
        }else {
            return 'F';
        }
    }



    // method for getSubjectName
    public static String getSubjectName(int index) {
        switch (index) {
            case 0:
                return "Physics";

            case 1:
                return "Chemistry";

            case 2:
                return "Maths";

            case 3:
                return "Biology";

            case 4:
                return "English";

            default:
                return "Unknown Subject";
        }
    }


}
