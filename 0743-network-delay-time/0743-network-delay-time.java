class Solution {
    class Pair{
        int node;
        int time;
        Pair(int n , int t){
            this.node=n;
            this.time=t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
         
         Queue<Pair> q = new LinkedList<>();
         q.add(new Pair(k,0));

         int dist[]= new int[n+1];

         Arrays.fill(dist,(int)1e9);
         dist[k]=0;

         while(!q.isEmpty()){
            Pair p = q.poll();
            int time=p.time;
            int node = p.node;

            for(Pair pair: adj.get(node)){
                int adjNode=pair.node;
                int newtime=pair.time;
                if(dist[adjNode]>newtime+time){
                    dist[adjNode] = newtime+time;
                    q.add(new Pair(adjNode,dist[adjNode]));
                }
            }
         }
         int max=0;
         for(int i=1;i<n+1;i++){
             if(dist[i]==1e9)
               return -1;
               max=Math.max(max,dist[i]);
         }

         return max;
    }
}