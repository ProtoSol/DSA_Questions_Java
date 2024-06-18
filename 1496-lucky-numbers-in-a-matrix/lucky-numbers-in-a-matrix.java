class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        // Maintain a list of minimum elements in each row
        List<Integer> minRow = new ArrayList<>();
        for (int[] row : matrix) {
            int minRowElement = Integer.MAX_VALUE;
            for (int val : row) {
                minRowElement = Math.min(minRowElement, val);
            }
            minRow.add(minRowElement);
        }
        
        // Maintain a list of maximum elements in each column
        List<Integer> maxCol = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int col = 0; col < cols; col++) {
            int maxColElement = Integer.MIN_VALUE;
            for (int row = 0; row < rows; row++) {
                maxColElement = Math.max(maxColElement, matrix[row][col]);
            }
            maxCol.add(maxColElement);
        }
        
        // Find lucky numbers (elements that are both min in their row and max in their column)
        for (int val : minRow) {
            if (maxCol.contains(val)) {
                result.add(val);
            }
        }
        
        // Return the result
        return result;
    }
}