class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
   
       for(String str: strs){
        String sorted = sortedWord(str);
        if(map.containsKey(sorted)){
            map.get(sorted).add(str);
        }
        else{
            map.put(sorted,new ArrayList<>(List.of(str)));
        }
       }
       List<List<String>> ans = new ArrayList<>();
       for(Map.Entry<String,List<String>> e : map.entrySet()){
                ans.add(new ArrayList<>(e.getValue()));
       }
       return ans;
    }

    String sortedWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}