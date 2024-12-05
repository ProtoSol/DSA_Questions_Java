class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> smallList = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        helper(n, smallList, finalList, 1, k);
        return finalList;
    }

    void helper(int n, List<Integer> smallList, List<List<Integer>> finalList, int index, int k) {
        if (smallList.size() == k) {
            finalList.add(new ArrayList<>(smallList));
            return;
        }
        for (int i = index; i <= n; i++) {
            smallList.add(i);
            helper(n, smallList, finalList, i + 1, k);
            smallList.remove(smallList.size() - 1);
        }
    }
}
