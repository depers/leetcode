package cn.bravedawn.zd.zd_155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/8 11:27
 *
 * 155.最小栈
 */
public class MinStack {

    // 实际记录数字的栈
    private Deque<Integer> stack;
    // 与栈的元素同步入栈，记录加入该值之后，最小的值同步加到这个栈中
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        // 关键点
        minStack.push(Integer.MAX_VALUE);
    }

    // 保持同进同出
    public void push(int val) {
        stack.push(val);
        // 关键点
        minStack.push(Math.min(val, minStack.peek()));
    }

    // 保持同进同出
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
