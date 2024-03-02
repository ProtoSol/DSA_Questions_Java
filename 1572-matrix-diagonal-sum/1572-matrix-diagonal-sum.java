class Solution {
    public int diagonalSum(int[][] mat) {
      int n= mat.length;
      int sum=0;
        for(int i=0; i<n;i++ ){
          
            sum+=mat[i][i]; //forward Diagonal
            sum+=mat[i][n-i-1]; // backward diagonnal
         
        }
        // if length is odd then mis=ddle one will count 2 time so we have to subtract it one time the middle element
        int oddLength= sum-mat[n/2][n/2];
        return (n%2==0) ?sum: oddLength;
    }
}