package packagee13_Greedy;

public class A4_Buy_and_Sell_Stocks { // already solved

	public static void maxProfit(int[] arr) {

		int minSoFar = arr[0];
		int maxProfit = 0;
		for (int i = 1; i < arr.length; i++) {
			int sellingPrice = arr[i];

			if (minSoFar <= sellingPrice) {
				int profit = sellingPrice - minSoFar;
				maxProfit = Math.max(maxProfit, profit);
			}else {
				minSoFar = sellingPrice;
			}
		}
		
		System.out.println(maxProfit);

	}

	public static void main(String[] args) {

		int[] arr = { 7, 1, 5, 3, 6, 4 };

		maxProfit(arr);

	}

}
