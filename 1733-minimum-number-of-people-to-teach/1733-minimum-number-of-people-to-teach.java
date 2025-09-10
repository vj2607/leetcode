class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashSet<Integer> problematicFriendship = new HashSet<>();

        for(int arr[] : friendships){
            int u=arr[0]-1 , v=arr[1]-1;
              boolean isProblematic=true;
            for(int lang1:languages[u]){

                for(int lang2:languages[v]){
                      if(lang1==lang2){
                        isProblematic=false;
                        break;
                      }
                }
                if(!isProblematic) break;
            }
            if(isProblematic){
                problematicFriendship.add(u);
                problematicFriendship.add(v);           
                 }
        }

        if(problematicFriendship.isEmpty())
          return 0;
      int ans = languages.length+1;
      for(int i=1;i<=n;++i){

          int count=0;
         
          for(int user:problematicFriendship){
             boolean found=false;
              for(int lang:languages[user]){
                    if(i==lang){
                       found=true;
                       break;
                    }
              }
                if(!found)
                 count++;
          }

          ans = Math.min(ans,count);


       }



      return ans;
        
        
    }
}