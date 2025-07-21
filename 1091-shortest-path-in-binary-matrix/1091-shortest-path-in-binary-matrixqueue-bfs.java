class Solution {
    class Pair{
        int row;
        int col;
       
        Pair(int r,int c){
          row=r;
          col=c;
         
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dist= new int[n][n];
        for(int[] arr :dist)
        Arrays.fill(arr,(int)1e9);
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
           return -1;
        Queue<Pair> pq = new LinkedList<>();
        dist[0][0]=1;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int r = p.row;
            int c=p.col;
           

            for(int i=-1;i<=1;i++){

                for(int j=-1;j<=1;j++){
                    int nrow= r+i,ncol=c+j;

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && dist[nrow][ncol]>1+dist[r][c] ){
                        
                            dist[nrow][ncol] =1+dist[r][c];
                            pq.add( new Pair(nrow,ncol));
                        
                    }
                }
            }
        }

        return dist[n-1][n-1]==(int)1e9?-1:dist[n-1][n-1];
    }
}