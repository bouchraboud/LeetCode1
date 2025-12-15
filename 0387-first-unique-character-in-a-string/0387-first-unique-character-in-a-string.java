class Solution {
    public int firstUniqChar(String s) {

        int[] frequency =new int[26] ;
        Map<Integer,Integer> firstAppearence=new HashMap<>();

        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i)-'a']++;
            firstAppearence.putIfAbsent(s.charAt(i)-'a',i);
        }
        int first=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(frequency[i]==1&&first>firstAppearence.get(i)){
                    first=firstAppearence.get(i);
            }
            
        }
        if(first==Integer.MAX_VALUE) return -1;
        return first;

        
    }
}