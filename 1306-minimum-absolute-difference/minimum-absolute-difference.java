import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // finding the range of the elements in the array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // creating a counting array
        int[] count = new int[max - min + 1];
        for (int num : arr) {
            count[num - min]++;
        }
        // reconstructing the sorted array from the counting array
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sortedList.add(i + min);
                count[i]--;
            }
        }
        // find the minimum absolute difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < sortedList.size(); i++) {
            minDiff = Math.min(minDiff, sortedList.get(i) - sortedList.get(i - 1));
        }
        // collecting all pairs with the minimum difference
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < sortedList.size(); i++) {
            if (sortedList.get(i) - sortedList.get(i - 1) == minDiff) {
                result.add(Arrays.asList(sortedList.get(i - 1), sortedList.get(i)));
            }
        }
        return result;
    }
}
