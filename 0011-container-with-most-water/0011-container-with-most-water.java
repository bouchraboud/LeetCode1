class Solution {
    public int maxArea(int[] heights) {
        
        int n=heights.length;
        int max=0;
        int r=n-1;
        int l=0;

        while(l<r){
            int sum = (r - l) * Math.min(heights[r],heights[l]);
            if(sum>max){max=sum;}
            if(heights[l]>=heights[r]){
                     r--;
            }else{
                     l++;
            }
        }
        return max;
    }
}
