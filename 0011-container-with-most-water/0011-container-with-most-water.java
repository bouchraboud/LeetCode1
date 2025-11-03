class Solution {
    public int maxArea(int[] heights) {
        
        int n=heights.length;
        int max=0;
        for(int i=0;i<n;i++){
        for(int j=n-1;j>i;j--){
             int sum = (j - i) * Math.min(heights[j],heights[i]);
             System.out.println(sum);
             if(sum>max){
                max=sum;
             }
           
         
        }
        }
        return max;
    }
}
