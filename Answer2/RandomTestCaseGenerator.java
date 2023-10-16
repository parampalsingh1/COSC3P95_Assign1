package COSC3P95_Assign1.Answer2;

/*
 * Name       : Parampal Singh
 * Student no.: 7003114
 */

import java.util.*;

public class RandomTestCaseGenerator {

    public RandomTestCaseGenerator() {
        int maxSize = 50;   // Define the maximum size of the random arrays
        int maxValue = 50;  // Define the maximum value for elements
        int testCount = 15; // Defines the number of test cases.

        runTest(maxSize, maxValue, testCount); // Runs the test
    }

    // Method to run the test cases
    public void runTest(int maxSize, int maxValue, int testCount) {
        for (int i = 0; i < testCount; i++) {
            int[] randArray = randomArray(maxSize, maxValue); // Generates a random array

            System.out.println("Test Number " + (i + 1) + ":");
            System.out.println("Input Array: " + Arrays.toString(randArray));

            sortArray(randArray); // Sorts the array

            System.out.println("Output Array: " + Arrays.toString(randArray));
            System.out.println("Is sorted? " + checkSort(randArray));
            System.out.println(" ");
        }
    }

    // Method to generate a random array with random size and values.
    public int[] randomArray(int maxSize, int maxValue) {
        Random rand = new Random();
        int sizeArr = rand.nextInt(maxSize) + 1;

        int[] randomArr = new int[sizeArr];

        for (int i = 0; i < sizeArr; i++) {
            randomArr[i] = rand.nextInt(maxValue * 2 + 1) - maxValue; // Generates random integer values
        }
        return randomArr;
    }

    // Method to validate if the array is sorted in ascending order.
    public boolean checkSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    // This method sorts the given input in ascending order
    public static void sortArray(int[] arr) {
        boolean swap = true;

        // Start a loop that continues until no swaps are made in a pass.
        while (swap) {
            swap = false;


            for (int i = 1; i < arr.length; i++) {
                // Compare the current element with the previous one.
                if (arr[i - 1] > arr[i]) {
                    // If the previous element is greater than the current one, swap them.
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swap = true;
                }
            }
        }
    }

    public static void main(String[] args) { new RandomTestCaseGenerator(); }
}
