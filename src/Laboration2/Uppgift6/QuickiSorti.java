package Laboration2.Uppgift6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickiSorti {
        private static int PARTITION;
        private static boolean sorted;
        private static long time;

    public static void main(String[] args) throws IOException {


        int[] numbers = scanFile();

        long start = System.currentTimeMillis();
        quicksort(numbers);
        long end = System.currentTimeMillis();
        sorted = isSorted(numbers,0,numbers.length-1);
        time = end-start;
        System.out.println("array is sorted? :" +sorted);
        System.out.println(time);
    }
    /*
    public static void quicksortMedian(int[]arr){
        quicksortMedian(arr, 0,arr.length -1);
    }

    private static void quicksortMedian(int[] arr, int left, int right){
        int n = right-left + 1;
        if(left >= right) return;
        int key = findMedian(arr,left, left +n/2, right);
        swap(arr, key,left);

        int index = partition(arr,left,right,key);
        quicksortMedian(arr,left,index-1);
        quicksortMedian(arr,index+1,right);

    }

    private static int findMedian(int[] arr, int left, int mid, int right){

        if ((arr[left] < arr[mid] && arr[mid] < arr[right]) || (arr[right] < arr[mid] && arr[mid] < arr[left]))
            return arr[mid];
        else if ((arr[mid] < arr[left] && arr[left] < arr[right]) || (arr[right] < arr[left] && arr[left] < arr[mid]))
            return arr[left];
        else
            return arr[right];
    }
*/


    /*
    private static int findMedian(int[] arr, int low, int mid, int high){
        int value = biggest(arr[low],arr[mid],arr[high]);
        if(value == arr[low])   return bigger(arr[mid],arr[high]);
        if(value == arr[mid])   return bigger(arr[low],arr[high]);
        else                    return bigger(arr[low],arr[mid]);

    }
    private static int biggest(int low, int mid, int high){
        return bigger(low,bigger(mid,high));

    }
    private static int bigger(int a, int b){
        if (a > b) return a;
        else return b;
    }*/

    /*
    private static int findMedian(int[] arr,int low, int mid, int high){
        if((arr[low] > arr[mid]) ^ (arr[low] > arr[high]))
            return arr[low];
        else if((arr[mid] < arr[low]) ^ (arr[mid] < arr[high]))
            return arr[mid];
        else
            return arr[high];
    }*/


    public static void quicksort(int[] arr){

        quicksort(arr, 0, arr.length -1);
    }
    private static void quicksort(int[] arr, int left, int right){
        if(left >= right) return;
        int key = arr[(left + right) / 2];

        int index = partition(arr,left,right,key);
        quicksort(arr,left,index - 1);
        quicksort(arr,index,right);
    }
    private static int partition(int[] arr, int left, int right, int key){

        while(left <= right){
            while(arr[left] < key)
                left++;
            while(arr[right] > key)
                right--;
            if(left <= right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        Integer swap = arr[left];
        arr[left] = arr[right];
        arr[right] = swap;
    }
    private static boolean isSorted(int[] a, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }
    private static int[] scanFile() throws FileNotFoundException {
        String filePath = "src/InputFiles/inputfile1000.txt";
        Scanner in = new Scanner(new FileReader(filePath));
        int size = Integer.parseInt(in.nextLine());
        int[] numbers = new int[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();
        return numbers;
    }

}
