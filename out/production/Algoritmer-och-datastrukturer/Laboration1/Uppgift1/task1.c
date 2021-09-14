#include <stdio.h>
#include <stdlib.h>



/*
First we add all of the characters onto the stac in decending order
when we use putchar function. We will unload the stack from top to bottom
wich will create the effect of "reversing" the string.

getchar will increment itself. First getchar will fetch a byte stream
and then increment to the next. */

void recursiveMethod(){ 
    char ch;
    
    if((ch = getchar()) != '\n'){
        recursiveMethod();
    }
    putchar(ch);
}
/*
iterative method that reverses user input
*/
void iterativeMethod(){
    char *ch = (char*) malloc(100*sizeof(char));
    char string = 0;
    int i = 0;

    while(string != '\n'){
        string = getchar();
        *ch = string;
        ch++;
        i++;
    }
    while(i >= 0){
        putchar(*ch);
        ch--;
        i--;
    }
        

}

int main(){
    printf("Enter some characters: \n");
    //recursiveMethod();
    iterativeMethod();

    return 0;
}