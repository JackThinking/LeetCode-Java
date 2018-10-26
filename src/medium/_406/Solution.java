package medium._406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/18.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);//之后研究一下java语法的东西
        List<int[]> list = new LinkedList<>();
        /*
         * 这一步相当于插入排序，会自动把其他数挤下去的
         * */
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        /*
         * 这一部无非是把array变成数组
         * */
        int[][] res = new int[people.length][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
