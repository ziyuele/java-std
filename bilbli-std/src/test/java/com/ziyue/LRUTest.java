package com.ziyue;

import lombok.Data;

import java.util.HashMap;

public class LRUTest {


    private int size;
    private HashMap<String, Node> hashMap;
    private Node head;
    private Node end;

    @Data
    class Node{
        String key;
        int value;
        Node pre;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public LRUTest(int size) {
        this.size = size;
        this.hashMap = new HashMap<>(size);
    }

    public void set(String key, int value) {
        Node node = hashMap.get(key);
        if (null != node) { // 存在节点
            node.value = value;
            refreshNode(node);
        }
        // 节点不存在的情况
        // 1. 容量满了
        Node aNode = new Node(key, value);
        if(hashMap.size()>=size) {
            hashMap.remove(head.key);
            delNode(head);  // 删除头节点
            addNode(aNode); // 添加尾节点
        } else { // 2. 容量还没有满
           addNode(aNode);
        }
        hashMap.put(key, aNode);
    }

    public Integer get(String key) {
        if (!hashMap.containsKey(key)) {
            return null;
        }
        Node node = hashMap.get(key);
        refreshNode(node);
        return node.value;
    }

    private void refreshNode(Node rnode) {
        delNode(rnode);
        addNode(rnode);
    }

    private void delNode(Node dNode) {
        if (dNode == head && dNode == end) { // 就一个节点的场景
            head = null;
            end = null;
        } else if (dNode == head) { //  要删除的节点是头节点
            head = head.next;
            head.pre = null;
        } else if(dNode == end) { // 要删除的节点是尾节点
            end = end.pre;
            end.next = null;
        } else {  // 要删除的节点是中间节点
            dNode.pre.next = dNode.next;
            dNode.next.pre = dNode.pre;
        }
    }

    private void addNode(Node node) { // 节点的添加： 至从尾节点添加
       if (end != null) {
           end.next = node;
           node.pre = end;
           end = node;
       }
       end  = node;
       if (null == head) { // 如果各个节点当前都是空的
           head = node;
       }
    }

    public static void main(String[] args) {
        LRUTest lruTest = new LRUTest(3);
        lruTest.set("kangjian", 1);
        lruTest.set("111", 2);
        lruTest.set("222", 3);
        System.out.println(lruTest.get("kangjian"));
        lruTest.set("333", 5);
        System.out.println(lruTest.get("111"));
    }
}
