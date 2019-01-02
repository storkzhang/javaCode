package com.storkzhang.practice.structure.linkedlists;

public class SingleLinkedList<Item> {
    public Node head;
    public Node tail;

    // define the node structure
    public SingleLinkedList() {
        head = new Node();
        head.next = null;
        tail = head;
    }

    // 1、单链表的创建
    public void addNode(int data) {
        Node node = new Node(data);
        node.next = null;
        tail.next = node;
        tail = node;
    }

    //1、单链表的遍历
    public static void print(Node head) {
        Node curNode = head.next;
        while (null != curNode) {
            System.out.println(curNode.data);
            curNode = curNode.next;
        }
    }

    //2、求单链表中节点的个数
    public int getSize() {
        int count = 0;
        Node curNode = head.next;
        while (null != curNode) {
            count++;
            curNode = curNode.next;
        }
        return count;
    }

    //3、查找单链表中的倒数第k个结点
    public Node findReservedKthNode(int k) {
        if (k <= 0) {
            return null;
        }
        Node nextNode = head.next;
        Node kNode = null;
        int i = 0;
        while (nextNode != null && i < k) {
            i++;
            nextNode = nextNode.next;
        }
        if (i == k) {
            kNode = head.next;
            while (nextNode != null) {
                kNode = kNode.next;
                nextNode = nextNode.next;
            }
        }
        return kNode;
    }

    //4、查找单链表中的中间结点
    public Node findMidNode() {
        Node firstNode = head.next;
        if (firstNode.next == null) {
            return firstNode;
        }
        Node secondNode = head.next;
        while (secondNode != null && secondNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next.next;
        }
        return firstNode;
    }

    //5. 合并两个有序的单链表，合并之后的链表依然有序【出现频率高】（剑指offer，题17）
    public static Node merge(Node first, Node second) {
        Node mergedNodeHead = new Node();
        mergedNodeHead.next = null;
        if (first == null || second == null) {
            return mergedNodeHead;
        }
        Node mergedNode = mergedNodeHead;
        first = first.next;
        second = second.next;
        while (first != null && second != null) {
            if (first.data < second.data) {
                mergedNode.next = first;
                first = first.next;
            } else {
                mergedNode.next = second;
                second = second.next;
            }
            mergedNode = mergedNode.next;
        }
        if (first == null) {
            mergedNode.next = second;
        }
        if (second == null) {
            mergedNode.next = first;
        }
        return mergedNodeHead;
    }

    public static void main(String args[]) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(3);
        singleLinkedList.addNode(5);
        singleLinkedList.addNode(6);

        SingleLinkedList<Integer> singleLinkedList2 = new SingleLinkedList<Integer>();
        singleLinkedList2.addNode(2);
        singleLinkedList2.addNode(4);
        singleLinkedList2.addNode(7);
        singleLinkedList2.addNode(9);
        singleLinkedList2.addNode(10);
        //singleLinkedList.addNode(4);
        System.out.println("list size:" + singleLinkedList.getSize());
        //SingleLinkedList.print(singleLinkedList.head);
        System.out.println("kth node:" + singleLinkedList.findReservedKthNode(2).data);
        System.out.println("middle node:" + singleLinkedList.findMidNode().data);
        SingleLinkedList.print(SingleLinkedList.merge(singleLinkedList.head, singleLinkedList2.head));
    }
}