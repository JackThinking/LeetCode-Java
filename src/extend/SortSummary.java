package extend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/8/31.
 */
public class SortSummary {

    public static void main(String[] args) {
        int[] test = {2,1,4,5,8};
        SortSummary solution = new SortSummary();
        solution.bubblesort(test);
    }

    /*
    * 1.冒泡排序
    * */

    public void swap(int[] list, int i, int j){
        if (list == null || i >= list.length || j >= list.length) {
            System.out.println("a is null ,index out of bound");
            return;
        }
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    public void bubblesort(int[] list){
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length-1; j++) {
                if (list[j+1]<list[j]){
                    swap(list,j,j+1);
                }
            }
        }
    }
}

