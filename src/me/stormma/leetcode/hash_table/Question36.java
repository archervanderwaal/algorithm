package me.stormma.leetcode.hash_table;

import java.util.*;

/**
 * 难度系数: 3星
 * leetcode 36
 * @author stormma
 * @date 2017/11/07
 */
public class Question36 {

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            Map<Integer, List<Character>> cube = new HashMap<>();
            for (int i = 0; i < 9; i++) {
                Set<Character> row = new HashSet<>();
                Set<Character> column = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.' && !row.add(board[i][j])) {
                        return false;
                    }
                    if (board[j][i] != '.' && !column.add(board[j][i])) {
                        return false;
                    }
                    int ind = 3 * (i / 3) + j / 3;
                    if (board[i][j] != '.') {
                        if (cube.get(ind) == null) {
                            List<Character> list = new ArrayList<>();
                            list.add(board[i][j]);
                            cube.put(ind, list);
                        } else {
                            if (cube.get(ind).contains(board[i][j])) {
                                return false;
                            }
                            cube.get(ind).add(board[i][j]);
                        }
                    }
                }
            }
            return true;
        }
    }
}
