package StackAndQueue;


import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String s = "a*(b+c)/d";
        String ans = solve(s);
        System.out.println(ans);
    }
    public static String solve(String s){
        StringBuilder sb = new StringBuilder("");
//        sb.reverse();
        char[] arr = s.toCharArray();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]=='('){
                arr[i]=')';
                sb.append(arr[i]);
            }else if(arr[i]==')'){
                arr[i]='(';
                sb.append(arr[i]);
            }else{
                sb.append(arr[i]);
            }
        }
        
        int i=0; String ans = "";
        Stack<Character> stack = new Stack<>();
        while(i<s.length()){
            if((sb.charAt(i)>='A' && sb.charAt(i)<='Z') || (sb.charAt(i)>='a' && sb.charAt(i)<='z') || (sb.charAt(i)>='0' && sb.charAt(i)<='9')){
                ans += sb.charAt(i);
            } else if (sb.charAt(i)=='(') {
                stack.push(sb.charAt(i));
            }else if (sb.charAt(i)==')') {
                while (!stack.isEmpty() && stack.peek()!='('){
                    ans += stack.pop();
                }
                stack.pop();
            }else{
                if(sb.charAt(i)=='^'){
                    while(!stack.isEmpty() && (priority(stack.peek()) >= priority(sb.charAt(i)))){
                        ans += stack.pop();
                    }
                }else{
                    while(!stack.isEmpty() && (priority(stack.peek()) > priority(sb.charAt(i)))){
                        ans += stack.pop();
                    }

                    System.out.println(stack);
                }
                stack.push(sb.charAt(i));

            }
            i++;
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }

StringBuilder ansb = new StringBuilder(ans);
        return ansb.reverse().toString();
    }
    public static int priority(char c){
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
}
