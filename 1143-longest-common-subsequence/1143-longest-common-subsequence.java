class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int nr = text2.length() + 1;
        int nc = text1.length() + 1;
        int[][] dp = new int[nr][nc];
        for(int i = 1; i < nr; i++){
            for(int j = 1; j < nc; j++){
                if(text2.charAt(i - 1) == text1.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[nr - 1][nc -1];
    }
}