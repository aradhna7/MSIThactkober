package com.Company.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10,4,11,0,-11};
        mergeSort(arr, 0, arr.length);


        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(ans));
    }

    static int[] merge(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int[] arr1 = merge(Arrays.copyOfRange(arr, 0, mid));
        int[] arr2 = merge(Arrays.copyOfRange(arr, mid, arr.length));

        int[] ans = new int[arr1.length+ arr2.length];

        int i=0,j=0,k = 0;
        while(i<arr1.length && j< arr2.length){
            if(arr1[i] < arr2[j]){
                ans[k] = arr1[i];
                i++;
                k++;
            }
            else{
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i<arr1.length){
            ans[k] = arr1[i];
            i++;
            k++;
        }

        while(j<arr2.length){
            ans[k] = arr2[j];
            k++;
            j++;
        }

        return ans;
    }

    static void mergeSort(int[] arr, int s, int e){
        if(e - s == 1){
            return;
        }

        int mid = s + (e-s)/2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);

        int[] mix = new int[e-s];

        int i = s;
        int j = mid;
        int k = 0;

        while(i < mid && j < e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
                k++;
            }

            else{
                mix[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i<mid){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j<e){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
}
