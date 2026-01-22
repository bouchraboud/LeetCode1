class Solution {
    public int numDecodings(String s) {
        
        int n=s.length();
        int[][] memo=new int[n][2];
        for (int i = 0; i < n; i++) {
              Arrays.fill(memo[i], -1); // fill each row
        }
       
        if(s.charAt(0)=='0') return 0;
        
        return expand(s,0,1,memo)+expand(s,0,2,memo);
        
    }
    private int expand(String s,int i,int size,int[][]memo){
        if(s.charAt(i)=='0'||i+size>s.length()) return 0;
        
        
        

        int cur=Integer.parseInt(s.substring(i,i+size));
        System.out.println(cur);

        if(cur<=26&&cur>=1){
             if(i+size==s.length()) return 1;
             if(memo[i][size-1]==-1){
                memo[i][size-1]=expand(s,i+size,1,memo)+expand(s,i+size,2,memo);
             }
             return memo[i][size-1];
        }else{
            return 0;
        }
    }
}
