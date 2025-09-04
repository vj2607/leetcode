class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low = 1,high = findMax(nums);

        while(low<=high){
            int mid=(low+high)/2;
            if(getDivisorSum(nums,mid)<=threshold)
                high=mid-1;
            else
            low=mid+1;
        }

        return low;
    }

    int getDivisorSum(int[] nums,int mid){
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/(double)mid);
        }

        return sum;
    }

    int findMax(int arr[]){
        int max = Integer.MIN_VALUE;
         for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
              max =arr[i];
         }

         return max;
    
    }
}