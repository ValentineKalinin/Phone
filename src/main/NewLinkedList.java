package main;

import static main.Main.LOGGER;

public class NewLinkedList<T> {
    private Node<T> head;

    public void addLast(T t) {
        if (head == null) {
            head = new Node<>(t);
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = new Node<>(t);
    }

    public void addFirst(T t) {
        Node<T> firstNode = new Node<>(t);
        firstNode.next = head;
        head = firstNode;
    }

    public int get(T t) {
        if (head == null)
            return -1;
        if (head.value == t)
            return 0;

        Node<T> currentNode = head;
        int result = 0;
        while (currentNode.next != null) {
            ++result;
            if (currentNode.next.value == t)
                return result;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void remove(T t) {
        if (head == null)
            return;
        if (head.value == t) {
            head = head.next;
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == t) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public void size() {
        Node<T> currentNode = head;
        int size = 0;
        if (currentNode == null) {
            LOGGER.info("Linked list is empty");
        } else {
            while (currentNode != null) {
                size = size + 1;
                currentNode = currentNode.next;
            }
        }
        LOGGER.info("Linked list's size is " + size);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    "}";
        }
    }
}
