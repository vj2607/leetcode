class Solution {
    public String longestPalindrome(String s) {
    int n =s.length();
        int cnt=0;
        boolean[][] dp = new boolean[n][n];
        int len=0,start=-1,end=-1;
        
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                if(i==j) dp[i][j]=true;

                else if(i+1==j){
                    dp[i][j]= (s.charAt(i)==s.charAt(j));
                }
                else{
                    if(s.charAt(i)==s.charAt(j))
                     dp[i][j]=dp[i+1][j-1];
                }
                   if(dp[i][j]==true){
                      len=j-1+1;
                      start=i;
                      end=j;
                   }
                }
            }
        

      

       return s.substring(start,end+1);
    }
}