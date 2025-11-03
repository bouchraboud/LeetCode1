class Solution {
    public int maxArea(int[] heights) {
        
        int n=heights.length;
        int max=0;
        int j=n-1;
        for(int i=0;i<n;i++){
            while(i<j&&heights[i]>heights[j]){
             int sum = (j - i) * Math.min(heights[j],heights[i]);
             if(sum>max){max=sum;}
             j--;  
            }

             int sum = (j - i) * Math.min(heights[j],heights[i]);
             if(sum>max){ max=sum;}  
              

        }
        return max;
    }
}
