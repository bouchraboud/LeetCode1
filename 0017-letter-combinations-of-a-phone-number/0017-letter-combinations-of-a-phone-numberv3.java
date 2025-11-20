class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> helper = new HashMap<>();

        helper.put('0', Arrays.asList('+'));
        helper.put('2', Arrays.asList('a', 'b', 'c'));
        helper.put('3', Arrays.asList('d', 'e', 'f'));
        helper.put('4', Arrays.asList('g', 'h', 'i'));
        helper.put('5', Arrays.asList('j', 'k', 'l'));
        helper.put('6', Arrays.asList('m', 'n', 'o'));
        helper.put('7', Arrays.asList('p', 'q', 'r', 's'));
        helper.put('8', Arrays.asList('t', 'u', 'v'));
        helper.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        backtrack("", digits, 0, helper, result);
        return result;
    }

    private void backtrack(
            String cur,
            String digits,
            int index,
            Map<Character, List<Character>> helper,
            List<String> result) {

        if (index == digits.length()) {
            if (!cur.isEmpty()) {
                result.add(cur);
            }
            return;
        }

        List<Character> list = helper.get(digits.charAt(index));
        if (list == null) return;

        for (char c : list) {
            backtrack(cur + c, digits, index + 1, helper, result);
        }
    }
}
