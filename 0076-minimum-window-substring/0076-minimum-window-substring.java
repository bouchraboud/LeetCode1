class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        // Build frequency map for t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        // Track current window frequencies
        Map<Character, Integer> window = new HashMap<>();
        
        int left = 0, right = 0;
        
        int valid = 0; // Count of characters that meet the requirement
        
        // Track the minimum window
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            // Expand window by moving right
            char c = s.charAt(right);
            right++;
            
            // Update window data
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            // Try to contract window from left
            while (valid == need.size()) {
                // Update minimum window
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                
                // Remove leftmost character
                char d = s.charAt(left);
                left++;
                
                // Update window data
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}