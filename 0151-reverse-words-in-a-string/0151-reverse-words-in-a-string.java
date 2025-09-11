class Solution {
    public String reverseWords(String s) {
        
      
        StringBuilder sb = new StringBuilder();
        int j =s.length(),i=s.length()-1, k=0;
       while(i>=0){
             if(i>=0 && s.charAt(i)!=' '){
               k=i;
               while(k>=0 && s.charAt(k)!=' ')
                 k--;
                sb.append(s.substring(k+1,i+1));
                if(i>=0 && k>=0)
                sb.append(" ");
                i=k;


             }
             else{
              
                i--;
                
             }
        }
        
        
        return sb.toString().trim();

    }
}