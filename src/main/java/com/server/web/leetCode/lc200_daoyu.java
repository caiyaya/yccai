package com.server.web.leetCode;

/**
 * @author huangh
 * @description:
 * @date 2021/5/22
 */

class lc200_daoyu {
    public static void main(String[] args) {
        char[][] str = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int i = numIsLands(str);
        System.out.println(i);
    }

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * 例如
     * 输入：grid = [
     * ['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']
     * ]
     * 输出：1
     */
    public static int numIsLands(char[][] grid) {
        // 统计岛屿的个数
        int count = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 两个for循环遍历每一个格子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 只有当前格子是1才开始计算
                if (grid[i][j] == '1') {
                    // 然后通过bfs把当前格子的上下左右4
                    // 个位置为1的都要置为0，因为他们是连着
                    // 一起的算一个岛屿，
                    dfs(grid, i, j);
                    // 如果当前格子是1，岛屿的数量加1
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param grid
     * @param i
     * @param j
     */
    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 渲染，将和此位置相连的所有岛屿值从1改为0，表示已经访问过
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

}


