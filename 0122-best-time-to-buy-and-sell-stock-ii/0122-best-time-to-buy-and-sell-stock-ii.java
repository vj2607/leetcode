class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int[] arr :dp)
        Arrays.fill(arr,-1);
      return rec(0,1,prices,dp);
    }

    int rec(int i, int buy, int[] nums,int[][] dp){
        if(i==nums.length)
          return 0;
          if(dp[i][buy]!=-1)
           return dp[i][buy];
  int profit=0;
        if(buy==1){
           profit=Math.max(-nums[i] +rec(i+1,0,nums,dp),rec(i+1,1,nums,dp));
        }
        else{
            profit=Math.max(nums[i]+rec(i+1,1,nums,dp),rec(i+1,0,nums,dp));
        }

        return dp[i][buy]=profit;
    }
}