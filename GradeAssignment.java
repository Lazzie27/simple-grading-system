import java.util.ArrayList;
import java.util.Scanner;

/**
 * GradeAssignment
 *
 * A beginner-friendly Java program demonstrating control flow:
 * - if-else statements to assign letter grades
 * - switch-case to show category messages
 * - while loop to process multiple students
 * - continue to skip invalid marks
 * - break to exit early with sentinel (-1)
 * - basic error handling for non-integer input
 *
 * Run with: javac GradeAssignment.java && java GradeAssignment
 */
public class GradeAssignment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Store letter grades so we can summarize them later
        ArrayList<Character> letterGrades = new ArrayList<>();
        int processedCount = 0;
        int totalMarks = 0;

        System.out.println("Grade Assignment Program (enter -1 to quit)");

        // Use a while loop to allow entering marks for several students
        while (true) {
            System.out.print("Enter student mark (0-100) or -1 to quit: ");

            // Error handling: ensure the user entered an integer
            if (!scanner.hasNextInt()) {
                String bad = scanner.next(); // consume the invalid token
                System.out.println("Invalid input '" + bad + "'. Please enter an integer between 0 and 100, or -1 to quit.");
                // continue to the next iteration of the loop (skip processing)
                continue;
            }

            int mark = scanner.nextInt();

            // break: allow exiting early when user enters -1
            if (mark == -1) {
                System.out.println("Quitting input loop.");
                break;
            }

            // continue: skip invalid marks outside the 0-100 range
            if (mark < 0 || mark > 100) {
                System.out.println("Mark out of range. Please enter a value between 0 and 100.");
                continue;
            }

            // if-else chain: determine letter grade from numeric mark
            char grade;
            if (mark >= 90) {
                grade = 'A';
            } else if (mark >= 80) {
                grade = 'B';
            } else if (mark >= 70) {
                grade = 'C';
            } else if (mark >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // switch-case: show a friendly message based on the letter grade
            switch (grade) {
                case 'A':
                    System.out.println("Grade: A - Excellent work!");
                    break;
                case 'B':
                    System.out.println("Grade: B - Good job!");
                    break;
                case 'C':
                    System.out.println("Grade: C - Satisfactory.");
                    break;
                case 'D':
                    System.out.println("Grade: D - Needs improvement.");
                    break;
                case 'F':
                    System.out.println("Grade: F - Failing. Encourage student to review material.");
                    break;
                default:
                    System.out.println("Unknown grade category.");
                    break;
            }

            // Save results for a summary later
            letterGrades.add(grade);
            processedCount++;
            totalMarks += mark;
        }

        // Summary: if any students were processed, show counts and average
        System.out.println();
        if (processedCount == 0) {
            System.out.println("No valid student marks were entered.");
        } else {
            double average = (double) totalMarks / processedCount;
            System.out.printf("Processed %d students. Class average: %.2f\n", processedCount, average);

            // Use a for loop to count occurrences of each letter grade
            int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
            for (char g : letterGrades) {
                switch (g) {
                    case 'A': countA++; break;
                    case 'B': countB++; break;
                    case 'C': countC++; break;
                    case 'D': countD++; break;
                    case 'F': countF++; break;
                }
            }

            System.out.println("Grade distribution:");
            System.out.println("A: " + countA + "  B: " + countB + "  C: " + countC + "  D: " + countD + "  F: " + countF);
        }

        scanner.close();
        System.out.println("Program finished. Thank you!");
    }
}
