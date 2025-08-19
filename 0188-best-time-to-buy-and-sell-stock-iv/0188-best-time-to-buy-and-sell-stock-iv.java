class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][k];
        return rec(0,1,0,k,prices,dp);
    }

    int rec(int i ,int buy,int trans,int k,int[] prices,Integer[][][] dp ){

        if(i==prices.length || trans==k)
           return 0;

           if(dp[i][buy][trans]!=null)
            return dp[i][buy][trans];

        int profit=0;

       if(buy==1){
        profit=Math.max(-prices[i]+rec(i+1,0,trans,k,prices,dp),rec(i+1,1,trans,k,prices,dp));
       }
       else{
      profit=Math.max(prices[i]+rec(i+1,1,trans+1,k,prices,dp),rec(i+1,0,trans,k,prices,dp));     
       }
            dp[i][buy][trans]=profit;
       return profit;
    }
}