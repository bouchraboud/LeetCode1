class Solution {
    public int countSubstrings(String s) {
        
        int n=s.length();
        int result=0;

        for(int i=0;i<n;i++){
            result+=round(s,n,i,i)+round(s,n,i,i+1);

        }
        return result;
    }

    private int round(String s,int n,int left,int right){
        int count=0;
        while(left>=0&&right<n&&
        s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;


    }
}
