class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge= new int[nums.length];
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        
        for(int i=2*nums.length-1;i>=0;i--){

            while(st.isEmpty()==false && st.peek()<=nums[i%n])
              st.pop();

        if(i<n){
            if(st.isEmpty())
            nge[i] = -1;

            else
            nge[i]=st.peek();
        }
        st.push(nums[i%n]);

        }

        return nge;
    }
}