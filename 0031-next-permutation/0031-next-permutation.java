class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
            idx=i;
            break;
        }
        }
        if(idx==-1){
        reverse(nums,0,nums.length-1);
          return;
        }
        for(int i=nums.length-1;i>=idx;i--){
            if(nums[i]>nums[idx]){
            swap(nums,i,idx);
            break;
        }
        }

        reverse(nums,idx+1,nums.length-1);
    }
    void swap(int[] nums,int a , int b ){
        int c =nums[a];
       nums[a]=nums[b];
       nums[b]=c;
    }

    void reverse(int[] nums,int l ,int r){
        while(l<r){
             
             swap(nums,l,r);
             l++;
             r--;
        }
    }
}