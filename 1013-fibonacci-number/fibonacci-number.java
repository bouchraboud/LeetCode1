class Solution {
    public int fib(int n) {
        // int[] memo=new int[n+1];
        // return fun(n,memo);
         return BottomUp(n);

    }
    public int BottomUp(int n){
         int[] buttomUp=new int[n+1];
         if(n==0) return 0;
         if(n==1) return 1;
         buttomUp[0]=0;
         buttomUp[1]=1;
         for(int i=2;i<=n;i++){
            buttomUp[i]=buttomUp[i-1]+buttomUp[i-2];
         }
         return buttomUp[n];
    }








//     public int memoized(int n,int[] memo){
//         int result;
//         if(memo[n]!=0) return memo[n];
//         else if(n==0) result=0;
//         else if(n==1) result=1;
//         else result=memoized(n-1,memo)+memoized(n-2,memo);
//         memo[n]=result;
//         return result;

//     }
}