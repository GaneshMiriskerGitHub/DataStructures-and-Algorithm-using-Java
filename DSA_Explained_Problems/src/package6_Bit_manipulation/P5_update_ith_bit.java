package package6_Bit_manipulation;

public class P5_update_ith_bit {
	
	public static void updateithBit(int n, int i, int newBit) {
		
		if(newBit == 0) {
			//clearithBit
			System.out.println(n & (~(1<<i)));
		}else {
			// setithBit
			System.out.println(n | (1<<i));
		}
		
	}

	public static void main(String[] args) {
		
		int i = 2;
		int n = 10;
		int newBit = 1;
		
		updateithBit(n, i, newBit);

	}

}
