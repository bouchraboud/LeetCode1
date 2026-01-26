class Solution {
    public int[] countBits(int n) {
        
        int[] arr=new int[n+1];
        arr[0]=0;
        if(n==0) return arr;
        arr[1]=1;
        if(n==1) return arr;
        
        for (int i = 2; i <= n; i *= 2) {
            for(int j=0;j<=i&&j+i<=n;j++){
                arr[j+i]=arr[j]+1;
            }
        }
        return arr;
    }
    

    
}