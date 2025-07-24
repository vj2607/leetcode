class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
       int n =text1.length();
       int m = text2.length();
       int[][] dp = new int[n+1][m+1];
       for(int[] arr:dp){
        Arrays.fill(arr,-1);
       }
       longest(n-1,text1,m-1,text2,dp);
       return dp[n-1][m-1];
    }
    int longest(int i,String str1,int j ,String str2,int[][] dp){

        if(i<0 || j<0)
          return 0;
        
        if(dp[i][j]!=-1)
         return dp[i][j];
        if(str1.charAt(i)==str2.charAt(j)){
              return dp[i][j]=1+longest(i-1,str1,j-1,str2,dp);
        }

        return dp[i][j]=Math.max(longest(i-1,str1,j,str2,dp),longest(i,str1,j-1,str2,dp));
    }
}