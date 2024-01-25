package cn.bravedawn.base.linkedList.singlelinkedlist;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/1/25 11:59
 */
public class Test {


    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("hello");
        list.add("world");
        list.add("你好");
        list.add("中国");
        System.out.print("打印元素：");
        list.print();

        System.out.println("链表大小：" + list.size());

        System.out.print("输出第一个元素：");
        System.out.print(list.get(1));
        System.out.println();

        System.out.print("删除一个元素：");
        list.del(2);
        list.print();
    }
}
