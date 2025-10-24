class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                if (map.get(s.charAt(i)) == 0)
                    map.remove(s.charAt(i));

            } else {
                map.put(s.charAt(i), 1);
            }

        }

        for (int i = 0; i < t.length(); i++) {

            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if (map.get(t.charAt(i)) == 0)
                    map.remove(t.charAt(i));

            } else {
                map.put(s.charAt(i), -1);
                return false;

            }

        }
        if (map.size() == 0)
            return true;
        return false;

    }
}