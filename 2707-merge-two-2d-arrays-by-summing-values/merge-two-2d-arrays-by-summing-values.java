import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Use HashMap for O(1) insertions and lookups
        HashMap<Integer, Integer> map = new HashMap<>();

        // Merge nums1 into the map
        for (int[] num : nums1) {
            map.put(num[0], num[1]);
        }

        // Merge nums2 into the map
        for (int[] num : nums2) {
            // If the key already exists, add the value from nums2 to the existing value
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        // Convert the map to a 2D array
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }

        // Sort the result by the first element (ID)
        Arrays.sort(result, (a, b) -> a[0] - b[0]);

        return result;
    }
}