class Solution {
    public int removeDuplicates(int[] arr) {
        int count=1,prev=arr[0];
        for(int i=1;i<arr.length;i++){
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