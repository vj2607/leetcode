class Solution {
     static final int MOD = 1000000007;
    public int uniquePaths(int[][] grid) {
        if(grid[grid.length-1][grid[0].length-1]==1)
           return 0;

           int[][][] dp = new int[grid.length][grid[0].length][2];

           for(int[][] arr :dp){
                for(int[] arr1:arr)
                Arrays.fill(arr1,-1);
           }
          

        return rec(grid.length-1,grid[0].length-1,grid,0,dp);
    }
    int rec(int i , int j,int[][] grid,int parent,  int[][][] dp){
        
        if(i<0 ||j<0)
         return 0;

        if(i==0 && j==0)
         return 1;

         if(dp[i][j][parent]!=-1)
          return dp[i][j][parent];

       long ways=0;
       if(grid[i][j]==1){
        if(parent==0)
        ways+=rec(i,j-1,grid,1,dp);
         else
         ways+=rec(i-1,j,grid,0,dp);
       }
       else{
           ways+=rec(i-1,j,grid,0,dp);
           ways+=rec(i,j-1,grid,1,dp);
       }
        
        return dp[i][j][parent]= (int)ways%MOD;
    }
}