class Solution {
    public int countSubstrings(String s) {
        int n =s.length();
        int cnt=0;
        int[][] dp = new int[n][n];
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
          boolean isPalindrome=recur(i,j,s,dp);
            if(isPalindrome)
              cnt++;
        }
       }

       return cnt;
    }

    boolean recur(int i,int j,String s,int[][] dp){
        if(i==j)
         return true;
        if(i>j) return true;
        if(dp[i][j]!=0)
         return dp[i][j]==1;
        if(s.charAt(i)!=s.charAt(j)){
            dp[i][j]=-1;
           return false;
        }
      dp[i][j]=  recur(i+1,j-1,s,dp)?1:-1;
        return dp[i][j]==1;
    }
}