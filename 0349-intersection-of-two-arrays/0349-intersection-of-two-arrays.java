class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        List<Integer> al = new ArrayList();
        int n1 = nums1.length;
        int n2 = nums2.length;

        for(int i = 0;i<n1;i++){
            for(int j = 0 ; j < n2 ; j++){
                if(nums1[i] == nums2[j] && !al.contains(nums1[i])){
                    al.add(nums1[i]);
                }
            }
        }
       return al.stream().mapToInt(Integer::intValue).toArray();

    }
}