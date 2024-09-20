 import java.util.Scanner;

public class GradeCal{
    public static void main(String[] args) {
        // Step 1: Input Marks Obtained
        Scanner sc = new Scanner(System.in);
        System.out.println("student grade calculatore ");
        System.out.print("Enter the Number of Subjects");
        int n = sc.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        // Step 2: Calculate Total Marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Step 3: Calculate Average Percentage
        double averagePercentage = (totalMarks / (double) n) * 100;

        // Step 4: Grade Calculation
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else if (averagePercentage >= 50){
            grade = "E";
        }else {
            grade = "F";
        }

        // Step 5: Display Results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage is: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}

