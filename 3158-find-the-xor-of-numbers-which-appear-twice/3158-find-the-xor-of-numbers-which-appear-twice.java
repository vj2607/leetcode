class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        
      long mask=0;
      int ans=0;
      for(int i=0;i<nums.length;i++){
        long bit= 1L << nums[i];
        if((mask & bit)==0){
            mask |=bit;
        }
        else{
            ans ^=nums[i];
        }
      }
      
        return ans;
    }
}