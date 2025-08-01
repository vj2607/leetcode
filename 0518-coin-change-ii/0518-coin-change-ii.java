class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
   int[][] dp = new int[n][amount+1];
    for(int i=0;i<=amount;i++){
        if(i%coins[0]==0)
        dp[0][i]=1;

        else 
        dp[0][i]=0;
    }
    for(int i=1;i<n;i++){
        for(int j=0;j<=amount;j++){
            int take =0;
            if(coins[i]<=j)
             take = dp[i][j-coins[i]];
             int non = dp[i-1][j];

             dp[i][j]= take+non;
        }
    }
    return dp[n-1][amount];
    }

  
}