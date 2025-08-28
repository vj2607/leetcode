class Solution {
    static int modulo = 1_000_000_007;
    public long subArrayRanges(int[] nums) {
        int n =nums.length;
        long sum=0;

      
        sum= sumSubarrayMax(nums)-sumSubarrayMins(nums);
      
       
        return sum;
    }

     public long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] nge = findNge(arr,n);
        int[] pge = findPge(arr,n);
        long sum=0;

        for(int i=0;i<n;i++){
           long left = i-pge[i];
           long right= nge[i]-i;
            sum+= left*right*(long) arr[i];
        }
        return sum;
    }

    int[] findNge(int[] arr,int n){
        
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
            st.pop();

            ans[i]= st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return ans;
    }

     int[] findPge(int[] arr,int n){
        
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
            st.pop();

            ans[i]= st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
    
      public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findNse(arr,n);
        int[] pse = findPse(arr,n);
        long sum=0;

        for(int i=0;i<n;i++){
           long left = i-pse[i];
           long right= nse[i]-i;
            sum+= left*right*(long) arr[i];
        }
        return sum;
    }

    int[] findNse(int[] arr,int n){
        
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();

            ans[i]= st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return ans;
    }

     int[] findPse(int[] arr,int n){
        
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            st.pop();

            ans[i]= st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
}