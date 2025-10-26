class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String,List<String>> map=new HashMap<String,List<String>>();

        for(String str : strs) {
            int[] asci=new int[26];
            for(int j=0;j<str.length();j++){
                asci[str.charAt(j) - 'a']++;
            }
            String Count = Arrays.toString(asci);
            if(!map.containsKey(Count)){
              map.put(Count, new ArrayList<>());
            }
              map.get(Count).add(str);
        }
        List<List<String>> result=new ArrayList<List<String>>();

       return new ArrayList<>(map.values());
        
    }
}