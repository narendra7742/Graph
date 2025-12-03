package StackAndQueue;
 class StackImplementation{
    int top =-1;
    int[] stack = new int[10];
    public void push(int x){
        if(top>=10) return ;
        top = top+1;
        stack[top] = x;
    }
    public void pop(){
        if(top==-1) return ;
        top = top-1;
//        return stack[top];
    }
    public int peek(){
        if(top==-1) return -1;
        return stack[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public int size(){
        return top+1;
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
    StackImplementation s = new StackImplementation();
    s.push(1);
    s.push(2);
        System.out.println(s.size());
        s.push(3);
        s.push(4);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }
}
