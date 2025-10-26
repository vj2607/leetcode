class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(1,k,n,ans,new ArrayList<>());
        return ans;
    }

    void rec(int idx,int k , int target,List<List<Integer>> ans , List<Integer> list ){

        if(list.size()==k){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=idx;i<=9;i++){
            if(target<i)
              break;
            
            list.add(i);
            rec(i+1,k,target-i,ans,list);
            list.remove(list.size()-1);
        }
    }

}