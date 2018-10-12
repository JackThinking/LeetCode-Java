package hard._210;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Citrix on 2018/10/12.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        int[] order = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i, dp, stack)) {
                return new int[0];
            }
        }
        for (int i = 0; i < numCourses; i++) {
            order[i] = stack.pop();
        }
        return order;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp, Stack<Integer> stack) {
        if (visited[course] == true) {
            return dp[course];
        } else {
            visited[course] = true;
        }
        for (int j = 0; j < graph[course].size(); j++) {
            if (!dfs(graph, visited, (int) graph[course].get(j), dp, stack)) {
                dp[course] = false;
                return false;
            }
        }
        dp[course] = true;
        stack.push(course);
        return true;
    }
}
