package Solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Sort {
    public void bubbleSort(int[] arr) {
        if(arr.length <= 1) return;
        int temp;
        for(int i = 1; i <= arr.length; i++) {
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序，在出现多个重复数字时有bug
     * @param arr 待排序数组
     */
    public void quickSort(int[] arr) {
        if(arr.length <= 1) return;
        partition(arr, 0, arr.length - 1);
    }

    private void partition(int[] arr, int l, int h) {
        if(h - l <= 1) return;

        int pivot = arr[l], left = l, right = h;
        while(l < h) {
            while(l < h && arr[h] >= pivot) h--;
            arr[l] = arr[h];
            if(l < h) l++;
            while(l < h && arr[l] < pivot) l++;
            arr[h] = arr[l];
            if(l < h) h--;
        }

        arr[l] = pivot;
        partition(arr, left, l - 1);
        partition(arr, l + 1, right);
    }

    public void mergeSort(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    private void merge(int[] arr, int l, int h) {
        if(l >= h) return;

        int mid = (l + h) / 2;
        int i = l, j = mid + 1, k = 0;
        merge(arr, l, mid);
        merge(arr, mid + 1, h);
        int[] temp = new int[h - l + 1];

        while(i <= mid && j <= h)
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        while(i <= mid)
            temp[k++] = arr[i++];
        while(j <= h)
            temp[k++] = arr[j++];
        for(i = 0; i < temp.length; i++)
            arr[l + i] = temp[i];
    }

    @Test
    public void bubbleSortTest() {
        int[] arr = {4, 1, 2, 5, 0, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void mergeSortTest() {
        int[] arr = {4, 1, 2, 5, 0, 3, 9, 7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
