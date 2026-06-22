class Solution {
    public int[] twoSum(int[] nums, int target) {
        
     int[] arr=new int[2];
     int n = nums.length;
     HashMap<Integer,Integer> map=new HashMap<>();
     for(int i=0;i<n;i++){
        int dif=target-nums[i];
        if(map.containsKey(dif)){
            return new int[]{map.get(dif),i};
        }else{
            map.put(nums[i],i);
        }
     }
     return arr;
       
    }
}