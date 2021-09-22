#include <stdio.h>



void print_array(int arr[],int n){
    for(int i = 0; i < n; i++){
        printf("%d, ", arr[i]);
    }
    printf("\n");
}

void positive_negative_in_place(int arr[], int N){
    int i = 0;
    int j, key;

    while(i++ < N){
        key = arr[i];

        j = i - 1;
        while(key < 0 && j >= 0 && arr[j] > 0){
            arr[j+1] = arr[j];
            j--;

        }
        arr[j+1] = key;
    }

}


int main(){
    int arr[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
    int N = sizeof(arr) / sizeof(int);
    print_array(arr,N);
    positive_negative_in_place(arr, N);
    print_array(arr, N);

return 0;
}