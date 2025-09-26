class Solution {
    public int paintWalls(int[] cost, int[] time) {
       int n = time.length;
       long[][] dp = new long[n+1][n+1];

       for(int i=0;i<=n;i++){
          dp[i][0]=0L;
       }
       for(int i=1;i<=n;i++){
          dp[n][i]=(long)Integer.MAX_VALUE;
       }

       for(int i=n-1;i>=0;i--){
        for(int j=0;j<=n;j++){

            int newj =  Math.max(0, j - time[i] - 1);
           
            dp[i][j] = Math.min(cost[i] + dp[i+1][newj],dp[i+1][j]);
        }
       }

         return (int)dp[0][n];
    }

     long rec(int i,int n , int[] cost, int[] time,int wallsToCover, Long[][] dp){

        if(wallsToCover<=0){
            return 0;
        }
            if(i>=n){
                return Integer.MAX_VALUE;
            }

            if(dp[i][wallsToCover]!=null){
                return dp[i][wallsToCover];
            }

       long pick = cost[i] + rec(i+1,n,cost,time,wallsToCover-time[i]-1,dp);

       long notPick = rec(i+1,n,cost,time,wallsToCover,dp);

        return dp[i][wallsToCover] =Math.min(pick,notPick);

     }
}