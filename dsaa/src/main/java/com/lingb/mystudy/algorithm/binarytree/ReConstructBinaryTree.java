package com.lingb.mystudy.algorithm.binarytree;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.22 13:51
 */
public class ReConstructBinaryTree {


    /**
     * 根据前序遍历结果和中序遍历结果 重建二叉树
     * 二叉树逻辑描述是【树】结构，物理描述常用【数组】
     */

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1,
                                    in, 0, in.length - 1);
    }


    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
                                           int[] in, int startIn, int endIn) {

        if ((pre.length == 0) || (in.length == 0) || (startPre > endPre) || (startIn > endIn)) {
            return null;
        }

        // 根据前序遍历结果获取树的根结点
        TreeNode root = new TreeNode(pre[startPre]);
        // 遍历中序遍历结果
        for (int i = startIn; i <= endIn; i++) {
            // 找到根结点位置，划分左右结点
            if (root.val == in[i]) {
                root.left = reConstructBinaryTree(pre,startPre + 1,startPre + i - startIn,
                                                    in, startIn,i - 1);
                root.right = reConstructBinaryTree(pre,startPre + i + 1 - startIn, endPre,
                                                    in,i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        int[] pre = {1, 2, 6, 4, 3, 5};
//        int[] in = {6, 2, 4, 1, 5, 3};
        int[] pre = {1, 2, 4, 5, 7, 8, 3, 6 };
        int[] in = {4, 2, 7, 5, 8, 1, 3, 6};
        PrintBinaryTree.printTree(reConstructBinaryTree(pre, in));
    }
}
