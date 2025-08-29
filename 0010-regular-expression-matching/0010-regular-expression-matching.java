class Solution {
    public boolean isMatch(String s, String p) {
        
        return rec(0,0,s,p);
    }

    boolean rec(int i , int j , String s , String p){

       if(j==p.length())
        return i==s.length();

    
    boolean isFirstMatch =( i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));

    if( j+1<p.length() && p.charAt(j+1)=='*'){
      return  rec(i,j+2,s,p) ||
        (isFirstMatch && rec(i+1,j,s,p));
    }

    else{
        return isFirstMatch && rec(i+1,j+1,s,p);
    }
} 
}