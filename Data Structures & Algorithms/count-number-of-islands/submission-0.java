class Solution {
    void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0') return;
        grid[i][j] = '0';
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};
        for(int idx=0; idx<4; idx++) {
            dfs(grid, i+x[idx], j+y[idx]);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
}
