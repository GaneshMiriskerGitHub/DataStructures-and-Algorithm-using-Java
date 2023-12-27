package package7_Recursion;

public class P6_Tiling_Problem {   // GFG submission
	
	/*
	 * static final int MOD = 1000000007;
    
    static Map<Integer, Long> map = new HashMap<>();
    
    static Long numberOfWays(int N) {
        
        // code here
        //if(N < 0) return 0L;
        if ( N == 0 || N == 1 ) {
            return 1L%MOD;
        }
        
        if(map.containsKey(N)) {
            return map.get(N);
        }
        
        Long verticalPlacements = numberOfWays(N-1)%MOD;
        Long horizontalPlacements = numberOfWays(N-2)%MOD;
        
        map.put(N, ((verticalPlacements + horizontalPlacements)%MOD) );
        
        return map.get(N);
        
    }
	 * 
	 * */

	public static void main(String[] args) {
		
		

	}

}
