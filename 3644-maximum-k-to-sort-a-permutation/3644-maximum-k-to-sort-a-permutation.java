class Solution {
    public int sortPermutation(int[] nums) {
          int k= ~0;

          for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                k=k&nums[i];
            }
          }

          if(k== ~0)
          return 0;
        
        return k;
}
}