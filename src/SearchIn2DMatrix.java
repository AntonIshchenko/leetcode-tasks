public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix[0].length-1;
        int y = 0;
        while (x >= 0 && y <= matrix.length-1) {
            if (matrix[y][x] == target) {
                return true;
            }
            if(matrix[y][x] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
