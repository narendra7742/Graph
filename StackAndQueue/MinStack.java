package StackAndQueue;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStacks s = new MinStacks();

        // Function calls
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.print(s.getMin() + " ");
        s.pop();
        System.out.print(s.top() + " ");
        s.pop();
        System.out.print(s.getMin());
    }
}


class MinStacks {
    Stack<Pair> st ;
    public MinStacks() {
        st  = new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()) st.push(new Pair(val, val));
        else{
            st.push(new Pair(val, Math.min(val, st.peek().second)));
        }
    }

    public void pop() {
        Pair p = st.pop();
        // p.first;
    }

    public int top() {
        Pair p = st.peek();
        return  p.first;
    }

    public int getMin() {
        Pair p = st.peek();
        return p.second;
    }
}

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}