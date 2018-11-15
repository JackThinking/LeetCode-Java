package hard._210;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Citrix on 2018/11/15.
 */
public class Review {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        int[] res = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, dp, i, stack)) {
                return new int[0];
            }
        }
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, boolean[] dp, int course, Stack<Integer> stack) {
        if (visited[course] == true) {
            return dp[course];
        } else {
            visited[course] = true;
        }
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, dp, (int) graph[course].get(i), stack)) {
                dp[course] = false;
                return false;
            }
        }
        stack.push(course);
        dp[course] = true;
        return true;
    }
}
