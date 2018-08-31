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
        solution.bubbleSortOpt(test);
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
    public void bubbleSort(int[] list){
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length-1; j++) {
                if (list[j+1]<list[j]){
                    swap(list,j,j+1);
                }
            }
        }
    }
    /*
    * 复杂度O(n^2),当序列整体较为有序时，产生很多没必要的操作
    * */

    /*
    * 2.冒泡排序改良版
    * */
    public void bubbleSortOpt(int[] list){
        int rightside = list.length;//右边界，运算需要
        int guard = rightside;//动态小哨兵，用来动态记录最后一次交换的坐标
        while(guard>0){
            rightside = guard;//右边界去上一次哨兵坐标
            guard = 0;//哨兵默认为0
            for (int i = 1; i < rightside; i++) {
                if (list[i-1]>list[i]){
                    swap(list,i-1,i);
                    guard = i;//随着记录发生而记录
                }
            }
        }
    }
    /*
    * 这种做法进行了剪枝，减少了不必要的比较，在最好的情况下（已经有序），可以变为O(n)
    * */
}

