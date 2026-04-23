class Solution {
    public int minDistance(String word1, String word2) {
        /*
        s1 - col
        s2 - row
        dp(m * n)
        row 0 -> col index
        col 0 -> row index
        rest
        if Rch == Cch
            draw -> dp[i, j]
        else
        dp[i, j] = min(l, t)
        */
        int nr = word2.length()+1;
        int nc = word1.length()+1;
        int[][] dp = new int[nr][nc];
        //row 0 
        for(int j = 0; j < nc; j++){
            dp[0][j] = j;
        
        }
        //col 0
        for(int i = 0; i < nr; i++){
            dp[i][0] = i;
        }
        //rest
        for(int i = 1; i < nr; i++){
            for(int j = 1; j < nc; j++){
                if(word2.charAt(i - 1) == word1.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1], dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[nr - 1][nc - 1];
    }
}