package StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {6,0,8,1,3};
        List<Integer> ans = nextGreaterElement(arr, arr.length);
        System.out.println(ans);
    }
    public static List<Integer> nextGreaterElement(int[] arr, int n){
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(-1);
            }else{
                ans.add(st.peek()) ;
            }
            st.push(arr[i]);
        }
        return ans.reversed();
    }
}
