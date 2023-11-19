package packagee13_Greedy;

import java.util.Arrays;

public class Tester {
	
	// Method to generate lexicographically smallest string
    public static void generateLexicographicallySmallestString(int length, int sum) {
        // Create an array to store character values
        int[] result = new int[length];
        
        // Initialize the array with the default values
        Arrays.fill(result, 1); // 'a' has a value of 1
        
        // Iterate over the array in reverse order
        for (int i = length - 1; i >= 0; i--) {
            // Adjust the sum based on the position in the string
            sum -= i;

            // Check if the sum is non-negative
            if (sum >= 0) {
                // If the sum is greater than or equal to 26, set the character value to 26
                if (sum >= 26) {
                    result[i] = 26;
                    sum -= 26;
                } else {
                    // Set the character value based on the remaining sum
                    result[i] = sum;
                    sum -= result[i];
                }
            } else {
                // Break out of the loop if the sum becomes negative
                break;
            }

            // Adjust the sum back after each iteration
            sum += i;
        }

        // Print the resulting array of character values
        System.out.println(Arrays.toString(result));
    }

	public static void main(String[] args) {

		int[] alphabetValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25, 26 };

		// Input
		int N = 3;
		int K = 42;

		generateLexicographicallySmallestString(N, K);
		
	}

}
