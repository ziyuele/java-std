package com.kangjian.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> datMap;

    private ListNode listNode;
    private  int capacity;
    LRUCache(int capacity) {
        this.datMap = new HashMap<>();
        this.listNode = new ListNode();
        this.capacity = capacity;
    }

    int get(int key) {
        if (!datMap.containsKey(key)) {
            return -1;
        }
        Node node = datMap.get(key);
        int val = node.val;
        put(node.key, node.val);
        return val;
    }

    void put(int key, int value) {
        if (datMap.containsKey(key)) {
            listNode.remove(datMap.get(key));
        }
        if (datMap.size() >= capacity) {
            datMap.remove(listNode.deleteLast());
        }
        listNode.adddFirst(new Node(key, value));
    }

    class Node {
       int val;

       int key;
       Node pre;
       Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    class ListNode {

        Node head;
        Node last;

        private void adddFirst(Node node) {
            if (null == head) {
               head = node;
               head.pre = head;
               head.next = head;
            } else {
                head.pre = node;
                node.next = head;
                node.pre = last;
            }
            head = node;
        }

        public void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;

        }

        private int deleteLast() {
            int key = last.key;
            last = last.pre;
            last.next = null;
            return key;
        }
    }
}
