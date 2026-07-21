class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int currsum = 0;
        int right = 0;
        for(int i = 0; i < k; i++){
            currsum += nums[i];
        }
        long maxsum = currsum;
        for(int i = k; i < nums.length; i++){
            currsum += nums[i] - nums[i-k];
            maxsum = Math.max(maxsum, currsum);
        }
        return(double) maxsum/k;
    }
}