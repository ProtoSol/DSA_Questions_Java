class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> smallResult = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, visited, smallResult, result);
        return result; 
    }
    private void permute(int[] nums, boolean[] visited, List<Integer> smallResult, List<List<Integer>> result){
        if(smallResult.size() == nums.length){
            result.add(new ArrayList<>(smallResult));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            smallResult.add(nums[i]);
            permute(nums, visited, smallResult, result);
            smallResult.remove(smallResult.size() - 1);
            visited[i] = false;
        }
    }
}