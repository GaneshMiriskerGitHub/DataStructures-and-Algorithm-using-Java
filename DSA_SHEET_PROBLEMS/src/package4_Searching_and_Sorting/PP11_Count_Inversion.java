package package4_Searching_and_Sorting;

public class PP11_Count_Inversion {

	// brute force :- O(n*n) :
	// https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
	public static void countInversions(int[] arr) {

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					count++;
				}
			}
		}

		System.out.println(count);

	}

	// Optimisation using merge sort knowledge
	// link:- https://www.youtube.com/watch?v=owZhw-A0yWE
	// solution: copy paste merge sort code with putting count in merge() count=leftpart array size from > contion ele
	public static int mergeSort(int[] arr, int s, int e) {

		if (s >= e)
			return 0;

		int count = 0 ;
		
		int m = s + (e - s) / 2;

		count+= mergeSort(arr, s, m);
		count+= mergeSort(arr, m + 1, e);

		count+= merge(arr, s, m, e);
		
		return count;
	}

	public static int merge(int[] arr, int s, int m, int e) {
		int[] temp = new int[e - s + 1];
		
		int count = 0;
		
		int i = s;
		int j = m + 1;
		int k = 0;
		while (i <= m && j <= e) {
			if (arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				count+= m-i+1;
				j++;
			}
			k++;
		}

		while (i <= m) {
			temp[k] = arr[i];
			i++;
			k++;
		}

		while (j <= e) {
			temp[k] = arr[j];
			j++;
			k++;
		}

		for (k = 0; k < temp.length; k++) {
			arr[s] = temp[k];
			s++;
		}
		
		return count;

	}

	public static void main(String[] args) {

		int[] arr = { 8, 4, 2, 1 };

		countInversions(arr);
		
		System.out.println(mergeSort(arr, 0, arr.length-1));

	}

}
