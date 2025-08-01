class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return rec(n-1,amount,coins,dp)>=(int)1e9?-1:rec(n-1,amount,coins,dp);
    }
    int rec(int i , int amount,int[] coins,int[][] dp){
       
        if(i==0){
            if(amount%coins[0]==0)
             return amount/coins[0] ;

             return (int)1e9;
        }
        if(dp[i][amount]!=-1)
         return dp[i][amount];
        int take =(int)1e9;
        if(coins[i]<=amount)
         take = 1 + rec(i,amount-coins[i],coins,dp);

         int non = rec(i-1,amount,coins,dp);
     dp[i][amount]= Math.min(take,non);
         return Math.min(take,non);
    }
    
}