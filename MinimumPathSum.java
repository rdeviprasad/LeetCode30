class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] += grid[i][j];
                if(i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                } else if(j > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}