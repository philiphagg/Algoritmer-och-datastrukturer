//program that sors negative elements on low indices
//positive indexes on high indices

#include <stdio.h>


// prints the array
void print_array(int arr[],int n){
    for(int i = 0; i < n; i++){
        printf("%d, ", arr[i]);
    }
    printf("\n");
}
// function that sorts
void positive_negative_in_place(int arr[], int N){
    int i = 0;
    int j, current;

    while(i++ < N){
        current = arr[i];

        j = i - 1;
        while(current <= 0 && j >= 0 && arr[j] >= 0){
            arr[j+1] = arr[j];
            j--;

        }
        arr[j+1] = current;
    }

}


int main(){
    int arr[] = {-12, 11, -13, -5, 6, -7, 5, 0, -6};
    int N = sizeof(arr) / sizeof(int);
    print_array(arr,N);
    positive_negative_in_place(arr, N);
    print_array(arr, N);

return 0;
}