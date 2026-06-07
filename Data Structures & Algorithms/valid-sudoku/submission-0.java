class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                int val = board[r][c] - '0';
                int box = (r / 3) * 3 + (c / 3);

                if (rows[r][val] || cols[c][val] || boxes[box][val]) {
                    return false;
                }

                rows[r][val] = true;
                cols[c][val] = true;
                boxes[box][val] = true;
            }
        }

        return true;
    }
}
