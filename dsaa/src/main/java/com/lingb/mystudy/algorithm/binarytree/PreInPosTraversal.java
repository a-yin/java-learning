package com.lingb.mystudy.algorithm.binarytree;

import java.util.Stack;

/**
 * Created by lingb on 2018-12-17
 */
public class PreInPosTraversal {

    /**
     * 递归
     */
    // 根左右
    public static void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    // 左根右
    public static void inOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.print(root.val + " ");
        inOrderRecur(root.right);
    }

    // 左右根
    public static void posOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 非递归
     */
    // 根左右
    public static void preOrderUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            // 出栈顺序（打印顺序）根左右
            System.out.print(root.val + " ");

            // 压栈顺序 根右左
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    // 左根右
    public static void inOrderUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 若当前结点不为空，压栈，当前向左孩子
            if (root != null) {
                stack.push(root);
                root = root.left;

                // 若当前结点为空，出栈打印，当前向右孩子
            } else {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }

    }

    // 左右根
    public static void posOrderUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stackHelp = new Stack<>();
        Stack<TreeNode> stackData = new Stack<>();
        stackHelp.push(root);
        while (!stackHelp.isEmpty()) {
            // 压栈根左右
            root = stackHelp.pop();
            // pre
            // System.out.print(root.val + " ");
            stackData.push(root);
            if (root.left != null) {
                stackHelp.push(root.left);
            }
            if (root.right != null) {
                stackHelp.push(root.right);
            }
        }

        while (!stackData.isEmpty()) {
            // 出栈打印 左右根
            System.out.print(stackData.pop().val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(11);

        // 递归
        System.out.println("============== 递归 ==============");
        System.out.print("pre-order: ");
        preOrderRecur(root);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(root);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(root);
        System.out.println();

        // 非递归
        System.out.println("============= 非递归 ==============");
        System.out.print("pre-order: ");
        preOrderUnRecur(root);
        System.out.println();
        System.out.print("in-order: ");
        inOrderUnRecur(root);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderUnRecur(root);
        System.out.println();

    }

}

