import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Use TreeMap to automatically sort the keys
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Add all elements from nums1 to the map
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i][0], nums1[i][1]);
        }

        // Merge elements from nums2 into the map
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i][0])) {
                // If the key already exists, add the value from nums2 to the existing value
                map.put(nums2[i][0], map.get(nums2[i][0]) + nums2[i][1]);
            } else {
                // If the key does not exist, add the key-value pair from nums2
                map.put(nums2[i][0], nums2[i][1]);
            }
        }

        // Convert the map to a 2D array
        int[][] result = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }

        return result;
    }
}