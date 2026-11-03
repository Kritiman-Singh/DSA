class Solution {
    public int minMoves(int[] nums) {

        int n = nums.length;
        int first = nums[0];
       // int min = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > first){
                first = nums[i];
            }
        }
        //System.out.print(first);
        int c = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < first){
                c = c + first - nums[i];
            }
        } 
        return c;
        
    }
}