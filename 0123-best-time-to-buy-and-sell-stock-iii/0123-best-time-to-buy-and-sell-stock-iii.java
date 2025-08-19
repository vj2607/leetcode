class Solution {
    public int maxProfit(int[] prices) {
      Integer map[][][] = new Integer[prices.length][2][3];

        return rec(0,1,prices,0,map);
    }

    int rec(int i,int buy,int[] nums,int trans,Integer map[][][]  ){
            if(i==nums.length || trans==2){
                return 0;
            }
        

        if(map[i][buy][trans]!=null)
            return map[i][buy][trans];
        int profit=0;
       
        if(buy==1){
            profit=Math.max(-nums[i]+rec(i+1,0,nums,trans,map),rec(i+1,1,nums,trans,map));
        }
        else{
          profit=Math.max(nums[i]+rec(i+1,1,nums,trans+1,map),rec(i+1,0,nums,trans,map));  
        }
     
      
        return map[i][buy][trans]= profit;
    }
}