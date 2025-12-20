class Solution {
    public int countDigits(int num) {
        int count=0;
        String number=Integer.toString(num);
        int i=0;
        while(i<number.length()){
            int cur=number.charAt(i)-'0';
            if(num%cur==0) count++;
            i++;
        }
        return count;
        
    }
}