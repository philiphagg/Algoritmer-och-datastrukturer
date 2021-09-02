package Laboration1.Uppgift2;
import java.util.Scanner;


class ReverseString {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = scanner.nextLine();
        //String s = "Hej detta är en sträng";

        for(int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
        }
        //iterativeMethod(stack);
        recursiveMethod(stack);
    }
    public static void iterativeMethod(Stack stack){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append('[');
            sb.append(stack.pop());
            sb.append("], ");
        }
        System.out.println(sb);
    }
    public static void recursiveMethod(Stack stack){
        StringBuilder sb = new StringBuilder();
        if(!stack.isEmpty()){
            sb.append('[');
            sb.append(stack.pop());
            sb.append("], ");
            System.out.print(sb);
            recursiveMethod(stack);
        }
    }
}

