package packagee18_Graphs;

public class PPP21_FloodFill {
	
	public static void helper(int[][] image, int sr, int sc, boolean[][] vis, int origCol, int color) {
		
		if( sr<0 || sc<0 || sr>=image.length || sc >= image[0].length ||
				image[sr][sc] != origCol || vis[sr][sc] == true || image[sr][sc] == color) {
			return;
		}
		
		
		image[sr][sc] = color;
		
		vis[sr][sc] = true;
		
		// left
		helper(image, sr, sc-1, vis,origCol, color);
		//right
		helper(image, sr, sc+1, vis,origCol,color);
		//down
		helper(image, sr+1, sc, vis,origCol, color);
		//up
		helper(image, sr-1, sc, vis,origCol,color);
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		boolean[][] vis = new boolean[image.length][image[0].length];
		int originalCol = image[sr][sc];
		helper(image, sr, sc, vis, originalCol, color);		
		return image;
	}

	public static void main(String[] args) {
		
		

	}

}
