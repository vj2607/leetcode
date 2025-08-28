class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;

        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.push(i);
            }
            else{
                if(st.isEmpty() || asteroids[st.peek()]<0)
                 st.push(i);

                 else{
                    while(!st.isEmpty() && asteroids[st.peek()]>0 && asteroids[st.peek()]<Math.abs(asteroids[i])){
                        st.pop();
                    }
                  
                    if(st.isEmpty() ||asteroids[st.peek()]<0 )
                     st.push(i);

                    else{
                        if( asteroids[st.peek()]==Math.abs(asteroids[i]))
                          st.pop();
                    }
                 }
            }
        }
          int[] ans = new int[st.size()];
          int i=0;
            for(int idx:st){
                ans[i++] = asteroids[idx];
            }

            return ans;

    }
}