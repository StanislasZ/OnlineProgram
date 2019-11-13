package com.stan.leetcode;

import java.util.*;

public class _690员工的重要性 {

    /**
     * bfs基本题
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) map.put(e.id, e);

        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        int res = 0;

        while (!queue.isEmpty()) {
            Employee top = queue.poll();
            res += top.importance;

            for (int e : top.subordinates) {
                queue.add(map.get(e));
            }
        }
        return res;

    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}