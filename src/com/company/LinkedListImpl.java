package com.company;

public class LinkedListImpl {

    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(2);
        node.setNext(node1);
        Node node2 = new Node(3);
        node1.setNext(node2);
        Node node3 = new Node(4);
        node2.setNext(node3);
        Node node4 = new Node(5);
        node3.setNext(node4);
        Node node5 = new Node(6);
        node4.setNext(node5);
        Node node6 = new Node(7);
        node5.setNext(node6);
        Node node7 = new Node(8);
        node6.setNext(node7);

        Node reversedList = new ListUtility().reverseList(node, 3);
        if(reversedList != null) {
            Node current = reversedList;
            while(current != null) {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            }
        }
    }

}

class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    int getData() {
        return data;
    }

    Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class ListUtility {

    public Node reverseList(Node head, int size) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        Node start = null;
        Node current = head;
        Node endOfHead = null;
        Node temp = head;
        int count;
        while(null != current) {
            count = 1;
            while(count < size && temp.getNext() != null) {
                temp = temp.getNext();
                count++;
            }
            Node newNode = temp.getNext();
            temp.setNext(null);
            temp = newNode;
            newNode = reverse(current);
            if(start == null) {
                start = newNode;
                endOfHead = start;
                while(endOfHead.getNext() != null) {
                    endOfHead = endOfHead.getNext();
                }
            } else {
                endOfHead.setNext(newNode);
                while(endOfHead.getNext() != null) {
                    endOfHead = endOfHead.getNext();
                }
            }
            current = temp;
        }
        return start;
    }

    public Node reverse(Node head) {
        Node temp = null;
        Node current = head;

        if(head == null || head.getNext() == null) {
            return head;
        }

        while(current.getNext() != null) {
            current = current.getNext();
            head.setNext(temp);
            temp = head;
            head = current;
        }
        if(current.getNext() == null) {
            current.setNext(temp);
        }
        return head;
    }
}
