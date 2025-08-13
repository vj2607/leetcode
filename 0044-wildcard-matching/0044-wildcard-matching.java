class Solution {
    public boolean isMatch(String s, String p) {
      int[][] dp = new int[s.length()+1][p.length()+1];
      
      return rec(s.length(),p.length(),s,p,dp);
    }

    boolean rec(int i ,int j,String s , String p ,int[][] dp ){

        if(i==0 && j==0){
            return true; 
        }
        if(i==0){
            for(int k=j-1;k>=0;k--){
                if(p.charAt(k)!='*')
                 return false;
            }
            return true;
        }
        if(j==0)
        return false;

        if(dp[i][j]!=0)
         return dp[i][j]==1?true:false;

        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
            boolean res =  rec(i-1,j-1,s,p,dp);
            dp[i][j]= res==true?1:-1;
          return res;
        }
     
        if(p.charAt(j-1)=='*'){
            boolean res= rec(i,j-1,s,p,dp) || rec(i-1,j,s,p,dp);
              dp[i][j]= res==true?1:-1;
          return res;
        }

        dp[i][j]=-1;
        return false;

    }
}