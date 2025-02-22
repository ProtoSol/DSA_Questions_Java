class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        double[][] cars = new double[n][2];

        // Fill the 2D array
        for (int i = 0; i < n; i++) {
            cars[i] = new double[] { position[i], (double) (target - position[i]) / speed[i] };
        }

        // Sort cars by position from the farthest to the closest
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int count = 0;
        double prevTime = 0;

        // Process from the rightmost car (closest to the target)
        for (double[] car : cars) {
            if (car[1] > prevTime) {
                count++;
                prevTime = car[1];
            }
        }

        return count;

    }
}