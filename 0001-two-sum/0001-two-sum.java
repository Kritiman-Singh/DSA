class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap();

        for(int i = 0 ; i < n ; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                arr[0] = i;
                arr[1] = map.get(temp);
            }else{
                map.put(nums[i] , i );
            }
        }
        return arr;
        
        
    }
}