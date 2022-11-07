package com.day14_datastructure;

public class DeleteLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static DeleteLinkedList insert(DeleteLinkedList list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(DeleteLinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print("key = " + currNode.data + ", ");
            currNode = currNode.next;
        }
    }

    public static DeleteLinkedList deleteByKey(DeleteLinkedList list, int key) {
        Node currNode = list.head, prev = null;
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println(key + " found and deleted");
            return list;
        }
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }
        if (currNode == null) {
            System.out.println(key + " not found");
        }
        return list;
    }


    public static void main(String[] args) {
        DeleteLinkedList list = new DeleteLinkedList();
        list = insert(list, 56);
        list = insert(list, 30);
        list = insert(list, 70);
        printList(list);
        deleteByKey(list, 56);
        printList(list);
    }
}
