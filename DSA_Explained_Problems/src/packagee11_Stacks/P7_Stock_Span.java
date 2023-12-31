package packagee11_Stacks;

import java.util.Arrays;
import java.util.Stack;

public class P7_Stock_Span {

	public static void main(String[] args) {
		
		int[] stocks = {100, 80, 60, 70, 60, 75, 85};
		
		int[] span = new int[stocks.length];
		
		Stack<Integer> st = new Stack<>();
		
		st.push(0);
		span[0] = 1;
		
		for(int i=1;i<stocks.length;i++) {
			
			int currValue = stocks[i];
			while( !st.isEmpty() && currValue > stocks[st.peek()]) {
				st.pop();
			}
			
			if(st.isEmpty()) {
				span[i] = i+1;
			}else {
				span[i] = i-st.peek();
			}
			
			st.push(i);
		}
		
		System.out.println(Arrays.toString(span));

	}

}
