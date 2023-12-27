package package1_Arrays;

public class PP13_Maximum_Product_Subarray {

	public static int maxProduct(int[] arr) {

		int n = arr.length;

		int maxProduct = 0;
		int currProd = 1;
		int leftProduct = 1;
		int rightProduct = 1;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {

			leftProduct *= arr[i];
			rightProduct *= arr[n - i - 1];

			leftProduct = leftProduct == 0 ? 1 : leftProduct;
			rightProduct = rightProduct == 0 ? 1 : rightProduct;

			ans = Math.max(ans, Math.max(leftProduct, rightProduct));

		}

		return ans;

	}

	public static int maxProductSubArray(int[] arr) {

		if (arr.length == 1) {
			return arr[0];
		}

		int res = arr[0];
		int currMax = 1;
		int currMin = 1;
		for (int i = 0; i < arr.length; i++) {

			currMax = Math.max(arr[i], Math.max(arr[i] * currMax, arr[i] * currMin));
			currMin = Math.min(arr[i], Math.min(arr[i] * currMax, arr[i] * currMin));

			res = Math.max(currMax, res);

		}

		System.out.println(res);

		return res;

	}

	public static int maxProduct2(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int res = nums[0];
		int max = 1;
		int min = 1;

		for (int n : nums) {
			int tmp = max * n;
			max = Math.max(n, Math.max(tmp, min * n));
			min = Math.min(n, Math.min(tmp, min * n));
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {

		int[] arr = { 8, -2, -2, 0, 8, 0, -6, -8, -6, -1 };

		System.out.println(maxProductSubArray(arr));

	}

}
