class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n=nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        subsetSum(nums,0,n/2,arr1,0);
        subsetSum(nums,(n/2)+1,n-1,arr2,0);
        Collections.sort(arr2);
        int min = Integer.MAX_VALUE;
          for (int i : arr1) {
              int target = goal - i;
              int idx = lowerBound(arr2, target); 

               if (idx != -1) {
              min = Math.min(min, Math.abs(goal - (i + arr2.get(idx))));
             }

                 if (idx + 1 < arr2.size()) {
               min = Math.min(min, Math.abs(goal - (i + arr2.get(idx + 1))));
                 }
               }   

        return min;

    }

    void subsetSum(int[] nums,int start,int end,List<Integer> arr,int sum){
             if(start>end){
                arr.add(sum);
                return;
             }
             subsetSum(nums,start+1,end,arr,sum+nums[start]);
             subsetSum(nums,start+1,end,arr,sum);
    }

    int lowerBound(List<Integer> arr,int goal){
        int l=0,r=arr.size()-1;
        int ans =-1;
        while(l<=r){
            int mid = (l+r)/2;

            if(arr.get(mid)<=goal){
                l=mid+1;
                ans=mid;

            }
            else
              r=mid-1;
        }

        return ans;
    }

     
}
