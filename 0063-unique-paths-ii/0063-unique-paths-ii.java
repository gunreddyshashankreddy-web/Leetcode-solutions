class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //if g(0,0) = 1 r -> 0 
        // nr
        //nc
        //creat dp of size nr * nc
        // Row 0
        //if cc -> obs -> no.of path = 0
        //if left of cc = 0 -> cc = 0
        
        int nr = obstacleGrid.length;
        int nc = obstacleGrid[0].length;
        int[][] dp= new int[nr][nc];
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        else{
            dp[0][0] = 1;
        }
        //Row 0
        for(int j = 1; j < nc; j++){
            if(obstacleGrid[0][j]==1){
                dp[0][j] = 0;
            }
            else if(dp[0][j-1]== 0){
                dp[0][j] = 0;
            }
            else{
                dp[0][j] = 1;
            }

        }
        //col 0 
        for(int i = 1; i < nr; i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            }
            else if(dp[i-1][0] == 0){
                dp[i][0] = 0;
            }
            else{
                dp[i][0] = 1;
            }
        }
        //rest 
        for(int i = 1; i<nr; i++){
            for(int j = 1; j < nc; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    int left = dp[i][j-1];
                    int top = dp[i-1][j];
                    dp[i][j] = left + top;
                }
            }
        }
        return dp[nr - 1][nc - 1];
    }
}