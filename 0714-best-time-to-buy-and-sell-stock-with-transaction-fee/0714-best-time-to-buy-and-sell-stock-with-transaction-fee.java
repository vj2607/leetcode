class Solution {
    public int maxProfit(int[] prices, int fee) {

        Integer[][] dp = new Integer[prices.length][2];
        return rec(0,1,prices,fee,dp);
    }
    int rec(int i,int buy,int[] nums,int fee,  Integer[][] dp){
      if(i==nums.length)
        return 0;
        if(dp[i][buy]!=null)
          return dp[i][buy];
     int profit= 0;
     if(buy==1){
        profit= Math.max(-nums[i]+rec(i+1,0,nums,fee,dp),rec(i+1,1,nums,fee,dp));
     }
     else{
         profit= Math.max(nums[i]-fee+rec(i+1,1,nums,fee,dp),rec(i+1,0,nums,fee,dp));
     }

    return  dp[i][buy]=profit;

    }
}