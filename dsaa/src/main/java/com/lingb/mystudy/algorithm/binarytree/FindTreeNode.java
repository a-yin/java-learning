package com.lingb.mystudy.algorithm.binarytree;

/**
 * Created by lingb on 2018-12-17
 */
public class FindTreeNode {

    /**
     * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
     * 假设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针
     * 都正确地指向 自己的父节点，头节点的parent指向null。只给一个在
     * 二叉树中的某个节点 node，请实现返回node的后继节点的函数。
     * 在二叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    /**
     * 在二叉树的中序遍历(左根右)的序列中，找前驱结点
     */
    public TreeNode findPrecursor(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 当前结点的左孩子不为空，找左孩子的最右孩子，即为前驱结点
        if (node.left != null) {
            return findRightMost(node.left);

        // 否则为空，向上找根结点为根根结点的右孩子时返回根结点，即为前驱结点
        } else {
            TreeNode parent = node.parent;
            // parent != null 是用于判断右叶子结点的情况
            while (parent != null && parent.right != node) {
                node = node.parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    private TreeNode findRightMost(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 在二叉树的中序遍历(左根右)的序列中，找后继结点
     */
    public TreeNode findSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        // 当前结点的右孩子不为空，找右孩子的最左孩子，即为后继结点
        if (node.right != null) {
            return findLeftMost(node.right);

        // 否则为空，向上找根结点为根根结点的左孩子时返回根结点，即为后继结点
        } else {
            TreeNode parent = node.parent;
            // parent != null 是用于判断左叶子结点的情况
            while (parent != null && parent.left != node) {
                node = node.parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private TreeNode findLeftMost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
