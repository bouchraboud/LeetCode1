class Solution {
    public int mostWordsFound(String[] sentences) {
        int max=0;
         for(int i=0;i<sentences.length;i++){
                   int cur=wordsInSentence(sentences[i]);
                  if(cur>max) max=cur ; 
         }

         return max;
    }

    private int wordsInSentence(String sentence){
        if(sentence.length()==0) return 0;

        int count=0;
        int i=0;
        while(i<sentence.length()){
            if(sentence.charAt(i)==' ') count++;
            i++;
        }
        count++;
        return count;
    }
}