class Solution {
    class Pair{
        int node ;
        int price;
        Pair(int p,int q){
            this.node=p;
            this.price=q;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

       for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
       }
       for(int i=0;i<flights.length;i++){
          adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
       }

       Queue<int[]> q = new LinkedList<>();
       q.add(new int[]{src,0,0});
       int[] vis = new int[n];
       Arrays.fill(vis,(int)1e9);
       vis[src]=0;
       while(!q.isEmpty()){
        int[] arr  = q.poll();
        int node = arr[0] ,stops = arr[2],cost=arr[1];
         if(stops>k)
          continue;

          for(Pair p: adj.get(node)){
            int adjNode = p.node;
            int price =p.price;
            if(vis[adjNode]>price+cost){
                vis[adjNode]=price+cost;
                q.add(new int[]{adjNode,price+cost,stops+1});
            }
          }
       }

       return vis[dst]==(int)1e9?-1:vis[dst];

}
}
