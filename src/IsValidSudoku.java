import java.util.Arrays;
import java.util.List;

public class IsValidSudoku {

    public static final int charZero = 48;

    public boolean isValidSudoku(char[][] board) {

        board = new char[][]{{'.','.','4','.','.','.','6','3','.'},
                             {'.','.','.','.','.','.','.','.','.'},
                             {'5','.','.','.','.','.','.','9','.'},
                             {'.','.','.','5','6','.','.','.','.'},
                             {'4','.','3','.','.','.','.','.','1'},
                             {'.','.','.','7','.','.','.','.','.'},
                             {'.','.','.','5','.','.','.','.','.'},
                             {'.','.','.','.','.','.','.','.','.'},
                             {'.','.','.','.','.','.','.','.','.'}};



        if (!checkDuplicates(9, board)) {
            return false;
        }
        return true;
    }

    private boolean checkDuplicates(int cellSize, char[][] board) {
        int[] horizontal;
        int[][] vertical = new int[10][10];
        int[][] cells = new int [10][10];
        for (int i = 0; i < cellSize; i++) {
            horizontal = new int[10];
            for (int j = 0; j < cellSize; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if(cells[(i/3) *3 +  (j/3)][board[i][j]-charZero]++ > 0) {
                    return false;
                }

                if (vertical[j][board[i][j] - charZero]++ > 0) {
                    return false;
                }

                if (horizontal[board[i][j] - charZero]++ > 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
