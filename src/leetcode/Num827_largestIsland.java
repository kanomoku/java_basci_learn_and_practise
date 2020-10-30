package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Num827_largestIsland {
    public static void main(String[] args) {
//        int a[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//        };
        int a[][] = {{0, 1},
                {1, 0}};
        Num827_largestIsland num827_largestIsland = new Num827_largestIsland();
        System.out.println(num827_largestIsland.largestIsland(a));
    }

//    public int largestIsland(int[][] grid) {
//        int islandNum = 2; // 岛屿编号, 因为0和1已经被占用了
//        Map<Integer, Integer> islandAreasMap = new HashMap<>(); // 岛屿编号 -> 岛屿面积的 map
//
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[0].length; c++) {
//                if (grid[r][c] == 1) {
//                    int a = dfsForIslandArea(grid, r, c, islandNum);
//                    islandAreasMap.put(islandNum, a);
//                    islandNum++;
//                }
//            }
//        }
//
//        int res = 0;
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[0].length; c++) {
//                // 依次尝试填海
//                int ta = thisArea(grid, r, c, islandAreasMap);
//                res = Math.max(res, ta);
//            }
//        }
//        return res;
//    }
//
//    // 把 (r, c) 填海之后，最大的岛屿面积
//    int thisArea(int[][] grid, int r, int c, Map<Integer, Integer> islandAreas) {
//        if (grid[r][c] != 0) {
//            return islandAreas.get(grid[r][c]);
//        }
//        int res = 0;
//        Set<Integer> adjs = new HashSet<>();
//        if (inArea(grid, r - 1, c) && grid[r - 1][c] > 0) {
//            adjs.add(grid[r - 1][c]);
//        }
//        if (inArea(grid, r + 1, c) && grid[r + 1][c] > 0) {
//            adjs.add(grid[r + 1][c]);
//        }
//        if (inArea(grid, r, c - 1) && grid[r][c - 1] > 0) {
//            adjs.add(grid[r][c - 1]);
//        }
//        if (inArea(grid, r, c + 1) && grid[r][c + 1] > 0) {
//            adjs.add(grid[r][c + 1]);
//        }
//        for (int adj : adjs) {
//            System.out.println("adj = " + adj);
//            res += islandAreas.get(adj);
//        }
//        return res + 1;
//    }
//
//    // value 表示当前岛屿编号
//    int dfsForIslandArea(int[][] grid, int r, int c, int value) {
//        if (!inArea(grid, r, c)) {
//            return 0;
//        }
//
//        if (grid[r][c] != 1) { //这里面就好多状态了，但是只有1是放过的，别的说明不是海洋就是走过的陆地
//            return 0;
//        }
//
//        grid[r][c] = value; //每个岛屿的编号是不同的
//
//        return 1 + dfsForIslandArea(grid, r - 1, c, value) //返回岛屿的面积
//                + dfsForIslandArea(grid, r + 1, c, value)
//                + dfsForIslandArea(grid, r, c - 1, value)
//                + dfsForIslandArea(grid, r, c + 1, value);
//    }
//
//    boolean inArea(int[][] grid, int r, int c) {
//        return 0 <= r && r < grid.length
//                && 0 <= c && c < grid[0].length;
//    }


    public int largestIsland(int[][] grid) {
        int islandNum = 2; //每个岛的标号设置成不一致，编号初始值为2
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    int area = islandArea(grid, i, j, islandNum); //求当前岛屿的面积
                    if (area > 0) {
                        map.put(islandNum, area); //岛屿编号-->岛屿面积
                    }
                    islandNum++; // 存储完当前岛屿，改变岛屿编号存储下一个
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, plusArea(grid, i, j, map)); //取最大值思路，找到面积最大的人工岛屿
            }
        }
        return res;
    }

    int plusArea(int[][] grid, int r, int c, Map<Integer, Integer> map) {
        if (grid[r][c] != 0) { //如果不是海洋 就不去填海
            return map.get(grid[r][c]);
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();// 把当前海洋上下所有的所有陆地编号找到，至于为啥用set,是避免把同一个岛屿取两回
        if (inArea(grid, r - 1, c) && grid[r - 1][c] != 0) {
            set.add(grid[r - 1][c]);
        }
        if (inArea(grid, r + 1, c) && grid[r + 1][c] != 0) {
            set.add(grid[r + 1][c]);
        }
        if (inArea(grid, r, c - 1) && grid[r][c - 1] != 0) {
            set.add(grid[r][c - 1]);
        }
        if (inArea(grid, r, c + 1) && grid[r][c + 1] != 0) {
            set.add(grid[r][c + 1]);
        }
        for (Integer integer : set) { //填海的四周的陆地面积相加
            res += map.get(integer);
        }
        return res + 1; // 四周面积加上当前海洋面积就是连在一起的最大面积
    }

    int islandArea(int[][] grid, int r, int c, int islandNum) {
        if (!inArea(grid, r, c)) {
            return 0;// 求岛屿面积时， 如果是边界则返回
        }
        if (grid[r][c] == 0) {
            return 0; // 求岛屿面积时， 如果是海洋则返回
        }
        if (grid[r][c] != 1) {
            return 0; // 求岛屿面积时， 如果已经取过了则返回
        }
        grid[r][c] = islandNum; //给岛屿的这块土地编号，改变一下状态
        return 1 + islandArea(grid, r - 1, c, islandNum)
                + islandArea(grid, r + 1, c, islandNum)
                + islandArea(grid, r, c - 1, islandNum)
                + islandArea(grid, r, c + 1, islandNum);
    }

    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

}
