package com.lingb.mystudy.dsaa.day06;

/**
 * 二叉树结点
 */
public class Node {

	/**
	 * 数据项
	 */
	public int data;

	/**
	 * 数据项
	 */
	public String sData;

	/**
	 * 左子结点
	 */
	public Node leftChild;

	/**
	 * 右子结点
	 */
	public Node rightChild;
	
	/**
	 * 带参数的构造方法
	 *
	 * @param data
	 */
	public Node(int data) {
		this.data = data;
	}

	/**
	 * 带参数的构造方法
	 *
	 * @param data
	 */
	public Node(int data, String sData) {
		this.data = data;
		this.sData = sData;
	}

}
