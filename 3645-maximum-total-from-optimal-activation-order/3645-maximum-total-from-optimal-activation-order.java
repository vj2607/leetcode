class Solution {
    public long maxTotal(int[] value, int[] limit) {
        
         HashMap<Integer,List<Integer>> map = new HashMap<>();

         for(int i=0;i<limit.length;i++){
            map.computeIfAbsent(limit[i],k -> new ArrayList<>()).add(value[i]);
         }
         long ans =0;
         for(Map.Entry<Integer,List<Integer>> e :map.entrySet()){
              int key = e.getKey();
              List<Integer> list = e.getValue();
              Collections.sort(list,Collections.reverseOrder());
              int min = Math.min(key,list.size());
              for(int i=0;i<min;i++)
               ans+=list.get(i);
         }

         return ans;
    }
}