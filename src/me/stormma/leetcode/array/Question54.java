package me.stormma.leetcode.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 3星
 * leetcode 54
 * @author stormma
 * @date 2017/12/04
 */
public class Question54 {
    /**
     * from me
     */
    static class Solution1 {
        static List<Integer> ans = new ArrayList<>();
        public List<Integer> spiralOrder(int[][] matrix) {
            ans.clear();
            if (matrix == null || matrix.length == 0) return ans;
            helper(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
            return ans;
        }

        private void helper(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn) {
            if (endRow < startRow || endColumn < startColumn) return;
            int x = startRow, y = startColumn;
            while (y <= endColumn) ans.add(matrix[x][y++]);
            x++;
            y = endColumn;
            while (x <= endRow) ans.add(matrix[x++][y]);
            x = endRow;
            y = endColumn - 1;
            while (x > startRow && y >= startColumn) ans.add(matrix[x][y--]);
            x = endRow - 1;
            y = startColumn;
            while (y < endColumn && x > startRow) ans.add(matrix[x--][y]);
            helper(matrix, startRow + 1, startColumn + 1, endRow - 1, endColumn - 1);
        }
    }

    /**
     * from leetcode's discuss
     */
    static class Solution2 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<Integer>();
            if (matrix.length == 0) {
                return res;
            }
            int rowBegin = 0;
            int rowEnd = matrix.length-1;
            int colBegin = 0;
            int colEnd = matrix[0].length - 1;
            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                // Traverse Right
                for (int j = colBegin; j <= colEnd; j ++) {
                    res.add(matrix[rowBegin][j]);
                }
                rowBegin++;
                // Traverse Down
                for (int j = rowBegin; j <= rowEnd; j ++) {
                    res.add(matrix[j][colEnd]);
                }
                colEnd--;
                if (rowBegin <= rowEnd) {
                    // Traverse Left
                    for (int j = colEnd; j >= colBegin; j --) {
                        res.add(matrix[rowEnd][j]);
                    }
                }
                rowEnd--;
                if (colBegin <= colEnd) {
                    // Traver Up
                    for (int j = rowEnd; j >= rowBegin; j --) {
                        res.add(matrix[j][colBegin]);
                    }
                }
                colBegin ++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{2}, {3}};
        System.out.println(new Solution1().spiralOrder(matrix));
    }
// 1 2 3 4
// 5 6 7 8
// 9 1 1 1
// 0 0 0 0
// 1 2 3 4 8 1 0 0 0 0 9 5 6 7 1 1 9
}
