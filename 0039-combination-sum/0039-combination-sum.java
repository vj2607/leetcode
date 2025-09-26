class Solution {

    public void combinationSumRecursive(int i ,int[] candidates, int target,int n ,List<List<Integer>> ans , List<Integer> ds){

        if(i==n){
            if(target==0)
            ans.add(new ArrayList<>(ds));

            return;
        }

        if(target>=candidates[i]){
            ds.add(candidates[i]);
           combinationSumRecursive(i,candidates,target-candidates[i],n,ans ,ds ) ;
           ds.remove(ds.size()-1);
        }
        combinationSumRecursive(i+1,candidates,target,n,ans ,ds ) ;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;

        combinationSumRecursive(0,candidates,target,n,ans ,new ArrayList<>() );

        return ans;


    }
}