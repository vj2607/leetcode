class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
        return Integer.MAX_VALUE;
    }
          boolean sign=true;
          if(dividend>=0 && divisor<0) sign=false;
          if(dividend<0 && divisor>=0) sign =false;
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor); 
        long ans =0;
        while(n>=d){
            int count=0;

            while(n>= (d<<(count+1))){
                count++;
                }
             ans+=(1<<count);
             n -= (d<<count);

        }

        if (ans >Integer.MAX_VALUE)
            return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
        
      

          return sign?(int)ans:(int)-ans;
      
    }
}