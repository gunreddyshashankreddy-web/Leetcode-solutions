class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;
        while(left < right){
            // validate the ch --> left is letter or digit
            while((left < right) && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            // validate the ch --> right is letter or digit
            while((left < right) && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            //compare left ch with right ch
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        } 
        return true;  
    }
}