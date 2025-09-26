class Solution {
    public int paintWalls(int[] cost, int[] time) {
       int n = time.length;
       Long[][] dp = new Long[n][n+1];

         return (int)rec(0,n,cost,time,n,dp);
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