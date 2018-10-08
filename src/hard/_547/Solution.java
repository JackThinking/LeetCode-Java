package hard._547;

/**
 * Created by Citrix on 2018/10/8.
 */
/*
* 这道题的思路和前面的岛屿联通题还有怀绕地带有点像，找到一个起始点进行dfs，然后改值，后面只要判断没有被改的个数即可
* 但是这道题自己在思考的时候没有想到解决方法
* 这道题在遍历的时候还有很多多余的判断动作
* 使用的方法有点像接力棒的感觉
* 这道题同时也是一道典型的union find算法题，之后尝试一下union find的解法
* */
public class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
