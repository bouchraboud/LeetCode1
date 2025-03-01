class Solution {
    public int climbStairs(int n) {
        int[] memo=new int[n+1];
        return fun(n,memo);
    }
    public int fun(int n,int[] memo){
        if(memo[n]!=0) return memo[n];
        else if(n==1) return 1;
        else if(n==2) return 2;
        else{
            memo[n]=fun(n-1,memo)+fun(n-2,memo);
            return memo[n];
        }
    }
}