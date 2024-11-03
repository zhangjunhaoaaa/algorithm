package code15_Greedy2_UnionFind;


import java.util.HashMap;
import java.util.Stack;

/// 并查集（Union-Find）是一种数据结构，主要用于处理动态连通性问题。它支持两种基本操作：
///
/// 查找（Find）：确定某个元素属于哪个集合。
/// 合并（Union）：将两个集合合并为一个集合。
public class Code05_UnionFind {


    /*只是包装一层*/
    public static class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }

    public static class UnionSet<V> {

        /// V 对应的代表节点 「V是 V，Node<V>是V包装了一层，并不是V」
        public HashMap<V, Node<V>> nodes;
        /// 各个集合的代表节点「最后的父亲节点就是代表节点」
        public HashMap<Node<V>, Node<V>> parents;
        /// 集合中元素的个数  Node<V>指的是代表节点
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(V[] values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                Node<V> node = new Node<>(values[i]);
                nodes.put(values[i], node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }


        /*
         * 给你一个节点，返回该节点的最后父节点「代表节点」
         * */
        public Node<V> findFather(Node<V> node) {
            Stack<Node<V>> stack = new Stack<>();
            while (node != parents.get(node)) {
                stack.push(node);//入栈
                node = parents.get(node);
            }
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), node);//出栈，并重新指定代表节点，优化「将一条长的链结构变的扁平」
            }
            return node;
        }


        //如果两个节点的代表节点不是同一个，就不在同一个集合中
        public boolean isSameSet(V a, V b) {
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }


        //合并两个集合
        public void union(V a, V b) {
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                //大小集合重定向
                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                //小集合的头部父类只想大集合
                parents.put(small, big);
                //现在大集合的元素为：aSetSize+bSetSize
                sizeMap.put(big, aSetSize + bSetSize);
                //删除小集合
                sizeMap.remove(small);
            }
        }


    }

}
