class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1, right = max;
        int result = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = 0L;

            // Calculate total hours needed at speed = mid, using long to avoid overflow
            for (int pile : piles) {
                hours += (pile + (long)mid - 1) / mid; // ceil division, cast to long
                if (hours > h) break; // early stop if already too slow
            }

            if (hours <= h) {
                result = mid;
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1;  // need higher speed
            }
        }

        return result;
    }
}
