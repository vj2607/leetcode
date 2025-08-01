class Solution {
    public int coinChange(int[] coins, int amount) {
        
        Arrays.sort(coins);
        int i=coins.length-1;
        int ans =0;
        while(i>=0){
          int amt= amount/coins[i];
          if(amt!=0){
          ans+=amt;
          amount= amount%coins[i];
          i--;
         
          }
          else{
              if(amount==0)
                 break;

             i--;
          }
        }
          return amount==0?ans:-1;
         
        }
    
}