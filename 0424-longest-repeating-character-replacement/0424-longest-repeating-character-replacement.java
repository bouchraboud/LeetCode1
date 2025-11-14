class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] arr=new int[26];

        int i=0;
        int result=0;//longet length
        while((i+result)<s.length()){
            arr[s.charAt(i + result) - 'A']++;
            int max=arr[0];
            int sum=0;
            for(int j=0;j<26;j++){
                   sum+=arr[j];
                  if(max<arr[j]){
                    max=arr[j];
                  }
            }
           
            sum-=max;
           

            if(sum<=k){
                
                  result+=1;
            }else{
                
                arr[s.charAt(i)-'A']--;
                i++;
            }
            
        }

        return result;




    }
}
