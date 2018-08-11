package me.stormma.leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度系数: 3星
 * leetcode 437
 * @author stormma
 * @date 2017/12/05
 */
public class Question437 {

    static class Solution1 {
        public int pathSum(TreeNode root, int sum) {
            if (root == null)   return 0;
            return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int dfs(TreeNode node, int target) {
            if (node == null) return 0;
            return (node.val == target ? 1 : 0)
                    + dfs(node.left, target - node.val) + dfs(node.right, target - node.val);
        }
    }

    static class Solution2 {
        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return dfs(root, 0 , sum, map);
        }

        public static int dfs(TreeNode root, int sum, int target, Map<Integer, Integer> map){
            if(root == null) return 0;
            sum += root.val;
            int res = map.getOrDefault(sum - target,0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
            res += dfs(root.left, sum, target, map ) + dfs(root.right, sum, target, map );
            map.put(sum, map.getOrDefault(sum, 0)-1);
            return res;
        }
    }
}
