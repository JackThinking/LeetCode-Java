package extend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/8/31.
 */
public class SortSummary {

    public static void main(String[] args) {
        int[] test = {5,4,1,3,2};
        SortSummary solution = new SortSummary();
        solution.shellSort(test);
    }

    /*
    * 1.冒泡排序(每次把最大的一个数放到最后面，故每次循环次数递减)
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
        for (int i = list.length; i > 1; i--) {
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
    * 2.冒泡排序改良版(设立一个哨兵记录之前交换的坐标，减少遍历数)
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

    /*
    * 3.选择排序(之前的冒泡是每次确定最后一次，这个是每次确定开头的一个)
    * */
    public void selectSortOpt(int[] list){

        int len = list.length;
        for (int i = 0; i < len; i++) {
            int minindex = i;
            for (int j = i+1; j < len; j++) {
                if (list[j]<list[minindex]){
                    minindex = j;
                }
            }
            if (i!=minindex){
                swap(list,i,minindex);
            }
        }
    }
    /*
    * 感觉不出选择排序相对于冒泡改良版的优势所在，而且还不稳定（稳定的概念见博客）
    * */

    /*
    * 4.插入排序(每次保持前面的都有序的，后来的加入后判断移位到所属的位置)
    * */

    public void insertSort(int[] list){
        int len = list.length;
        for (int i = 1; i < len; i++) {
            if (list[i]<list[i-1]){
                int temp = list[i];
                int j;
                for (j = i-1; j >= 0 && temp<list[j]; j--) {
                    list[j+1] = list[j];
                }
                list[j+1] = temp;//这一步是没问题的，因为i最小取到了-1
            }
        }
    }

    /*
    * 其一般复杂度还是没有改进O(n^2)，但是在有序的情况下，最佳的复杂度提示到O(n)
    * */

    /*
    * 5.希尔排序（在插入排序的基础上加入步进的概念，提示一定的性能）
    * */

    public void shellSort(int[] list){
        int len = list.length;
        for (int step = len/2; step >0 ; step/=2) {
            for (int i = step; i < len; i++) {//这边的确是i++
                if (list[i]<list[i-step]){
                    int temp = list[i];
                    int j;
                    for (j = i-step; j >= 0 && temp<list[j]; j-=step) {
                        list[j+step] = list[j];
                    }
                    list[j+step] = temp;//
                }
            }
        }
    }
    /*
    * 换汤不换药，本质没有得到提升
    * */

}

