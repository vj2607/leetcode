class Solution {
    public int longestPalindromeSubseq(String s) {
        int n =s.length();
      int[][] dp = new int[n][n];
     for(int[] arr:dp){
        Arrays.fill(arr,-1);
     }
      if(s.length()==1)
          return 1;
         rec(0,n-1,s,dp);
           return dp[0][n-1];
    }

    int rec(int i,int j,String s, int[][] dp){
        
       if(i>j){
        return 0;
       }
       if(i==j) return 1;

       if(dp[i][j]!=-1)
         return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=2+ rec(i+1,j-1,s,dp);
        }
        else{
            return dp[i][j]=Math.max(rec(i,j-1,s,dp),rec(i+1,j,s,dp));
        }
    }

   
}