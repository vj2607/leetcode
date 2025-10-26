class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        rec(0,s,ans,new ArrayList<>());
        return ans;
    }

    void rec(int idx, String s, List<List<String>> ans , List<String> list){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s.substring(idx,i+1))){
                list.add(s.substring(idx,i+1));
                rec(i+1,s,ans,list);
                list.remove(list.size()-1);

            }
        }
    }

    boolean isPalindrome(String s){
        int l=0,r=s.length()-1;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}