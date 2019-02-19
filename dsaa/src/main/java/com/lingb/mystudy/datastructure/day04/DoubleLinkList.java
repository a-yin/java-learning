package com.lingb.mystudy.datastructure.day04;

/**
 * 双向链表，相当于每个车厢间栓两条铁链的列车
 *
 * Created by lingb on 2018/8/23
 */
public class DoubleLinkList<T> {

	/**
	 * 头结点
 	 */
	private Node head;
	/**
	 * 尾结点
 	 */
	private Node tail;
	
	public DoubleLinkList() {
		head = null;
		tail = null;
	}

	/**
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 *  插入一个结点，在头结点后进行插入
	 */
	public void insertHead(T data) {
		Node<T> node = new Node<>(data);
		if(isEmpty()) {
			tail = node;

		} else {
			head.previous = node;
		}
		node.next = head;
		head = node;
	}
	
	/**
	 * 插入一个结点，从尾结点进行插入
	 */
	public void insertTail(T data) {
		Node<T> node = new Node<>(data);
		if(isEmpty()) {
			head = node;

		} else {
			tail.next = node;
			node.previous = tail;
		}
		tail = node;
	}
	
	/**
	 * 删除一个结点，在头结点后进行删除
	 */
	public Node deleteHead() {
		Node<T> tmp = head;
		if(head.next == null) {
			tmp = null;
		} else {
			// 头结点的下一结点的上一结点 = null
			head.next.previous = null;
		}
		head = tmp.next;
		return tmp;
	}
	
	/**
	 * 删除一个结点，从尾部进行删除
	 */
	public Node deleteTail() {
		Node<T> tmp = tail;
		if(head.next == null) {
			head = null;
		} else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		return tail;
	}
	
	/**
	 * 显示链表数据
	 */
	public void display() {
		Node<T> current = head;
		while(current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 * 查找链表数据
	 */
	public Node<T> find(T data) {
		Node<T> current = head;
		while(current.data != data) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	/**
	 * 删除方法，根据数据域来进行删除
	 */
	public Node<T> delete(T data) {
		Node<T> current = head;
		while(current.data != data) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		
		if(current == head) {
			head = head.next;
		} else {
			current.previous.next = current.next;
		}
		return current;
		
	}

}
