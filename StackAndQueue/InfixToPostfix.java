package StackAndQueue;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String s = "a*(b+c)/d";
        String ans = solve(s);
        System.out.println(ans);
    }
    public static String solve(String s){
        String ans = "";
        int i=0;
        Stack<Character> st = new Stack<>();
        while(i<s.length()){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                ans += s.charAt(i);
            }
            else if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }else {
                while(!st.isEmpty() && priority(s.charAt(i)) <=  priority(st.peek()) ){
                    ans += st.pop();
                }
                st.push(s.charAt(i));
            }
            System.out.println(st);
            i++;
        }
        while(!st.isEmpty()){
            ans +=st.pop();
        }
        return ans;
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
