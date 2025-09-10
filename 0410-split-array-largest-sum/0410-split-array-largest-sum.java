class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
       
        int max =0,sum=0;
        for(int i=0;i<n;i++){
            if(max<nums[i])
              max=nums[i];

            sum+=nums[i];
        }
        int low=max,high=sum;

        while(low<=high){
            int mid= (low+high)/2;

            if(isPossible(mid,nums,k))
             high=mid-1;
               

            else
           low=mid+1;
        }

        return low;
       
    }

    public boolean isPossible(int maxsum,int[] nums,int k){
        int count=0,sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=maxsum){
                sum+=nums[i];
            }
            else{
                count++;
                sum=nums[i];
            }
        }
        count++;

        return count<=k;
    }
}