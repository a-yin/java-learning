package com.lingb.mystudy.datastructure.day07;

/**
 * 单链表，相当于 列车
 *
 * Created by lingb on 2018/8/23
 */
public class LinkList<T> {

    // 头结点
    private Node<Student> head;

    public LinkList() {
        head = null;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 头插法（在头结点En后插入）：(头)->En->En-1->...->E2->E1
     *
     * 插入一个结点（车厢）
     * @param data
     */
    public void insertHead(Student data) {
        // 插入的数据打包成结点
        Node<Student> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
        }

        // newNode->old head
        // 将新结点连接链表的头部
        newNode.next = head;
        // head->newNode
        // head永远存储第一个节点的地址
        head = newNode;

    }

    /**
     * 尾插法（在尾结点En后插入）：(头)->E1->E2->...->En-1->En
     * 插入一个结点（车厢）
     *
     * @param data
     */
    public void insertTail(Student data) {
        Node<Student> newNode = new Node<>(data);
        Node<Student> tmp = head;
        if (isEmpty()) {
            head = newNode;
            return;
        }

        // 循环到最后结点（尾结点）
        while (tmp.next != null) {
            // 向后移，tmp指向下一结点
            tmp = tmp.next;
        }
        // 尾结点插入
        tmp.next = newNode;

    }

    /**
     * 头删法（在头结点En后删除）：(头)->En->En-1->...->E2->E1
     * 删除一个结点
     *
     * @param value
     * @return
     */
    public Node<Student> deleteHead() {
        Node<Student> tmp = head;
        head = tmp.next;
        return tmp;
    }


    /**
     * 尾删法（在尾结点En后删除）：(头)->E1->E2->...->En-1->En
     * 删除一个结点
     *
     * @param value
     * @return
     */
    public Node<Student> deleteTail() {
        Node<Student> preNode = head;
        Node<Student> curNode = preNode.next;
//
//        // 删除E1
//        if (size() == 1) {
//            head = head.next;
//        }

        while (curNode != null) {
            if (curNode.next == null) {
                preNode.next = null;
                break;
            }
            // 当前结点和前结点同时向后移
            preNode = preNode.next;
            curNode = curNode.next;
        }

        // 删除E1
        if (curNode == head) {
            head = head.next;
        }

        return curNode;
    }


    /**
     * 删除一个指定data的结点
     *
     * @param data
     * @return
     */
    public Node<Student> delete(String key) {
        Node<Student> preNode = head;
        Node<Student> curNode = head;
        while (!key.equals(curNode.data.getKey())) {
            if (curNode.next == null) {
                return null;
            }

            // 同时移向下一结点
            preNode = curNode;
            curNode = curNode.next;

        }
        // 删除头结点
        if (curNode == head) {
            head = head.next;

        } else {
            // 待删除结点的前结点指向待删除结点的后结点
            preNode.next = curNode.next;
        }

        return curNode;

    }


    /**
     * 查询
     *
     * @param key
     * @return
     */
    public Node find(String key) {
        Node<Student> current = head;
        while (!key.equals(current.data.getKey())) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }

        return current;
    }


    /**
     * 显示链表数据
     */
    public void display() {
        // 从头结点head 开始
        Node<Student> curNode = head;
        System.out.println("头结点：" + curNode.data);
        // 循环到最后的结点
        while (curNode != null) {
            curNode.display();
            // 向后移，current指向下一结点
            curNode = curNode.next;
        }
        System.out.println();
    }


    /**
     * 链表的长度
     *
     * @return
     */
    public int size() {
        int size = 0;
        Node<Student> curNode = head;
        while (curNode != null) {
            size++;
            curNode = curNode.next;
        }

        return size;
    }

}
