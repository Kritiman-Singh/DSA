class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
              Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> al = new HashSet();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;

        
        while(i < n1 && j < n2 ){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums2[j] < nums1[i]){
                j++;
            }else{
                    al.add(nums1[i]);
                    i++;
                    j++;
            }
        }

        
       return al.stream().mapToInt(Integer::intValue).toArray();

    }
}