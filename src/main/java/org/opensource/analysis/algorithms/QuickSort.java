package org.opensource.analysis.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickSort {

    public static final Logger logger = LoggerFactory.getLogger(QuickSort.class);

    public static void main(String[] args) {
        int[] arr = {8, 3, 7, 9, 12, 6, 11, 4, 2};
        int[] arr1 = {8, 9, 2};
        int[] arr2 = {8, 2, 9};
        int[] arr3 = {8, 9};
        int[] arr4 = {8, 2};
        int[] arr5 = {8};
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(arr);
        logger.info("final sort:{}", arr);

        quickSort.quicksort(arr1);
        logger.info("final sort:{}", arr1);

        quickSort.quicksort(arr2);
        logger.info("final sort:{}", arr2);

        quickSort.quicksort(arr3);
        logger.info("final sort:{}", arr3);

        quickSort.quicksort(arr4);
        logger.info("final sort:{}", arr4);

        quickSort.quicksort(arr5);
        logger.info("final sort:{}", arr5);

    }

    private void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        if (length(start, end) == 1) {
            return;
        }
        if (length(start, end) == 2) {
            if (arr[end] > arr[start]) {
                swap(arr, start, end);
            }
            return;
        }
        int partition = partition(arr, start, end);//divide
        quicksort(arr, start, partition);//recursive divide
        quicksort(arr, partition + 1, end);//recursive divide
    }

    private int length(int start, int end) {
        return end - start + 1;
    }


    //从大到小排序
    //临界考虑
    //8 2 9  => swap: 8 9 2(right,left) =>cycle 8 9(right) 2(left) no proceed swap
    //8 9 2  => cycle 8 9(left,right) 2
    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;
        outer:
        while (left < right) {
            while (arr[right] < pivot) {
                --right;
                if (right <= start) {
                    break outer;
                }
            }

            swap(arr, right, left);
            ++left;
        }
        swap(arr, start, right);
        return right;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
