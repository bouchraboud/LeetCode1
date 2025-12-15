class Solution {
    public int firstUniqChar(String s) {
        int[] frequency = new int[26];
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            frequency[idx]++;
            if (firstIndex[idx] == -1) firstIndex[idx] = i;  // première apparition
        }

        int first = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 1 && firstIndex[i] < first) {
                first = firstIndex[i];
            }
        }

        return first == Integer.MAX_VALUE ? -1 : first;
    }
}
