package leetcode;

public class Num463_islandPerimeter {

    public static void main(String[] args) {
        int a[][] = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(islandPerimeter(a));
    }

    public static int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {//这里两层循环只是为了找到岛屿的第一个入口边界
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    public static int dfs(int[][] grid, int r, int c) {
        // 用了非对即错的思路，不需要列举出错误的例子，只要不对那就是错
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;// 这里结合了本题情况，岛屿的周长就是岛屿方格和非岛屿方格相邻的边的数量，这个if里是和边界相邻的统计值，此分支递归结束终止扩散
        }
        if (grid[r][c] == 0) {
            return 1;// 这里结合了本题情况，岛屿的周长就是岛屿方格和非岛屿方格相邻的边的数量，这个if里是和水域相邻的统计值，此分支递归结束终止扩散
        }
        if (grid[r][c] != 1) {
            return 0;// 目前有三种取值，0,1,2,。0的情况在上面已经被拦截了，1的情况放过，这里其实只会拦截2，为2说明这里走过了，此分支递归结束终止扩散
        }
        grid[r][c] = 2; //防止重复走改变一下走过方格的状态
        return dfs(grid, r - 1, c) // 下面就是此方格为1的时候，向周边递归扩散，结合本题统计边界数量，所以做累加
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }
}
