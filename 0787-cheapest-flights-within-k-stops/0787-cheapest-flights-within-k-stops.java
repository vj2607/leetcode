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
            Pair p = new Pair(flights[i][1],flights[i][2]);
            adj.get(flights[i][0]).add(p);
         }

         Queue<int[]> pq = new LinkedList<>();
         int[] price = new int[n];
         Arrays.fill(price,(int)1e9);
         price[src]=0;
         pq.add(new int[]{0,0,src});

         while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int stop = arr[1], cost = arr[0],node=arr[2];
             
          
            
          if(stop<=k){
            for(Pair pair :adj.get(node)){      
                if(price[pair.node]>cost+pair.price)    {
                    price[pair.node]=cost+pair.price;
         pq.add(new int[]{cost+pair.price,stop+1,pair.node});
                  
            }
          }
         
          }
         
    }
    return price[dst]==(int)1e9?-1:price[dst];
    }
}
