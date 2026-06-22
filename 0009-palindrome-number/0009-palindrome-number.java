class Solution {
    public boolean isPalindrome(int x) {
        int reversed = 0;
        boolean isneg=false;
        if(x<0){
            return false;
        }
        int n=x;
        while (x > 0) {
            int digit = x % 10;          
            reversed =( reversed * 10) + digit; 
            x /= 10;                    
        }
        System.out.println(reversed);
        if( reversed == n){
            return true;
        }
        return false;
    }
}