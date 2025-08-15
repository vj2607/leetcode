class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        if(((long)n & (long)n-1)==0)
         return true ;

       return false;

    }
}