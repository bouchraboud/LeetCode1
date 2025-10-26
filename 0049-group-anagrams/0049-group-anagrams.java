class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String,List<String>> map=new HashMap<String,List<String>>();

        for(int i=0;i<strs.length;i++){
            int[] asci=new int[26];
            for(int j=0;j<strs[i].length();j++){
                asci[strs[i].charAt(j) - 'a']++;
            }
            String Count = Arrays.toString(asci);
            if(!map.containsKey(Count)){
              map.put(Count, new ArrayList<>());
            }
              map.get(Count).add(strs[i]);
        }
        List<List<String>> result=new ArrayList<List<String>>();

       map.forEach((key, value) -> result.add(value));
        return result;
        
    }
}