package cn.bravedawn.base.linkedList.singlelinkedlist;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/1/25 10:47
 */
public class Node<T> {

    private T item;
    private Node next;

    public Node() {

    }

    public Node(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
