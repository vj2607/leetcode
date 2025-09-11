class Solution {
    public String largestOddNumber(String num) {
        
        int j = num.length()-1,i=0;

        while(j>=0){
            int digit = num.charAt(j)-'0';
            if(digit%2!=0){
                return num.substring(i,j+1);
            }
            else{
                j--;
            }
        }
        return "";
    }
}