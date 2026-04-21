class Solution {
    int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) return 0;
        grid[i][j] = 0;
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int result = 1;
        for(int idx=0; idx<4; idx++) {
            result += dfs(grid, i+x[idx], j+y[idx]);
        }
        return result;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1){
                    result=Math.max(result, dfs(grid, i, j));
                }
            }
        }
        return result;
    }
}
