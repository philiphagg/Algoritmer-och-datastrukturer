
// Small program that implements insertions sort
// and has a function that counts and shows
// # inversions and the actual inversions

#include <stdio.h>
void sort(int*, int);
void swap(int*, int, int);
void show(int*, int);
void get_inv_count(int arr[], int);

int swaps;

int main(){
    //int arr[] ={1,2,5,3,4,0};
    //int N = sizeof(arr)/sizeof(int);
    int N;

    printf("Enter size of array: ");
    scanf("%d",&N);
    int arr[N];
    int i = 0;

    while(i++ < N){
        printf("Enter value %d: ", i);
        scanf("%d", &arr[i-1]);
    }
    get_inv_count(arr,N);
    sort(arr,N);
    printf("\n number of swaps: %d", swaps);
    printf("\n");

    return 0;
}

//spacecomplexity n(n-1)/2 time complexity (n^2)
//implementation of insertion sort
void sort(int arr[], int N){
    int swaps = 0;
    for(int i = 1; i < N; i++){
        for(int j = i; j > 0 && arr[j] < arr[j-1]; j--){
            swap(arr, j, j-1);
            show(arr, N);
        }
    }
}

// swaps given elements
void swap(int arr[], int j, int i){
    int placeHoder = arr[i];
    arr[i] = arr[j];
    arr[j] = placeHoder;
    swaps++;
}

//Time complexity (n^2)/2
//counts and prints inversions
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

// function that prints and array
void show(int arr[], int N){
    for(int i = 0; i < N; i++){
        printf("[%d]", arr[i]);
    }
    printf("\n");
}

