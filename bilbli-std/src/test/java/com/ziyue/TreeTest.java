package com.ziyue;

import lombok.Data;
import org.junit.Test;

import java.util.*;

public class TreeTest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    private TreeNode buildTreeNode() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.right = treeNode6;

        treeNode4.right = treeNode8;

        return treeNode1;
    }

    @Test
    public void doTest() {
        printTreeNodeA(buildTreeNode());
        System.out.println();
        printTreeNodeB(buildTreeNode());
        System.out.println();
        printTreeNodeC(buildTreeNode());
        System.out.println();
        //printTreeNodeD(buildTreeNode());
        System.out.println();
        printTreeNodeE(buildTreeNode());
        System.out.println();
        printTreeNodeF(buildTreeNode());
        System.out.println();
        //printTreeNodeG(buildTreeNode());
        System.out.println();
        printTreeNodeH(buildTreeNode());

    }

    /**
     *  递归遍历节点， 前序遍历
     * @param treeNode
     */
    public void printTreeNodeA(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        System.out.print(treeNode.val + "\t");
        printTreeNodeA(treeNode.left);
        printTreeNodeA(treeNode.right);
    }


    /**
     *  递归遍历节点， 中序遍历
     * @param treeNode
     */
    public void printTreeNodeB(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        printTreeNodeB(treeNode.left);
        System.out.print(treeNode.val + "\t");
        printTreeNodeB(treeNode.right);
    }



    /**
     *  递归遍历节点， 后序遍历
     * @param treeNode
     */
    public void printTreeNodeC(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        printTreeNodeC(treeNode.left);
        printTreeNodeC(treeNode.right);
        System.out.print(treeNode.val + "\t");
    }


    /**
     *  非递归遍历节点， 基于栈实现
     * @param treeNode
     */
    public void printTreeNodeD(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + "\t");
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 非递归遍历节点， 前序遍历，先打印，再输出
     * @param treeNode
     */
    public void printTreeNodeE(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = treeNode;
        while (null != curNode || !stack.isEmpty()) {
            if (null != curNode) {
                System.out.print(curNode.val + "\t");
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (curNode == null) {
                curNode = stack.pop().right;
            }
        }
    }

    /**
     * 非递归遍历节点， 中序遍历, 先压栈
     * @param treeNode
     */
    public void printTreeNodeF(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = treeNode;
        while (null != curNode || !stack.isEmpty()) {
            if (null != curNode) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (curNode == null) {
                curNode = stack.pop();
                System.out.print(curNode.val + "\t");
                curNode = curNode.right;
            }
        }
    }

    /**
     *  扩展，横向遍历树， 基于列表
     */
    public void printTreeNodeG(TreeNode treeNode) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if (null != treeNode) {
            treeNodeQueue.offer(treeNode);
        }
        while (!treeNodeQueue.isEmpty()) {
           TreeNode currentNod = treeNodeQueue.poll();
           System.out.print(currentNod.val + "\t");
           if (null != currentNod.right) {
               treeNodeQueue.offer(currentNod.right);
           }
           if (null != currentNod.left) {
               treeNodeQueue.offer(currentNod.left);
           }
        }

    }

    /**
     *  扩展，横向遍历树， 基于列表
     */
    public void printTreeNodeH(TreeNode treeNode) {
        LinkedList<TreeNode> ltrQueue = new LinkedList<>();
        LinkedList<TreeNode> rtlQueue = new LinkedList<>();
        if (null != treeNode) {
            ltrQueue.offer(treeNode);
        }
        while (!ltrQueue.isEmpty() || !rtlQueue.isEmpty()) {
            while (!ltrQueue.isEmpty()) {
                TreeNode curNode = ltrQueue.poll();
                System.out.print(curNode.val + "\t");
                if (curNode.right != null) {
                    rtlQueue.addFirst(curNode.right);
                }
                if (curNode.left != null) {
                    rtlQueue.addFirst(curNode.left);
                }
            }
            while (!rtlQueue.isEmpty()) {
                TreeNode curNode = rtlQueue.poll();
                System.out.print(curNode.val + "\t");
                if (curNode.left != null) { // 已经是返着打印了， 所以不应跌倒
                    ltrQueue.addFirst(curNode.left);
                }
                if (curNode.right != null) {
                    ltrQueue.addFirst(curNode.right);
                }
            }
        }
    }

    @Test
    public void doTestA() {
        Integer a = null;
        int b = a;
    }


    @Data
    class HSH {
        int num;

        public HSH(int num) {
            this.num = num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HSH hsh = (HSH) o;
            return num == hsh.num;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    @Test
    public void testHashMap() {
        HashMap<HSH, String> hashMap = new HashMap<>();
        HSH hsh = new HSH(1);
        HSH hsh1 = new HSH(2);
        hashMap.put(hsh, "test");
        hashMap.put(hsh1, "good");

        System.out.println(hashMap.get(hsh));
        System.out.println(hashMap.get(hsh1));

    }


}
