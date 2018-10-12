package hard._207;

import java.util.ArrayList;

/**
 * Created by Citrix on 2018/10/8.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i, dp)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp) {
        if (visited[course] == true) {
            return dp[course];
        } else {
            visited[course] = true;
        }
        for (int j = 0; j < graph[course].size(); j++) {
            if (!dfs(graph, visited, (int)graph[course].get(j), dp)) {
                dp[course] = false;
                return false;
            }
        }

        dp[course] = true;
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int course = 3;
        int[][] prerequisites = {{1,0},{2,1}};
        System.out.println(solution.canFinish(course,prerequisites));
    }
}