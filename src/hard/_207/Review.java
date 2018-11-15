package hard._207;

import java.util.ArrayList;

/**
 * Created by Citrix on 2018/11/14.
 */
public class Review {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
         * 首先把连接改成和书上一样的邻接状态表,这边就没有搞对，哎
         * */
        ArrayList[] graph = new ArrayList[numCourses];
        int n = prerequisites.length;
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, dp, i)) {
                return false;
            }
        }
        return true;
    }

    /*
     * dfs函数的熟练程度
     * */
    /*
     * 这种读取是有单向性的
     * */
    private boolean dfs(ArrayList[] graph, boolean[] visited, boolean[] dp, int course) {
        if (visited[course] == true) {
            return dp[course];
        } else {
            visited[course] = true;
        }
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, dp, (int) graph[course].get(i))) {
                dp[course] = false;
                return false;
            }
        }
        dp[course] = true;
        return true;
    }
}
