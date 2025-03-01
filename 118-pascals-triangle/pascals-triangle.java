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

    private List<Integer> fun(int numsRow, List<List<Integer>> generate) {
        List<Integer> result = new ArrayList<>();
        if (numsRow == 1) {
            result.add(1);
            generate.add(result);
            return result;
        }
        List<Integer> prevL = fun(numsRow - 1, generate);
        result.add(1);
        int half = (numsRow - 1) / 2;
        for (int i = 1; i <= half; i++) {
            int val = prevL.get(i - 1) + prevL.get(i);
            result.add(val);
        }
        // Mirror the computed values for symmetry
        for (int i = (numsRow % 2 == 0) ? half : half - 1; i >= 0; i--) {
            result.add(result.get(i));
        }
        generate.add(result);
        return result;
    }
}
