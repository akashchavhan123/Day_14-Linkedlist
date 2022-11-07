package com.day14_datastructure;

public class SearchElementInLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static SearchElementInLinkedList insert(SearchElementInLinkedList list, int data) {
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

    public static void printList(SearchElementInLinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print("key = " + currNode.data + ", ");
            currNode = currNode.next;
        }
    }

    public static SearchElementInLinkedList deleteByKey(SearchElementInLinkedList list, int key) {
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

    public int search(SearchElementInLinkedList list, int data) {
        if (head == null) {
            return -1;
        }
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchElementInLinkedList list = new SearchElementInLinkedList();
        list = insert(list, 56);
        list = insert(list, 30);
        list = insert(list, 70);
        printList(list);
        deleteByKey(list, 56);
        printList(list);

        int ans = list.search(list, 30);
        if (ans == -1) {
            System.out.println("\nElement not found in the Linked List");
        } else
            System.out.println("\nElement found in the Linked List ");
    }
}
