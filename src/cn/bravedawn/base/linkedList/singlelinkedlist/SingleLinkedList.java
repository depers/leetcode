package cn.bravedawn.base.linkedList.singlelinkedlist;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/1/25 10:57
 *
 * 采用头插法实现的链表（拼多多）
 */
public class SingleLinkedList<E> {

    /**
     * 链表涉及的操作
     * 1.添加
     * 2.删除指定位置的元素
     * 3.长度
     * 4.获取指定位置的元素
     */

    private Node<E> head;
    private int size;

    public SingleLinkedList() {
        this.head = new Node<>();
    }

    public int size() {
        return this.size;
    }

    /**
     * 添加节点
     */
    public void add(E item) {
        if (item == null) {
            return;
        }
        Node<E> node = new Node<>(item);
        node.setNext(head.getNext());
        head.setNext(node);
        size++;
    }

    /**
     * 删除节点
     */
    public void del(int index) {
        Node<E> node = getNode(index);
        if (node == null) {
            throw new IllegalArgumentException("该节点不存在");
        }
        Node<E> prevNode = getNode(index - 1);
        prevNode.setNext(node.getNext());
        size--;
    }

    /**
     * 获取节点
     */
    public E get(int index) {
        Node<E> node = getNode(index);
        if (node != null) {
            return node.getItem();
        } else {
            return null;
        }
    }


    private Node<E> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("下标地址必须大于0，小于链表大小");
        }

        Node<E> node = head.getNext();
        int i = 0;
        while (node != null) {
            if (i == index) {
                return node;
            }
            node = node.getNext();
            i++;
        }
        return null;
    }


    public void print() {
        Node<E> node = head.getNext();
        while (node != null) {
            System.out.print(node.getItem());
            node = node.getNext();
            if (node != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
