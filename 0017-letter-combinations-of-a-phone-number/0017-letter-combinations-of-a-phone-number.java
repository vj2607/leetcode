class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        rec(0,map,digits,ans,new StringBuilder());
        return ans;   
    }

    void rec(int idx, HashMap<Character,String> map,String digits,List<String> ans,StringBuilder sb){
         if(idx==digits.length()){
            ans.add(sb.toString());
            return;
         }

         String letter = map.get(digits.charAt(idx));
         for(int i=0;i<letter.length();i++){
            sb.append(letter.charAt(i));
            rec(idx+1,map,digits,ans,sb);
            sb.deleteCharAt(sb.length()-1);
         }

    }
}