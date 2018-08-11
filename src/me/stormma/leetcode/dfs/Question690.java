package me.stormma.leetcode.dfs;

import java.util.List;

/**
 * 难度系数: 1星(很水)
 * leetcode 690.Employee importance <a href="">题目链接</a>
 *
 * @author stormma
 * @date 2017/10/21
 */
public class Question690 {

    class Employee {
        /** It's the unique id of each node;*/
        int id;
        /** the importance value of this employee*/
        int importance;
        /** the id of direct subordinates*/
        List<Integer> subordinates;
    }

    static class Solution {
        private int dfs(List<Employee> employees, int id, int value) {
            if (employees == null || employees.size() == 0) {
                return 0;
            }
            Employee employee = null;
            for (Employee e : employees) {
                if (e.id == id) {
                    employee = e;
                }
            }
            if (employee == null) {
                return 0;
            }
            value += employee.importance;
            if (employee.subordinates == null || employee.subordinates.size() == 0) {
                return value;
            }
            for (Integer subId : employee.subordinates) {
                value = dfs(employees, subId, value);
            }
            return value;
        }

        public int getImportance(List<Employee> employees, int id) {
            return dfs(employees, id, 0);
        }
    }
}
