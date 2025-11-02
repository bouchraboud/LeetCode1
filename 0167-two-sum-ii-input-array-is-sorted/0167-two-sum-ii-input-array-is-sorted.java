class Solution {
    public int[] twoSum(int[] numbers, int target) {

     int n=numbers.length;
     int j=n-1;
     for(int i=0;i<n;i++){
        
        while(numbers[i]+numbers[j]>target){
            j--;
        }
        if(numbers[i]+numbers[j]==target){
            return new int[] { i+1, j+1 };
        }
     }  

     return new int[2];
    }
}
