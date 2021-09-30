#include <stdio.h>
#include <ctype.h>


// program that reads a file and removes all characters
// that are nog alphabetic or numbers
int main(){

        //Creates a pointers that will point to file paths.
        FILE *input_file;
        FILE *output_file;

        // opens file to the reference
        input_file = fopen("project-gutenberg.txt", "r");
        output_file = fopen("polished-gutenberg.txt","w");


        char ch;
        //loops while whe are nog at the end of file
        while((ch = fgetc(input_file)) != EOF){
            //checks if character true for isAlpha function
            if(isalpha(ch)|| ch == '\n')
                fputc(ch, output_file);
            else
                fputc(32,output_file);
        }
        //close files
        fclose(input_file);
        fclose(output_file);

    return 0;

}