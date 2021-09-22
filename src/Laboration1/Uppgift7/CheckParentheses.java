package Laboration1.Uppgift7;


import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;

/**
 * Time complexity for the worst case: n
 * Memory complexity for for the worst case n/2
 */
public class CheckParentheses {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        /*
        Scanner s = new Scanner(System.in);
        String parentheses = s.nextLine();
        */
        String parentheses = "()()";
        System.out.println(check(parentheses));

    }

    /**
     * checks praenthesis are balanced
     * @param string string thas shall be checked
     * @return if paranthesis are balanced
     */
    public static boolean check(String string){
        Stack<Character> stack = new Stack<Character>();
        char ch = 0;
        if(empty(string) || oddLength(string))
            return false;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '(' || string.charAt(i) == '[' || string.charAt(i) == '{')
                stack.push(string.charAt(i));
            else{ // här kan vi byta till continue
                if(!stack.isEmpty())
                    ch = stack.pop();
                if((        (ch == '(' && string.charAt(i) == ')')
                        || (ch == '[' && string.charAt(i) == ']')
                        || (ch == '{' && string.charAt(i) == '}'))){
                    ch = 0;
                    continue;
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean oddLength(String string) {
        return string.length() % 2 != 0;
    }

    private static boolean empty(String string) {
        return string == "";
    }


}
