package package2_Arrays;

public class P8_Trapping_RainWater {

	public static int totalRainWaterTrapped(int[] arr) {

		int[] leftMax = new int[arr.length];
		leftMax[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}

		int[] rightMax = new int[arr.length];
		rightMax[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}

		int totalWater = 0;
		for (int i = 0; i < arr.length; i++) {
			int currMin = Math.min(leftMax[i], rightMax[i]);

			totalWater += currMin - arr[i];
		}

		return totalWater;
	}

	// optimized code
	public static int method2Efficient(int[] arr) { // reffered neetcode: but understood the code when looked myself manually when chatGPT shown me

		int s = 0;
		int e = arr.length - 1;

		int totalWater = 0;
		int i = 0;
		int leftMax = 0;
		int rightMax = 0;
		int trappedWater = 0;
		while (s < e) {

			if (arr[s] < arr[e]) {
				if (arr[s] > leftMax) {
					leftMax = arr[s];
				} else {
					trappedWater += leftMax - arr[s];
				}
				s++;
			} else {
				if (arr[e] > rightMax) {
					rightMax = arr[e];
				} else {
					trappedWater += rightMax - arr[e];
				}
				e--;
			}

		}
		
		return trappedWater;
	}

	public static void main(String[] args) {

		int[] arr = { 3, 0, 0, 2, 0, 4 };

		System.out.println(totalRainWaterTrapped(arr));
		
		System.out.println(method2Efficient(arr));

	}

}
