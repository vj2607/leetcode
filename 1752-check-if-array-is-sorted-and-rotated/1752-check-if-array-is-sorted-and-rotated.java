class Solution {
    public boolean check(int[] nums) {
         int peak =0;
         int n = nums.length;
         for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n])
              peak++;

         }

         return peak>1?false:true;
    }
}