class Solution {

    private List<Integer> generateRow(int rows){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col = 1; col < rows; col++){
            ans = ans * (rows - col) / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row = 1; row <= numRows; row++){
            ans.add(generateRow(row));
        }
        return ans;
    }
}