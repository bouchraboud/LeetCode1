class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int cur = dfs(grid, i, j);
                    if (cur > max) max = cur;
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check bounds and if the cell is water or already visited
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = -1; // mark as visited

        // Count current cell + all connected neighbors
        return 1
            + dfs(grid, i + 1, j)
            + dfs(grid, i - 1, j)
            + dfs(grid, i, j + 1)
            + dfs(grid, i, j - 1);
    }
}
