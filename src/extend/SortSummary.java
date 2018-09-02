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
        solution.mergeSort(test);
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

    /*
    * 6.归并排序（分治+合并）（将一个待排序的数组，分为两个有序的数组，然后将这两个有序数组合并为一个）
    * */
    public void mergeSort(int[] list){
        int len = list.length;
        int[] temp = new int[len];
        mergeSortImplementRecur(list, 0, len - 1, temp);
    }
    public void mergeSortImplementRecur(int[] list, int firstIndex, int lastIndex, int[] temp){
        if (firstIndex>=lastIndex){
            return;
        }//递归先确定结束条件
        int midIndex = (firstIndex+lastIndex)/2;
        mergeSortImplementRecur(list,firstIndex,midIndex,temp);
        mergeSortImplementRecur(list,midIndex+1,lastIndex,temp);
        mergeArray(list, firstIndex, midIndex, lastIndex, temp);
    }

    public void mergeArray(int[] list, int firstIndex, int midIndex, int lastIndex, int[] temp){//temp数组用来暂存数据
        int i = firstIndex;//左半边[firstIndex,midIndex]
        int n = midIndex;
        int j = midIndex+1;//右半边[midIndex+1,lastIndex]
        int m = lastIndex;
        int k = 0;//编织坐标
        while (i<=n && j<=m){//循环比较
           if (list[i]<list[j]){
               temp[k++] =list[i++];
           }else{
               temp[k++] =list[j++];
           }
        }
        //长度不一致的时候
        while (i<=n){
            temp[k++] = list[i++];
        }
        while (j<=m){
            temp[k++] = list[j++];
        }
        for (i = 0; i < k; i++) {//temp中保存的数据再复制回list中（这一步非常容易忘记）
            list[firstIndex + i] = temp[i];
        }
    }
    /*
    * 终于到O(nlogn)了，非常适合单链表的排序，因为合并能剩下很多标志位，关键步骤是设立中点，分分和，然后就是合并的写法有点难记
    * 还有就是其非递归的写法空间复杂度更好，详情见博客
    * */

    /*
    * 7.堆排序（将数组构建成最大堆后，去最大的，然后长度减一重新构建，王福循环）
    * */
    public void heapSort(int[] list) {
        int len = list.length;
        buildMaxHeap(list, len);//建立大顶堆
        for (int i = len; i > 0; i--) {
            swap(list, 0, i - 1);//交换后，i-1位置就每次为最大
            maxHeapAdjustDown(list, i - 1, 0);//每次交换后，就确定了排序的一个值，剩下有 i-1个元素待排
        }
    }

    /*
    * 次级基础函数：构建堆（len / 2 - 1是分界线，0到len / 2 - 1不是叶子节点，反之都是叶子节点）
    * */
    private void buildMaxHeap(int[] list, int len){//建立最大堆，利用堆维护算法
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeapAdjustDown(list, len, i);
        }
    }

    /*
    * 核心基础函数：堆维护
    * */
    private void maxHeapAdjustDown(int[] list, int len, int rootIndex){
        int temp = list[rootIndex];//根节点值保存下来
        int subIndex = 2*rootIndex+1;//由于是从0开始的，左节点与根节点关系是这样,subIndex代表左节点，subIndex+1代表右节点
        while(subIndex<len){
            if (subIndex+1<len && list[subIndex+1]>list[subIndex]){
                subIndex++;//左右节点比较
            }

            if (temp>list[subIndex]){//如果没有比根节点大的就取消
                break;
            }

            list[rootIndex] = list[subIndex];//有比根节点大的就不断的继续寻找
            rootIndex = subIndex;//subIndex是用来辅助定位的
            subIndex = rootIndex*2+1;//找到最后的rootIndex
        }
        list[rootIndex] = temp;//找到后替换之前的temp
    }
    

}

