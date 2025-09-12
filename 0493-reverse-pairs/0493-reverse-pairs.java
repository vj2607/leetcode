class Solution {
    public int reversePairs(int[] nums) {
      int[] count = new int[1];
      mergeSort(nums,0,nums.length-1,count);
      return  count[0];
    }
    void mergeSort(int[] nums, int low , int high, int[] count){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSort(nums,low,mid,count);
        mergeSort(nums,mid+1,high,count);
        merge(nums,low,mid,high,count);
    }
    void merge(int[] nums, int low , int mid,int high, int[] count){
        int i =low;
        int j =mid+1;
        int[] temp = new int[high-low+1];
        int idx=0;
        int ed =mid+1;
        for(int st=low;st<=mid;st++){
           while(ed<=high && (long)nums[st]>2L*nums[ed])
             ed++;

             count[0]+=ed-(mid+1);
        }
        while(i<=mid && j<=high){
            if(nums[i]>nums[j]){
             
                temp[idx++]=nums[j++];        
            }
            else{
                temp[idx++]=nums[i++];
            }
        }
        while(i<=mid){
            temp[idx++]=nums[i++];
        }
         while(j<=high){
            temp[idx++]=nums[j++];
        }

        for(int k=low;k<=high;k++){
            nums[k]=temp[k-low];
        }
    }
}