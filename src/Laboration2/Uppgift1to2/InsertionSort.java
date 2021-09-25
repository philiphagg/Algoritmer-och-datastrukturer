package Laboration2.Uppgift1to2;

public class InsertionSort {
    private int swaps;

    public static void main(String[] args) {
        int arr[] = {5,4,3,6,8,11,31,14,19};
        int N = arr.length;
        //show(arr);
        sort(arr,N);
        show(arr);
    }

    public static void sort(int[] arr, int N){

        for(int i = 1; i < N; i++){
            for(int j = i; j > 0 && arr[j] < arr[j-1]; j--){
                swap(arr,j,j-1);
                show(arr);

            }
        }

    }

    private static void swap(int[] arr, int j, int i) {
        int placeHolder = arr[i];
        arr[i] = arr[j];
        arr[j] = placeHolder;

    }
    private void swapCounter(){
        swaps++;
    }

    public int getSwaps() {
        return swaps;
    }

    private static void show(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print("["+arr[i]+"]");
        }
        System.out.println();
    }


}
