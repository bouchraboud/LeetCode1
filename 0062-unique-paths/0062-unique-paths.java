class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return paths(m - 1, n - 1, memo);
    }

    private int paths(int i, int j, int[][] memo) {
        // Out of bounds
        if (i < 0 || j < 0) return 0;

        // Start cell
        if (i == 0 && j == 0) return 1;

        // Already computed
        if (memo[i][j] != 0) return memo[i][j];

        memo[i][j] = paths(i - 1, j, memo) + paths(i, j - 1, memo);
        return memo[i][j];
    }
}
