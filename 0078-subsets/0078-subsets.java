class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
      
        List<List<Integer>> ans = new ArrayList<>();

          rec(0,n,ans, new ArrayList<>(),nums);
          return ans;

    }
    void rec(int i,int n,List<List<Integer>> ans,List<Integer> list,int[] nums){

        if(i==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        rec(i+1,n,ans,list,nums);

        list.remove(list.size()-1);
        rec(i+1,n,ans,list,nums);
    }
}