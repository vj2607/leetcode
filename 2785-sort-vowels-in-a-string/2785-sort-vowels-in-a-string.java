class Solution {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet<>(
    Arrays.asList('a','e','i','o','u','A','E','I','O','U')
);

ArrayList<Character> st = new ArrayList<>();
ArrayList<Integer> idx = new ArrayList<>();

       for(int i=0;i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                st.add(s.charAt(i));
             
                idx.add(i);
            }
           
            sb.append(s.charAt(i));
        }

        Collections.sort(st);
      
      for(int i=0;i<st.size();i++){
        int index = idx.get(i);
        sb.setCharAt(index,st.get(i));
        
      }


       return sb.toString();
    
    }
}