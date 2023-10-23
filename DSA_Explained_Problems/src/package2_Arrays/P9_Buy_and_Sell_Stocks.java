package package2_Arrays;

public class P9_Buy_and_Sell_Stocks {
	
	public static void maxProfit(int[] arr) {
		
		int minPrice = arr[0];
		int maxProfit = 0;
		for(int i=1;i<arr.length;i++) {
			
			int currPrice = arr[i];
			
			if(currPrice > minPrice) {
				int currProfit = currPrice - minPrice;
				maxProfit = Math.max(maxProfit, currProfit);
			}else {
				minPrice = currPrice;
			}
			
		}
		
		System.out.println(maxProfit);
		
	}

	public static void main(String[] args) {
		
		int[] arr =  {7, 1, 5, 3, 6, 4};
		
		maxProfit(arr);

	}

}
