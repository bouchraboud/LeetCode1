class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0,0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, int end, List<String> curr, List<List<String>> result) {
    // If we reached the end of the string, add current partition
      if (start == s.length()) {
        result.add(new ArrayList<>(curr));
        return;
     }

     // If end goes past string length, stop this branch
    if (end == s.length()) return;

    // Check if substring s[start..end] is a palindrome
     if (isPalindrome(s, start, end)) {
        curr.add(s.substring(start, end + 1));       // add current palindrome
        backtrack(s, end + 1, end + 1, curr, result); // start new substring after current
        curr.remove(curr.size() - 1);               // backtrack
     }

    // Explore the next end index without moving start
    backtrack(s, start, end + 1, curr, result);
}
 private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
