package com.danit;
import java.util.*;

public class Postfix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Stack<Integer> operands = new Stack<>();

        for (int i = 0; i < N; i++) {
            String element = in.next();
            if(element.equals("+")){
                operands.push(operands.pop() + operands.pop());
            } else if(element.equals("-")){
                int x = operands.pop();
                int y = operands.pop();
                operands.push(y - x);
            } else if(element.equals("*")) {
                operands.push(operands.pop() * operands.pop());
            } else {
                operands.push(Integer.parseInt(element));
            }


        }
        System.out.println(operands.pop());


    }
}
