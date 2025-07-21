class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m =heights[0].length;
        int[][] efforts = new int[n][m];
        for(int[] arr:efforts){
            Arrays.fill(arr,(int)1e9);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
         efforts[0][0]=0;
           int[] drow ={-1,1,0,0};
            int[] dcol={0,0,1,-1};
         while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int diff=arr[0], r= arr[1],c=arr[2];

            if(r==n-1 && c==m-1)
            return diff;
          
            for(int i=0;i<4;i++){
                int nrow=drow[i]+r , ncol=dcol[i]+c;
               
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m ){
                     int newdiff =Math.max( Math.abs(heights[nrow][ncol]-heights[r][c]),diff);
                   if(newdiff<efforts[nrow][ncol]){
                    efforts[nrow][ncol]=newdiff;
                    pq.add(new int[]{newdiff,nrow,ncol});
                   }
                }
            }
         }

         return 0;

    }
}