class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }
        int longest=0;
        for(int it:set){
           
            if(!set.contains(it-1)){
               int count=1;
               int x=it;
               while(set.contains(x+1)){
                  x=x+1;
                 count++;
               }
              longest= Math.max(longest,count);
            }

        }
        return longest;
    }
}