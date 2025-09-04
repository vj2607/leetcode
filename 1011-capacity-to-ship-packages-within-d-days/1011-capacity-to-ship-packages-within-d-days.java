class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max =weights[0],sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(weights[i]>max){
                max=weights[i];
            }
        }
        while(max<=sum){
            int mid= (max+sum)/2;
            if(isPossible(weights,days,mid)){
                 sum=mid-1;
            }
            else{
                max=mid+1;
            }
        }
        return max;
    }

    boolean isPossible(int[] nums,int days,int value){
          int count=0,sum=0;
          for(int i=0;i<nums.length;i++){
             if(sum+nums[i]<=value){
                sum+=nums[i];
              }
              else{
              sum=nums[i];
              count++;
              }
          }
          count++;
          return count<=days;
    }
}