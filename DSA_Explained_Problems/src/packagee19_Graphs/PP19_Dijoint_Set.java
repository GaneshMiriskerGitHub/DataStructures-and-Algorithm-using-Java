package packagee19_Graphs;

public class PP19_Dijoint_Set {
	
	public static int findParent(int n, int[] par) {
		if(n == par[n]) {
			return n;
		}
		
		return findParent(par[n], par);
	}
	
	public static void union(int a, int b, int[] par, int[] rank) {
		int parOfA = findParent(a, par);
		int parOfB = findParent(b, par);
		
		if(rank[parOfA] == rank[parOfB]) {
			par[parOfB] = parOfA;     // basically making A as par:  par[B] = A;
			rank[parOfA]++;       // rank of A ++;
		}else if(rank[parOfA] > rank[parOfB]) {
			par[parOfB] = parOfA;
		}else {
			par[parOfA] = parOfB;
		}
	}

	public static void main(String[] args) {
	
		int n = 7;
		
		int[] par = new int[n];
		for(int i=0;i<n;i++) {
			par[i] = i;
		}
		int[] rank = new int[n];
		
		union(1, 3, par, rank);
		System.out.println(findParent(3, par));
		union(2, 4, par, rank);
		union(3, 6, par, rank);
		System.out.println(findParent(3, par));
		System.out.println(findParent(4, par));
		union(1, 5, par, rank);
		

	}

}
