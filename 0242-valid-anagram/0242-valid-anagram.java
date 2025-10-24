class Solution {
    public boolean isAnagram(String s, String t) {
        int[] tem=new int[26];
		
		if(s.length()!=t.length()) return false;
		int i=0;
		int n=s.length();
		while(i<n) {
			tem[s.charAt(i)-'a']++;
			i++;
		}
		i=0; 
		while(i<n) {
			tem[t.charAt(i)-'a']--;
			
			if (tem[t.charAt(i)-'a']<0) return false;
			i++;
		}
		return true;
    }
}