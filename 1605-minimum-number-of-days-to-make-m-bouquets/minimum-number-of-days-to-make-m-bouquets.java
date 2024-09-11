class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) return -1; // Impossible case

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            start = Math.min(start, day);
            end = Math.max(end, day);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            if (bouquets >= m) return true;
        }
        return false;
    }
}