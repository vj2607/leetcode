class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max= getMax(piles);

        int low =1,high=max;

        while(low<=high){
            int mid=(low+high)/2;
            if(calculateHours(piles,mid)<=h)
                   high=mid-1;
            else
            low=mid+1;
        }

      return  low;
       
    }

    int calculateHours(int[] piles,int h){
        int total=0;
        for(int i=0;i<piles.length;i++){
            total+=Math.ceil((double)piles[i]/(double)h);
        }
        return total;
    }

    int getMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
             if(piles[i]>max)
              max=piles[i];
        }

        return max;
    }
}