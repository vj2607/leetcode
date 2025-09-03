class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n =piles.length;
        int largest=piles[0];
       for(int i=0;i<n;i++){
        if(piles[i]>largest)
            largest=piles[i];
       }

       int low=1;
       int high=largest;
        
       while(low<=high){
         int mid=(low+high)/2;
          if(calculateTime(piles,mid)<=h){
             high=mid-1;
          }
          else
          low=mid+1;
       }
    return low;

    }

    int calculateTime(int[] nums, int k){
        int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=Math.ceil((double)nums[i]/(double)k);
            }

            return sum;
           
    }
}