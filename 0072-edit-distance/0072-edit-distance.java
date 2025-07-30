class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return rec(0,0,word1,word2,dp);
    }

    int rec(int i ,int j,String s1,String s2,int[][] dp){
        if(i>s1.length()-1)
           return s2.length()-j;

        if(j>s2.length()-1)
           return s1.length()-i;

           if(dp[i][j]!=-1)
            return dp[i][j];

           if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=rec(i+1,j+1,s1,s2,dp);
           }
           else{
            int insert = 1+rec(i,j+1,s1,s2,dp);

            int delete = 1+rec(i+1,j,s1,s2,dp);
            int replace = 1+rec(i+1,j+1,s1,s2,dp);
             return dp[i][j]= Math.min(Math.min(insert,delete),replace);
           }

    }
}