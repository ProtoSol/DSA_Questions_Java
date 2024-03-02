class Solution {
    public int find_pivot(List<Integer> v) {
        int s = 0, e = v.size() - 1;
        int mid = (s + e) / 2;
        while (s < e) {
            if (v.get(mid) < v.get(mid + 1))
                s = mid + 1;
            else
                e = mid;

            mid = (s + e) / 2;
        }
        return s;
    }

    public int peakIndexInMountainArray(int[] arr) {
        // Convert array to List
        List<Integer> list = new java.util.ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return find_pivot(list);
    }
}

