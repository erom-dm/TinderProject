package basic.stask_queue;

import java.util.*;

public class BracketValidation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] brackets = in.nextLine().toCharArray();

        boolean valid = true;
        Stack<Character> openBr = new Stack<>();
        for (int i = 0; i < brackets.length; i++) {
            char temp = brackets[i];
            if(temp == '(' || temp == '{' || temp == '[') {
                openBr.push(brackets[i]);
            }else {
                if(openBr.isEmpty()){
                    valid = false;
                    break;
                }
                if((openBr.peek() == '(' && temp == ')')
                        || (openBr.peek() == '{' && temp == '}')
                        || (openBr.peek() == '[' && temp == ']')){

                    openBr.pop();
                }else{
                    valid = false;
                    break;
                }
            }
        }

        if(valid && openBr.isEmpty()){
            System.out.println("is correct");
        }else {
            System.out.println("isn't correct");
        }
    }

}
