class Solution {
    public String removeOuterParentheses(String s) {
        int i=0,j=0,count1=0,count2=0;
        StringBuilder sb = new StringBuilder();

        while(j<s.length()){

             if(s.charAt(j)=='(')
               count1++;
            else
             count2++;

             if(count1==count2){
                sb.append(s.substring(i+1,j));
                count1=0;
                count2=0;
                j++;
                i=j;
             }
             else{
                j++;
             }
        }

        return sb.toString();
    }
}