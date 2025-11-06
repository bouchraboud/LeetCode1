class Solution {
    public int maxProfit(int[] prices) {
        


        int max=0;
        int slid1=0;
        for(int i=0;i<prices.length;i++){
               if(prices[i]>prices[slid1]){
                   if(prices[i]-prices[slid1]>max){
                          max=prices[i]-prices[slid1];
                   }
                  
               }else{
                        slid1=i;
                }
        }

        return max;
    }
}