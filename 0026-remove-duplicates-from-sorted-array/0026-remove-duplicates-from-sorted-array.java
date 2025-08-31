class Solution {
    public int removeDuplicates(int[] arr) {
        int count=0,prev=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=prev){
                prev=arr[i];
                int temp=arr[count];
                arr[count]=arr[i];
                arr[i]=temp;
                count++;
            }
        }

        return count;
    }

}