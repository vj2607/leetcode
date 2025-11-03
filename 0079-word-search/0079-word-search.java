class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(rec(i,j,0,board,word))
                     return true;
                }
            }
        }

        return false;
         
    }
    boolean rec(int i , int j,int idx,char[][] board, String word){

      if(idx==word.length()){
        return true;
      }

     if(i < 0 || j < 0 || i >= board.length || j >= board[0].length 
        || board[i][j] != word.charAt(idx)) {
        return false;
    }

       char temp=board[i][j];
        board[i][j]='#';
        int drow[] = new int[]{0,0,-1,1};
        int dcol[] = new int[]{-1,1,0,0};
        for(int k=0;k<4;k++){
            int nrow=drow[k]+i;
            int ncol=dcol[k]+j;
              
                if(rec(nrow,ncol,idx+1,board,word))
                 return true;

        }
        board[i][j]=temp;
        return false;
    }
}