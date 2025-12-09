class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] s1Count = new int[26]; // counts for s1
        int[] windowCount = new int[26]; // counts for current window in s2

        // initialize counts for s1 and first window in s2
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        // count how many letters match exactly
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == windowCount[i]) matches++;
        }

        // slide the window
        for (int i = len1; i < len2; i++) {
            if (matches == 26) return true; // all letters match

            int indexIn = s2.charAt(i) - 'a';           // char entering the window
            int indexOut = s2.charAt(i - len1) - 'a';  // char leaving the window

            // add the new char
            windowCount[indexIn]++;
            if (windowCount[indexIn] == s1Count[indexIn]) {
                matches++;
            } else if (windowCount[indexIn] == s1Count[indexIn] + 1) {
                matches--;
            }

            // remove the old char
            windowCount[indexOut]--;
            if (windowCount[indexOut] == s1Count[indexOut]) {
                matches++;
            } else if (windowCount[indexOut] == s1Count[indexOut] - 1) {
                matches--;
            }
        }

        return matches == 26;
    }
}
