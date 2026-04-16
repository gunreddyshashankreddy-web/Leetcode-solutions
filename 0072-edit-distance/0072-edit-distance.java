class Solution {
    public int minDistance(String w1, String w2) {
    int nr = w1.length() + 1;
    int nc = w2.length() + 1;
    int [][] dp = new int[nr][nc];
    // Row 0
    for(int j = 1; j < nc; j++){
        dp[0][j] = j;
    }
    // col 0
    for(int i = 1; i < nr; i++){
        dp[i][0] = i;
    }
    // rest
    for(int i = 1; i < nr; i++){
        for(int j = 1; j < nc; j++){
            if(w1.charAt(i - 1) == w2.charAt(j - 1)){
                dp[i][j] = dp[i - 1][j-1];
            }
            else{
                dp[i][j] = Math.min(dp[i-1][j] , Math.min(dp[i][j - 1] , dp[i - 1][j - 1])) + 1;
            }
            
        }
    }
    return dp[nr-1][nc-1];
    }
}