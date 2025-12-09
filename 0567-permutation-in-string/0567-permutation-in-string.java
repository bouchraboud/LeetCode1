class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s11 = s1.toCharArray();
        Arrays.sort(s11);
        String s1sorted=new String(s11);
            
              for(int i=0;i<s2.length();i++){
                      if(i+s1.length()-1<s2.length()&&s1.contains(String.valueOf(s2.charAt(i)))) {
                            String curr=s2.substring(i,i+s1.length());
                            char[] chars = curr.toCharArray();
                            Arrays.sort(chars);
                            String currSorted=new String(chars);
                            if(currSorted.equals(s1sorted)) return true;       
                      }
            }
            return false;
        
          
    }
}
