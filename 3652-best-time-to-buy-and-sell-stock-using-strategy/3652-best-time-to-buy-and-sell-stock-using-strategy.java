class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        HashMap<Integer,Long> map = new HashMap<>();
        int n = prices.length;
        long max = Long.MIN_VALUE;;
        long profit=0;
        for(int i=0;i<n;i++){
             profit+=prices[i]*strategy[i];
             map.put(i,profit);
        }
        max= Math.max(profit,max);


        for(int i=0;i<=n-k;i++){
          long  modProfit=0;
            for(int j=(i+(k/2));j<i+k;j++){
                modProfit+=prices[j];
            }
            long toRemove=0;
            if(i==0)
            toRemove=map.get(i+k-1);
            else
            toRemove = map.get(i+k-1)- map.get(i-1);
           long newProfit= (profit-toRemove)+modProfit;
           max= Math.max(max,newProfit);
        }
         

          return max;
    }
}