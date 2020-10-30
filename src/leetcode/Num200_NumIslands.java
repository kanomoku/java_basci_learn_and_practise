package leetcode;

public class Num200_NumIslands {
    public static void main(String[] args) {
//        String a[][] = {{"1", "1", "0", "0", "0"},
//                {"1", "1", "0", "0", "0"},
//                {"0", "0", "1", "0", "0"},
//                {"0", "0", "0", "1", "1"}};


        String a[][] = {{"1","1","1","1","0"},
                        {"1","1","0","1","0"},
                        {"1","1","0","0","0"},
                        {"0","0","0","0","0"}};
        System.out.println(numIslands(a));

    }

    public static int numIslands(String[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ("1".equals(grid[i][j])) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(String[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return;
        }
        if ("0".equals(grid[r][c])) {
            return;
        }
        if (!"1".equals(grid[r][c])) {
            return;
        }
        grid[r][c] = "2";
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}