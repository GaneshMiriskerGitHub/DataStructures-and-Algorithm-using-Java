package Type1_Fibbonacci;

public class P7_Jump_Game_3 {
	

	public static boolean print(int[] arr, int start, boolean[] vis) {
		
		if(start < 0 || start > arr.length-1 || vis[start]) {
			return false;
		}
		
		if(arr[start] == 0) {
			return true;
		}
		
		vis[start] = true;
		
		boolean leftPossible = print(arr, start-arr[start], vis);
		boolean rightPossible = print(arr, start+arr[start], vis);
		
		return leftPossible || rightPossible;
	}

	public static void main(String[] args) {

		int[] arr = {3,0,2,1,2};
		
		int start = 2;

		boolean[] vis = new boolean[arr.length];
		
		System.out.println(print(arr, start, vis));

	}

}
