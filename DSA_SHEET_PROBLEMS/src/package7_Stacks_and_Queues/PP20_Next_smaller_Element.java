package package7_Stacks_and_Queues;

import java.util.Stack;

public class PP20_Next_smaller_Element {
	
	// submission link:- https://practice.geeksforgeeks.org/problems/help-classmates--141631/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
	// resource :- Stacks : next greater element : apna college
	
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    Stack<Integer> st = new Stack<>();
	    
	    int[] res = new int[arr.length];
	    
	    for(int i=arr.length-1;i>=0;i--) {
	        
	        int currEle = arr[i];
	        
	        while(!st.isEmpty() && st.peek() >= currEle) {
	            st.pop();
	        }
	        
	        if(st.isEmpty()) {
	            res[i] = -1;
	            st.add(currEle);
	        }else {
	            res[i] = st.peek();
	            st.add(currEle);
	        }
	        
	    }
	    
	    return res;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
