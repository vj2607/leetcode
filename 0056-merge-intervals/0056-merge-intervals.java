class Solution {
    public int[][] merge(int[][] intervals) {
       
       Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

       List<int[]> ans = new ArrayList<>();

       int[] curr = intervals[0];
        ans.add(curr);
       for(int[] arr : intervals){
        int  currEnd=curr[1];
        int  nextStart= arr[0];
        int  nextEnd=arr[1];
          if(currEnd>=nextStart){
            curr[1]=Math.max(currEnd,nextEnd);
          }
          else{
              curr=arr;
              ans.add(curr);  
          }
       }

     return   ans.toArray(new int[ans.size()][]);



     
    }
}