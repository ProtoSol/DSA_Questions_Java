class Node {
    int first;
    int second;
    int third;
    Node(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution
{
    //Function to find distance of nearest 0 in the grid for each cell.
    public int[][] updateMatrix(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        int dis[][] = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        
        // Fill the visited matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }
        
        // Create the Delta Array
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        // Now Traverse the Grid and calculate the Distance
        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            int step = queue.peek().third;
            queue.remove();
            
            // Set the distance
            dis[row][col] = step;
            
            // Traverse in 4 Directions
            for(int i = 0; i < 4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0){
                    vis[nRow][nCol] = 1;
                    queue.add(new Node(nRow, nCol, step+1));
                }
            }
        }
        // Return the Distance Matrix;
        return dis;
    }
}
