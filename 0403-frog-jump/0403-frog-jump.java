class Solution {
    public boolean canCross(int[] stones) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:stones)
          set.add(num);

         HashMap<String,Boolean> map = new HashMap<>();

        return rec(0,0,stones[stones.length-1],set,map);
    }

    boolean rec(int pos , int jump,int target,HashSet<Integer> set, HashMap<String,Boolean> map){

        if(pos==target){
            return true;   
        }
        String key = pos+"."+jump;
        if(map.containsKey(key))
           return map.get(key);

        for(int i=jump-1;i<=jump+1;i++){
            if(i>0 && set.contains(pos+i)){
                if(rec(pos+i,i,target,set,map)){
                  map.put(key,true);
                  return true;
                }
                
            }
        }

        map.put(key,false);
        return false;

    }
  
}