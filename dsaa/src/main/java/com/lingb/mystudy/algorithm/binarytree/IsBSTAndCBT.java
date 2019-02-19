package com.lingb.mystudy.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lingb on 2018-12-18
 */
public class IsBSTAndCBT {

    public static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            // 若当前结点不为空，压栈，当前向左孩子
            if (root != null) {
                stack.push(root);
                root = root.left;

                // 若当前结点为空，出栈打印，当前向右孩子
            } else {
                root = stack.pop();
                if (pre != null && pre.val > root.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }

    public static boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode left = null;
        TreeNode right = null;
        boolean leaf = false;
        while (!q.isEmpty()) {
            root = q.poll();
            left = root.left;
            right = root.right;
            if ((leaf && left != null && right != null) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                q.add(left);
            }
            if (right != null) {
                q.add(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }

    // for test -- print tree
    public static void printTree(TreeNode root) {
        System.out.println("Binary Tree:");
        printInOrder(root, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode root, int height, String to, int len) {
        if (root == null) {
            return;
        }
        printInOrder(root.right, height + 1, "v", len);
        String val = to + root.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(root.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
