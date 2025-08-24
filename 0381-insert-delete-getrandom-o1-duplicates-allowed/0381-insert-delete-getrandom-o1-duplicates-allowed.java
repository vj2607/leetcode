class RandomizedCollection {

   HashMap<Integer,HashSet<Integer>> map ;
    List<Integer> list ;
    Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        random = new Random();
        list= new ArrayList<>();
    }
    
    public boolean insert(int val) {
       boolean notPresent = !map.containsKey(val);
       map.computeIfAbsent(val, v-> new HashSet<>()).add(list.size());
       list.add(val);
       return notPresent;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size()==0){  
         return false;
        }
         int  idxToRemove = map.get(val).iterator().next();
         map.get(val).remove(idxToRemove);
         
         int lastIdx = list.size()-1;
         int lastVal= list.get(lastIdx);
         if(idxToRemove !=lastIdx){
            list.set(idxToRemove,lastVal);
            map.get(lastVal).remove(lastIdx);
            map.get(lastVal).add(idxToRemove);

         }

          list.remove(lastIdx);
          if (map.get(val).isEmpty()) {
            map.remove(val);
        }



        return true;
    }

    
    
    public int getRandom() {
       return list.get(random.nextInt(list.size()));
    }
}
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */