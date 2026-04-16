class Solution {
    public boolean canJump(int[] nums) 
    {
        //step1 : find n = len nums
     int n = nums.length;
     //step2 : assign ls = n-1
     int lp = n - 1; 
     //step3 : iteration n-2 to 0
     // if cp(iter no) + steps from current index >= lp => true update lp
     for(int i = n-2; i >= 0; i--)
     {
        if(i + nums[i] >= lp)
        {
            //step4 : after looping : if last pos == 0
            lp = i;
        }
     }
     return lp == 0;
    }
}