class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] frequency =new int[26];

        for(int i=0;i<s1.length();i++){
            frequency[s1.charAt(i)-'a']++;
        }

        String freqStr=Arrays.toString(frequency);

        for(int i=0;i<s2.length();i++){
            if(frequency[s2.charAt(i)-'a']!=0){
                int[] temp =new int[26];
                temp[s2.charAt(i)-'a']++;
                int j=i+1;
                while(j<s2.length()&&j-i<s1.length()){
                    temp[s2.charAt(j)-'a']++;
                    j++;
                }
                System.out.println(Arrays.toString(temp));
                System.out.println(freqStr);
                if(Arrays.toString(temp).equals(freqStr)) return true;
            }
        }

        return false;
            

          
    }
}
