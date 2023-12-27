package package3_String;

public class P2_Shortest_Path {
	
	public static double shorstestPath(String str) {
		int x=0;
		int y=0;
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch == 'W') {
				x = x-1;
			}
			if(ch == 'E') {
				x = x+1;
			}
			if(ch == 'N') {
				y = y+1;
			}
			if(ch == 'S') {
				y = y-1;
			}
		}
		
		double sqrt = Math.sqrt((x-0)*(x-0) + (y-0)*(y-0));
		
		return sqrt;
	}

	public static void main(String[] args) {
		
		String str = "WNEENESENNN";
		
		System.out.println(shorstestPath(str));;

	}

}
