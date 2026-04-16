class Solution {
    public int minPathSum(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int[][] dp= new int[nr][nc];
        
            dp[0][0] = grid[0][0];
        // Row 0
      for(int j = 1; j< nc; j++){
        dp[0][j] = dp[0][j-1] + grid[0][j];
      }  
      //col 0
      for(int i = 1; i < nr; i++){
        dp[i][0] = dp[i - 1][0] + grid[i][0];
      }
      // rest
      for(int i = 1; i < nr; i++){
        for(int j = 1; j < nc; j++){
            dp[i][j] = Math.min(dp[i - 1][j] , dp[i][j -1]) + grid[i][j]; 
        }
      }
      return dp[nr - 1][nc - 1];
    }
}