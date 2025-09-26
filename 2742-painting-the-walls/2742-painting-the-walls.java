class Solution {
    public int paintWalls(int[] cost, int[] time) {
       int n = time.length;
       long[] dp = new long[n+1];

     
       for(int i=1;i<=n;i++){
          dp[i]=(long)Integer.MAX_VALUE;
       }
       dp[0]=0;

       for(int i=n-1;i>=0;i--){
        long temp[] = new long[n+1];
        for(int j=1;j<=n;j++){

            int newj =  Math.max(0, j - time[i] - 1);
           
            temp[j] = Math.min(cost[i] + dp[newj],dp[j]);
        }
        dp=temp;
       }

         return (int)dp[n];
    }

    
}