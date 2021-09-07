package Laboration1.Uppgift7;

//TODO calculate memory and time complexity for the algorithm
public class CheckParentheses {
    int i;
    int j;
    int k;

    public CheckParentheses() {
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    public boolean countInput(String s){
        for(int counter = 0; counter < s.length(); counter++){
            if(s.charAt(counter) == 40 || s.charAt(counter) == 41)
                this.i++;
            if(s.charAt(counter) == 91 || s.charAt(counter) == 93)
                this.j++;
            if(s.charAt(counter) == 123 || s.charAt(counter) == 125)
                this.k++;
        }
        return isEven();
    }
    public boolean isEven (){
        return (i & 1) == 0 && (j & 1) == 0 && (k & 1) == 0;
    }
}
