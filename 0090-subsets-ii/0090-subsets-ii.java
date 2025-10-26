class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
         List<List<Integer>> ansList = new ArrayList<>();
         List<Integer> list = new ArrayList<>();
         int n = nums.length;
         subsetsWithoutDuplicate(nums,ansList,list,n,0);
         return ansList;
    }

    void subsetsWithoutDuplicate(int[] nums,List<List<Integer>> ansList
    , List<Integer> list,int n,int i ){
        
        ansList.add(new ArrayList<>(list));

        for(int indx=i;indx<n;indx++){
            if(indx>i && nums[indx]==nums[indx-1])
            continue;
            list.add(nums[indx]);
            subsetsWithoutDuplicate(nums,ansList,list,n,indx+1);
            list.remove(list.size()-1);
         }

    }
}