package package5_Sorting;

import java.util.Arrays;

public class P6_Quick_Sort {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void quickSort(int[] arr, int s, int e) {

		if(s>=e) {
			return;
		}
		
		int idx = partition2(arr, s, e);
		quickSort(arr, s,     idx-1);
		quickSort(arr, idx+1, e);
		
	}
	
	public static int partition(int[] arr, int s, int e) {
		
		int i = s-1;
		
		int pivot = e;
		
		for(int j=s;j<e;j++) {
			if(arr[j] < arr[pivot]) {
				i++;
				swap(arr, i, j);
			}
		}
		
		i++;
		swap(arr, i, pivot);
		
		return i;
		
	}
	
	static  int partition2(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }

	public static void main(String[] args) {

		int[] arr = { 6, 3, 9, 8, 2, 5 };

		int s = 0;
		int e = arr.length - 1;
		quickSort(arr, s, e);

		System.out.println(Arrays.toString(arr));

	}

}
