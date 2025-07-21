class Solution {
  class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
        
    }
}   
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0)
          return -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.first+b.second)-(a.first+a.second));
        int[][] dis = new int[n][n];
        for(int i =0;i<n;i++){
             for(int j =0;j<n;j++)
               dis[i][j]=Integer.MAX_VALUE;
        }
        dis[0][0]=1;
        pq.add(new Pair(0,0));

        while(pq.isEmpty()==false){
            Pair p = pq.poll();
           int r= p.first;
           int c= p.second;

           for(int drow=-1;drow<=1;drow++){
              for(int dcol=-1;dcol<=1;dcol++){
                int nrow = r+drow;
                int ncol=c+dcol;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && dis[nrow][ncol]>dis[r][c]+1){
                    dis[nrow][ncol]=dis[r][c]+1;
                    pq.add(new Pair(nrow,ncol));
                }
              }
           }
        }
        return dis[n-1][n-1]==Integer.MAX_VALUE?-1:dis[n-1][n-1];

    }
}