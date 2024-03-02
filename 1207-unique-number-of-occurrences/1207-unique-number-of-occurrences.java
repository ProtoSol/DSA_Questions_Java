class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int i : arr) {
            occurrences.put(i, occurrences.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> uniqueCounts = new HashSet<>(occurrences.values());
        return occurrences.size() == uniqueCounts.size();
    }
}
