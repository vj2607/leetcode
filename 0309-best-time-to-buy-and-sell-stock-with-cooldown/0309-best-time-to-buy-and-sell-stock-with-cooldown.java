class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return rec(0,1,prices,dp);
    }

    int rec(int i ,int buy,int[] nums,Integer[][] dp){
        if(i>=nums.length)
          return 0;

if(dp[i][buy]!=null)
    return dp[i][buy];
       int profit=0;
          if(buy==1){
  profit= Math.max(-nums[i]+rec(i+1,0,nums,dp),rec(i+1,1,nums,dp));
          }
          else{
          profit= Math.max(nums[i]+rec(i+2,1,nums,dp),rec(i+1,0,nums,dp));  
          }

          return dp[i][buy]= profit;
    }
}