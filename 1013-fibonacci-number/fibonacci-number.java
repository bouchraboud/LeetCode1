class Solution {
    public int fib(int n) {
        int[] memo=new int[n+1];
        return fun(n,memo);
    }
    public int fun(int n,int[] memo){
        int result;
        if(memo[n]!=0) return memo[n];
        else if(n==0) result=0;
        else if(n==1) result=1;
        else result=fun(n-1,memo)+fun(n-2,memo);
        memo[n]=result;
        return result;

    }
}