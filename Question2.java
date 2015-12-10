// Question: 

// Given a m x n grid filled with non-negative numbers, find a path from top left
//  to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.


// The following is a solution using dynamic programming. The time complexity is 
// O(mn). The space complexity is also O(mn).

public class Question2 {
    public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] record = new int[m][n];
		record[0][0] = grid[0][0];
		// the following two for loops cover base cases
		for (int i = 1; i < m; i++)
			record[i][0] = record[i - 1][0] + grid[i][0];
		for (int i = 1; i < n; i++)
			record[0][i] = record[0][i - 1] + grid[0][i];
		// the following for loop covers inductive case
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				record[i][j] = grid[i][j] + Math.min(record[i - 1][j], record[i][j - 1]);
			}
		}
		return record[m - 1][n - 1];        
    }
}