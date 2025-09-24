class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();

        rec(0,0,n,new StringBuilder(),ans);
        return ans;
    }

    void rec(int open,int closed,int n , StringBuilder sb,List<String> list){
        if(sb.length()==2*n){
            list.add(sb.toString());
            return;
        }
        if(open<n){
            rec(open+1,closed,n,sb.append('('),list);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closed<open){
            rec(open,closed+1,n,sb.append(')'),list);
             sb.deleteCharAt(sb.length()-1);
        }
    }
     
}