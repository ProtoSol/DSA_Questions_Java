class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int majorityElement = 0;
        int maxCount = 0;
        for (int num : countMap.keySet()) {
            if (countMap.get(num) > maxCount) {
                maxCount = countMap.get(num);
                majorityElement = num;
            }
        }
        
        return majorityElement;
    }
}