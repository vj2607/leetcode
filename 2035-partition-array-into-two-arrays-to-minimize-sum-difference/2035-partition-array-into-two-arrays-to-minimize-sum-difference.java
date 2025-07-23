class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int i =0;i<n;i++)
         sum+=nums[i];

    //meet in the middle algo

        Map<Integer,List<Integer>> leftMap = new HashMap<>();
        Map<Integer,List<Integer>> rightMap = new HashMap<>();
  
       subsetSum(nums,0,n/2-1,leftMap,0,0);
       subsetSum(nums,n/2,n-1,rightMap,0,0);

         int min = Integer.MAX_VALUE;
       for(Map.Entry<Integer,List<Integer>> e :leftMap.entrySet()){
               int k = e.getKey(); 
               List<Integer> left = e.getValue();
               int requiredRight = n/2-k;
               if(!rightMap.containsKey(requiredRight)){
                continue;
               }
               List<Integer> right = rightMap.get(requiredRight);
               Collections.sort(right);

            for(int i:left){
            int target = sum/2-i;
            int idx = lowerBound(right,target);
            if(idx!=-1){
                min=Math.min(min, Math.abs(sum/2-(i+right.get(idx))));
            }
            if (idx + 1 < right.size()) {
               min = Math.min(min, Math.abs(sum/2 - (i + right.get(idx + 1))));
                 }
         }

       
       }
           return 2*min;
    }

  

    void subsetSum(int[] nums, int start, int end,   Map<Integer,List<Integer>> map,int sum,int count){

        if(start>end){
          if(map.containsKey(count)){
            map.get(count).add(sum);
          }
          else{
            map.put(count,new ArrayList<>(List.of(sum)));
          }
            return;
        }
       subsetSum(nums,start+1,end,map,sum+nums[start],count+1);
       subsetSum(nums,start+1,end,map,sum,count);

    }

    int lowerBound(List<Integer> arr, int target){
         int l=0;
        int r= arr.size()-1;
        int ans =-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr.get(mid)<=target){
                l=mid+1;
                ans=mid;
            }
            else
            r=mid-1;
        }
        return ans;
    }
}