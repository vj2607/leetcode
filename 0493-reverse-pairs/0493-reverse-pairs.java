class Solution {
    public int reversePairs(int[] nums) {
        
        return mergeSort(nums,0,nums.length-1);
    }

    int mergeSort(int[] arr,int l , int r){
       
        if(l>=r)
          return 0;
           int count =0;
          int mid = (l+r)/2;
         count+= mergeSort(arr,l,mid);
         count+=  mergeSort(arr,mid+1,r);
         count+= merge(arr,l,r,mid);

         return count;
    }

    int merge(int[] arr, int l , int r, int mid){
        ArrayList<Integer> temp = new ArrayList<>();
        int left=l;
        int right=mid+1;
        int count=0;
        int ed= mid+1;
        for(int st=left;st<=mid;st++){
            while(ed<=r && (long)arr[st] > 2L*arr[ed])
              ed++;

              count+=ed-(mid+1);
        }
        while(left<=mid && right<=r){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
             
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=r){
            temp.add(arr[right]);
            right++;
        }

        for(int i=l;i<=r;i++){
          
           arr[i]= temp.get(i-l);
        }
        return count;
    }

}