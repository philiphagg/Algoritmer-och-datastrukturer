#include <stdio.h>
void sort(int*, int);
void swap(int*, int, int);
void show(int*, int);
void get_inv_count(int arr[], int);
void reverse_array(int arr[], int);

int swaps;
// program responsible for reversing an array with 2n extra time.
// Main function that drives the program
int main(){
    int arr[] ={1,2,5,3,4,0};
    int N = sizeof(arr)/sizeof(int);
    get_inv_count(arr,N);

    sort(arr,N);
    printf("\n number of swaps: %d", swaps);
    printf("\n");
    reverse_array(arr, N);

    printf("reversed array: ");
    for(int i = 0; i < N; i++){
        printf("[%d]", arr[i]);
    }
    printf("\n");

    return 0;
}

// Function that implements insertion sort
void sort(int arr[], int N){
    int swaps = 0;
    for(int i = 1; i < N; i++){
        for(int j = i; j > 0 && arr[j] < arr[j-1];j--){
            swap(arr, j, j-1);
            show(arr, N);
        }
    }
}
// Function that swaps elements
void swap(int arr[], int j, int i){
    int placeHoder = arr[i];
    arr[i] = arr[j];
    arr[j] = placeHoder;
    swaps++;
}

//Time complexity n^2
//Function that count inversions
void get_inv_count(int arr[], int N){
    int inversions = 0;
    for(int i = 0; i < N -1; i++){
        for(int j = i + 1; j < N; j++){
            if(arr[i] > arr[j]){
                inversions++;
                printf("[[%d,%d],[%d,%d]]", i,arr[i], j,arr[j]);
            }
        }
    }
    printf("\nNumber of inversions: %d\n", inversions);
}
//Prints the array
void show(int arr[], int N){
    for(int i = 0; i < N; i++){
        printf("[%d]", arr[i]);
    }
    printf("\n");
}

// Reverses the array
void reverse_array(int arr[], int N){
    int i = 0;
    int j = N - 1;
    int temporary_value;

    for(int i = 0; i < N; i++){
        arr[i] *= -1;
    }

    sort(arr, N);

    for(int i = 0; i < N; i++){
        arr[i] *= -1;
    }
}