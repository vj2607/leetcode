class Solution {
    public int trap(int[] height) {
        int n = height.length;
      //  int lMax[] = new int[n];
        int rMax[] = new int[n];

        // lMax[0]=height[0];
        // for(int i=1;i<n;i++){
        //     lMax[i]= Math.max(lMax[i-1],height[i]);
        // }
        rMax[n-1] = height[n-1];
         for(int i=n-2;i>=0;i--)
        rMax[i]=Math.max(rMax[i+1],height[i]);
        
        int res=0;
        int lMax=height[0];

         for(int i=1;i<n-1;i++){
        lMax= Math.max(lMax,height[i]);
         res = res+(Math.min(lMax,rMax[i]) -height[i]);
         }
         return res;

    }
}