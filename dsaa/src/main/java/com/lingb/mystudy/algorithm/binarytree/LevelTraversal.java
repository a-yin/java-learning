package com.lingb.mystudy.algorithm.binarytree;

import java.util.*;

/**
 * Created by lingb on 2018-12-11
 */
public class LevelTraversal {


    /**
     * 【从上往下打印二叉树】
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 即举个栗子 [1, 2, 3, 4, 5, 6, 7]
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> pintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode last = root;
        TreeNode nlast = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            res.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
                nlast = root.left;
            }
            if (root.right != null) {
                queue.add(root.right);
                nlast = root.right;
            }
            if (root == last) {
                last = nlast;
            }
        }
        return res;
    }

    /**
     * 【把二叉树打印成多行】
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * 即举个栗子 [[[1], [2, 3], [4, 5, 6, 7]]]
     *
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> layer = new ArrayList<>();
        TreeNode last = pRoot;
        TreeNode nlast = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            pRoot = queue.remove();
            layer.add(pRoot.val);
            if (pRoot.left != null) {
                queue.add(pRoot.left);
                nlast = pRoot.left;
            }
            if (pRoot.right != null) {
                queue.add(pRoot.right);
                nlast = pRoot.right;
            }
            if (pRoot == last) {
                last = nlast;
                res.add(layer);
                layer = new ArrayList<>();
            }
        }
        System.out.print(Arrays.toString(new ArrayList[]{res}));
        return res;
    }


    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }
        Queue<TreeNode> layer = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while (!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left != null){
                layer.add(cur.left);
            }
            if(cur.right != null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                res.add(layerList);
                layerList = new ArrayList<>();
            }
        }
        System.out.print(Arrays.toString(new ArrayList[]{res}));
        return res;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        print(head);
    }
}
