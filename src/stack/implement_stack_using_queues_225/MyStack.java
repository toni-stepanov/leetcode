package stack.implement_stack_using_queues_225;

import java.util.LinkedList;
import java.util.Queue;

/*
225. Implement Stack using Queues
https://leetcode.com/problems/implement-stack-using-queues/

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back,
 peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively.
You may simulate a queue by using a list or deque (double-ended queue),
 as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top
operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
*/
class MyStack {
    Queue<Integer> list = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.offer(x);
        // put front elements of queue at the back, thus making it a stack
        for (int i=1; i<list.size(); i++) {
            list.offer(list.poll());

        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.poll();
    }

    /** Get the top element. */
    public int top() {
        return list.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}