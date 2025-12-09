package StackAndQueue;

class Queue{
    int size=10, currSize=0, start =-1,end =-1;
    int[] q = new int[size];

    public void push(int x){
        if(currSize==size) return;
        if(currSize==0){
            start=end=0;
        }else {
            end = (end + 1) % size;
        }
            q[end] = x;
            currSize++;

    }
    public int pop(){
        if(currSize==0){ return -1;}
        int el = q[start];
        if(currSize==1){
            start=-1;
            end=-1;
        }
        else{
            start=(start+1)%size;
        }
        currSize--;
        return el;
    }
    public int  peek(){
        if(currSize==0){ return -1;}
        return q[start];
    }
    public int size(){
        return currSize;
    }
    public boolean isEmpty(){
        return currSize==0;
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
    Queue q = new Queue();
    q.push(1);
    q.push(2);
    q.push(3);
        System.out.println(q.size());
        System.out.println(q.pop());
        System.out.println(q.isEmpty());
        q.push(12);
        System.out.println(q.pop());
    }
}
