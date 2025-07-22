class Solution {
    public boolean canPartition(int[] nums) {
       int n =nums.length;
       int sum=0;
        for(int i=0;i<n;i++){
           sum+=nums[i];
        }
        if(sum%2!=0)
         return false;

        int s=sum/2;

         boolean[][] dp = new boolean[n][s+1];
         for(int i=0;i<n;i++)
         dp[i][0]=true;

          if(nums[0]<=s)
         dp[0][nums[0]]=true;

         for(int i=1;i<n;i++){
            for(int j=1;j<=s;j++){
                boolean non = dp[i-1][j];
                boolean take=false;
                if(j>=nums[i])
                take=dp[i-1][j-nums[i]];

                dp[i][j]=take || non;
            }
         }

         return dp[n-1][s];
    }
}