class RandomizedCollection {

   HashMap<Integer,List<Integer>> map ;
    List<Integer> list ;
    Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        random = new Random();
        list= new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
         map.get(val).add(list.size());
         list.add(val);
         return false;
        }
        map.put(val, new ArrayList<>());
        map.get(val).add(list.size());   // add the current index
         list.add(val);
         return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){  
         return false;
        }
        List<Integer> idxList =   map.get(val);
        
        int idxToRemove = idxList.get(idxList.size()-1);
        int last = list.get(list.size()-1);
        if(list.get(idxToRemove)!=last){
       List<Integer> lastIdxList = map.get(last);
       lastIdxList.remove(lastIdxList.size()-1);
       lastIdxList.add(idxToRemove);
        list.set(idxToRemove,last);
        list.remove(list.size()-1);
         idxList.remove(idxList.size()-1);
        }
       else{
          idxList.remove(idxList.size()-1);
           list.remove(list.size()-1);
           if(idxList.size()==0)
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