class Solution {
    public int myAtoi(String s) {
        
        
        int sign=1,i=0,n=s.length();
        while(i<n &&s.charAt(i)==' ')
        i++;

        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if (s.charAt(i) == '-') sign = -1;
             i++;
        }
      long ans =0;
      while(i<n && Character.isDigit(s.charAt(i))){
           int digit = s.charAt(i) - '0';
            ans = ans * 10 + digit;
         if(ans*sign<Integer.MIN_VALUE) return Integer.MIN_VALUE;
       
         if (ans*sign>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            
             i++;
      }
      return (int)( ans*sign);
    }
}