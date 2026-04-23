class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int nr = s2.length()+1;
        int nc = s1.length()+1;
        int [][] dp = new int[nr][nc];
        //row 0
        for(int j = 1; j < nc; j++){
            dp[0][j] = dp[0][j- 1] + s1.charAt(j - 1);
        }
        //col 0
        for(int i = 1; i < nr; i++){
            dp[i][0] = dp[i - 1][0] + s2.charAt(i - 1);
        }
        //rest
        for(int i = 1; i < nr; i++){
            for(int j = 1; j < nc; j++){
                if(s2.charAt(i - 1) == s1.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j - 1] + s1.charAt( j - 1), dp[i - 1][j] + s2.charAt(i - 1));
                }
            }
        }
        return dp[nr - 1][nc - 1];
    }
}