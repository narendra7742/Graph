package StackAndQueue;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String s = "[{}()]";
        boolean ans = isBalanced(s);
        System.out.println(ans);
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
                System.out.println("-"+c);
            }else{
                if(stack.isEmpty()){ return false;}
                char pop = stack.peek();
                System.out.println(pop+"_"+c);
                if((c==')'&&pop=='(') || (c==']'&&pop=='[') || (c=='}'&&pop=='{')){
//                    System.out.println(stack.peek());
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
//        System.out.println(stack);
        return stack.isEmpty();
    }
}
