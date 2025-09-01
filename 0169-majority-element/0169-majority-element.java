class Solution {
    public int majorityElement(int[] nums) {
        
      int e1=0,count=0;

      for(int i=0;i<nums.length;i++){
        if(count==0)
           e1=nums[i];
        if(e1==nums[i])
         count++;
         else
         count--;


      }
       count=0;
      for(int i=0;i<nums.length;i++){

        if(nums[i]==e1)
         count++;
      
      if(count>nums.length/2)
        return e1;
    }
     return -1;
    }
}