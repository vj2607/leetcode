class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
      
       int curr1=0,curr2=0, down=0,diag=0;
       for(int i=n-1;i>=0;i--){
        for(int j=0;j<2;j++){
            int profit=0;
            if(j==1){
  profit = Math.max(-prices[i]+down,diag);
             curr2=profit; 
            }
            else{
        profit = Math.max(prices[i]+diag,down);     
        curr1=profit;   
            }
           
        }
          down=curr1;
          diag=curr2;
       }
      return diag;
    }

   
}