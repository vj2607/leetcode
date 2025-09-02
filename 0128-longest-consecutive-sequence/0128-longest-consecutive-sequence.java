class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();

        
          
        for(int i=0;i<nums.length;i++)
          set.add(nums[i]);
         
        int longest=0;
        for(int number :set){
           
            if(!(set.contains(number-1))){
        
            int count=1; 
            int end =number+1;
            while(set.contains(end)){
                    count++;
                    end=end+1;
            }

             longest=Math.max(longest,count);  
            }
        }

        return longest;
    }
}