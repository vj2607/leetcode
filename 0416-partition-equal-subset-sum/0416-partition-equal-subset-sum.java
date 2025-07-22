class Solution {
    public boolean canPartition(int[] nums) {
       
       int sum = 0;
       int n = nums.length;
      for(int i=0;i<n;i++){
        sum+=nums[i];
      }
      if(sum%2!=0)
       return false;

       boolean[][] dp = new boolean[n][sum/2+1];

         
      for(int i=0;i<n;i++)
        dp[i][0]=true;
    
    if(nums[0]<=sum/2)
      dp[0][nums[0]] =true;
      
      for(int i=1;i<n;i++){
          for(int j=1;j<=sum/2;j++){
              boolean nonTake = dp[i-1][j];
              boolean take = false;
    
    if(nums[i]<=j)
     take = dp[i-1][j-nums[i]];
      dp[i][j]= take||nonTake;
          }
      }
        
        return dp[n-1][sum/2];
    }
     
}