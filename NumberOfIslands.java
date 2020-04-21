class Solution {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        if(n == 0) return 0;
        m = grid[0].length;
        boolean[][] fill = new boolean[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                fill[i][j] = false;
        
        int count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(grid[i][j] == '1' && !fill[i][j]) {
                    doFill(i, j, fill, grid);
                    count++;
                }
        
        return count;
    }
    
    private void doFill(int i, int j, boolean[][] fill, char[][] g) {
        Node node = new Node(i, j);
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.empty()) {
            Node top = stack.pop();
            if(fill[top.x][top.y]) continue;
            fill[top.x][top.y] = true;
            if(top.x + 1< n && g[top.x + 1][top.y] == '1' && !fill[top.x + 1][top.y])
                stack.push(new Node(top.x + 1, top.y));
            if(top.x - 1 >= 0 && g[top.x - 1][top.y] == '1' && !fill[top.x - 1][top.y])
                stack.push(new Node(top.x - 1, top.y));
            if(top.y + 1< m && g[top.x][top.y + 1] == '1' && !fill[top.x][top.y + 1])
                stack.push(new Node(top.x, top.y + 1));
            if(top.y - 1 >= 0 && g[top.x][top.y - 1] == '1' && !fill[top.x][top.y - 1])
                stack.push(new Node(top.x, top.y - 1));
        }
    }
    
    static class Node {
        int x;
        int y;
        Node(int i, int j) {x = i; y = j;}
    }
}