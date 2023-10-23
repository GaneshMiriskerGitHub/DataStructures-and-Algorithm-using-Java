package package3_2D_Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P6_No_of_Islands {
	
	public static int numIslands(char[][] grid) {
        int numOfIsland = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    numOfIsland++;
                    dfs(grid, i, j);
                }
            }
        }

        return numOfIsland;

    }

    public static void dfs(char[][] grid, int i, int j) {

        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

	public static void main(String[] args) {
		
		 char[][] grid = {
		            {'1', '1', '0', '0', '0'},
		            {'1', '1', '0', '0', '0'},
		            {'0', '0', '1', '0', '0'},
		            {'0', '0', '0', '1', '1'}
		        };
		
		System.out.println(numIslands(grid));
		
	}

	

}
