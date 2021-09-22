#include <stdio.h>
void sort(int*, int);
void swap(int*, int, int);
void show(int*, int);
void get_inv_count(int arr[], int);

int swaps;

int main(){
    int arr[] ={1,2,5,3,4,0};
    int N = sizeof(arr)/sizeof(int);
    get_inv_count(arr,N);

    sort(arr,N);
    printf("\n number of swaps: %d", swaps);
    printf("\n");

    return 0;
}

//timecomplexity n(n-1)/2
void sort(int arr[], int N){
    int swaps = 0;
    for(int i = 1; i < N; i++){
        for(int j = i; j > 0 && arr[j] < arr[j-1];j--){
            swap(arr, j, j-1);
            show(arr, N);
        }
    }
}

void swap(int arr[], int j, int i){
    int placeHoder = arr[i];
    arr[i] = arr[j];
    arr[j] = placeHoder;
    swaps++;
}

//Time complexity n^2 
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

void show(int arr[], int N){
    for(int i = 0; i < N; i++){
        printf("[%d]", arr[i]);
    }
    printf("\n");
}

