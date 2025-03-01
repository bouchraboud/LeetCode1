import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        fun(numRows, result);
        return result;
    }

    public List<Integer> fun(int numsRow, List<List<Integer>> generate) {
        List<Integer> result = new ArrayList<>();
        if (numsRow == 1) {
            result.add(1);
            generate.add(result);
            return result;
        } else {
            result.add(1);
            List<Integer> prevL = fun(numsRow - 1, generate);
            result.add(1);
            if(numsRow==2){ 
             generate.add(result);
             return result;}
            for (int i = 1; i <=(numsRow-1)/2; i++) {
                int val = prevL.get(i) + prevL.get(i - 1);
                result.add(i,val);
                if(result.size()<numsRow) result.add(i+1,val);
            }
            
            generate.add(result);
            return result;
        }
    }
}