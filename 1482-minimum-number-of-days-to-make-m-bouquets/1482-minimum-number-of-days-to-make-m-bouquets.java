class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>(long)bloomDay.length)
          return -1;

    int low =findMin(bloomDay), high = findMax(bloomDay);
            while(low<=high){
                int mid=(low+high)/2;
                
                if(possible(bloomDay,mid,m,k))
                     high=mid-1;
                else
                  low=mid+1;
            }
            return low;
    }

    int findMin(int arr[]){
        int min = Integer.MAX_VALUE;
         for(int i=0;i<arr.length;i++){
            if(arr[i]<min)
              min =arr[i];
         }

         return min;
    
    }

    int findMax(int arr[]){
        int max = Integer.MIN_VALUE;
         for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
              max =arr[i];
         }

         return max;
    
    }

    boolean possible(int[] arr , int day,int m ,int k){
         int count=0,noOfBouquet=0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }
            else{
                noOfBouquet+=(count/k);
                count=0;
            }

        }
         noOfBouquet+=(count/k);

         return noOfBouquet>=m;
    }
}