class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subset=1<<n;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0;i<subset;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i &(1<<j)) !=0 )
                temp.add(nums[j]);
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }
}