package cn.bravedawn.zd.zd_208;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/5/30 08:49
 * @apiNote 208.实现 Trie (前缀树)
 * @see <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/solutions/98390/trie-tree-de-shi-xian-gua-he-chu-xue-zhe-by-huwt/?envType=problem-list-v2&envId=2cktkvj">Trie Tree 的实现 (适合初学者)</a>
 */
public class Trie {

    private Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.next[word.charAt(i) - 'a'] == null) {
                cur.next[word.charAt(i) - 'a'] = new Node();
            }
            cur = cur.next[word.charAt(i) - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.next[word.charAt(i) - 'a'] != null) {
                cur = cur.next[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return cur.isEnd;
    }

    public boolean startsWith(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.next[word.charAt(i) - 'a'] != null) {
                cur = cur.next[word.charAt(i) - 'a'];
            }
            else {
                return false;
            }
        }
        return true;
    }

    class Node {
        Node[] next; //字母映射表
        boolean isEnd = false; //该结点是否是一个串的结束

        public Node() {
            next = new Node[26];
        }

    }

}
