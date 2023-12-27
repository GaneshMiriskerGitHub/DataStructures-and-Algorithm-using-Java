package packagee19_Dynamic_Programming;

public class A9_Longest_Biotonic_Subsequence {

    public static int lbs(int[] arr) {
        int n = arr.length;
        int[] leftCount = new int[n];
        int[] rightCount = new int[n];

        // in leftCount array: at each currPosition check how many elements are lesser before and store the max 
        //                     till here (currPosition)
        for (int i = 0; i < n; i++) {
            leftCount[i] = 1;  // initial self count 1; so that it passes some valid 1 value to next cell
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    leftCount[i] = Math.max(leftCount[i], leftCount[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            rightCount[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    rightCount[i] = Math.max(rightCount[i], rightCount[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, leftCount[i] + rightCount[i] - 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(lbs(arr));
    }
}
