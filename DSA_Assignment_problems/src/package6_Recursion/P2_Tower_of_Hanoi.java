package package6_Recursion;

public class P2_Tower_of_Hanoi { // level hard :- https://www.youtube.com/watch?v=CfUmdjJwxL4

	// gfg submission
	public long toh(int N, int from, int to, int aux) {

		// Your code here
		if (N == 1) {
			System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
			return 1;
		}

		long count = 0;

		count += toh(N - 1, from, aux, to);
		System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
		count++;

		count += toh(N - 1, aux, to, from);

		return count;
	}
	
	public static void printCorrectAnswer(int n, String src, String dest, String helper) {

		if (n == 1) {
			System.out.println("shift from [" + src + " -> " + dest + "]");
			return;
		}

		printCorrectAnswer(n - 1, src, helper, dest);
		System.out.println("shift from [" + src + " -> " + dest + "]");
		printCorrectAnswer(n - 1, helper, dest, src);

	}

	public static void main(String[] args) {

		int n = 3;

		printCorrectAnswer(n, "A", "B", "C");

	}

}
