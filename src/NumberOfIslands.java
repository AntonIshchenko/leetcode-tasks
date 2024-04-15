public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int islandsNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandsNum++;
                    scanIsland(i, j, grid);
                }
            }
        }
        return islandsNum;
    }

    private void scanIsland(int i, int j, char[][] grid) {
        grid[i][j] = '2';

        if (grid.length > i + 1 && grid[i + 1][j] == '1') {
            scanIsland(i + 1, j, grid);
        }
        if (i > 0 && grid[i - 1][j] == '1') {
            scanIsland(i - 1, j, grid);
        }
        if (grid[i].length > j + 1 && grid[i][j + 1] == '1') {
            scanIsland(i, j+1, grid);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            scanIsland(i, j-1, grid);
        }
    }

}
