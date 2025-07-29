class Solution {
    public int numDistinct(String s, String t) {
        int n =s.length();
        
        Map<String,Integer> map = new HashMap<>();
        return rec(0,0,s,t,map);
    }
    int rec(int i , int j , String s ,String t,Map<String,Integer> map){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        
   String key =i+"#"+j;
   if(map.containsKey(key))
      return map.get(key);
        int count=0;
        if(s.charAt(i)==t.charAt(j)){
            count+=rec(i+1,j+1,s,t,map);
        }
        count+=rec(i+1,j,s,t,map);
     map.put(key,count);
        return count;
    }
}