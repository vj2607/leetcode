class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans= new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
                int a=-1;
                boolean flag=false;
            for(int j=0;j<nums2.length;j++){

                if(nums1[i]==nums2[j]){
                    flag=true;
                    continue;
                }
                if(flag && nums2[j]>nums1[i]){
                    a=nums2[j];
                    break;
                }
            }
            ans[i]=a;
        }

        return ans;
    }
}