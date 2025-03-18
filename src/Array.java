import java.util.Random;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        // Task 1: Declare array named dataPoints with a length of 100
        int[] dataPoints = new int[100];

        // Scanner + random number gen
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        // Task 2: create a for loop that initializes each element with a random value (1-100)
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Task 3: display dataPoints values, seperated by " | "
        System.out.print("Array values: ");
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.printf("%d", dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(); // Add a new line

        // Task 4: calculate the sum and average of dataPoints
        int sum = 0;
        double avg = 0;

        // Calculate the sum
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }

        // Calculate the average
        avg = (double)sum / dataPoints.length;

        // Print the results
        System.out.printf("\nThe sum of all values in the array is: %d\n", sum);
        System.out.printf("The average of all values in the array is: %.2f\n", avg);

        // Task 5: prompt user for a value between 1-100
        int userValue;

        // Using getRangedInt method from SafeInput to get value from user
        userValue = SafeInput.getRangedInt(in, "Enter a value to search for", 1, 100);

        // Task 6: search for user's input
        System.out.println("\nSearching for: " + userValue);
        int count = 0;

        // Iterate through the entire array
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                count++;
            }
        }

        // Print the results
        if (count > 0) {
            System.out.printf("%d was found %d time(s) in the array.\n", userValue, count);
        } else {
            System.out.printf("%d was not found in the array.\n", userValue);
        }

        // Task 7: ask the user for another value, and find the first position of the value
        int userValue2;
        int position = 0;
        boolean found = false;

        // Using getRangedInt method from SafeInput to get another value from user
        userValue2 = SafeInput.getRangedInt(in, "Enter another value to search for", 1, 100);

        // Iterate through the entire array
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue2) {
                found = true;
                position = i;
                break; // Break the loop if value is found
            }
        }

        // Print the results
        if (found) {
            System.out.printf("%d was found at position (index) %d in the array.\n", userValue2, position);
        } else {
            System.out.printf("%d was not found in the array.\n", userValue2);
        }

        // Task 8: scan for the minimum and maximum values in dataPoints
        int min = dataPoints[0]; // Assume first element is the min
        int max = dataPoints[0]; // Assume first element is the max

        // For loop to find both the min and max
        for (int i = 1; i < dataPoints.length; i++) {
            // Check to see if current element is smaller
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }

            // Check to see if current element is larger
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        // Display the results
        System.out.printf("\nThe minimum value in the array is: %d\n", min);
        System.out.printf("The maximum value in the array is: %d\n", max);

        // Task 9: use a static method to display the average of dataPoints
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

    }

    // Static method of getAverage
    public static double getAverage(int values[]) {
        int sum = 0;

        // Calculate the sum
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        // Return the average
        return (double)sum / values.length;
    }
}