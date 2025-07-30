class Solution {
    public boolean isMatch(String s, String p) {
      int n = s.length() , m =p.length();
       int[][] dp = new int[n+1][m+1];
       return rec(0,0,n,m,s,p,dp);
    }

    boolean rec(int i , int j, int n , int m , String s , String p,int[][] dp){
         if(j>m-1 && i<n){
            return false;
         }
         if(i>n-1 && j>m-1)
          return true;

        if(i>n-1 && j<m){
            for(int k=j;k<m;k++)
             if(p.charAt(k)!='*')
               return false;

               return true;
        }
        if(dp[i][j]!=0)
         return dp[i][j]==1?true:false;

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            boolean ans =rec(i+1,j+1,n,m,s,p,dp);
            dp[i][j] = ans==true?1:-1;
            return ans;

        }
        if(p.charAt(j)=='*'){
            boolean ans = rec(i+1,j,n,m,s,p,dp) || rec(i,j+1,n,m,s,p,dp);
              dp[i][j] = ans==true?1:-1;
            return ans;
        }

        dp[i][j]=-1;
        return false;
    }
}