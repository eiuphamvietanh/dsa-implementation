package linkedlist;

public class MyLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public T getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size - 1) {
            return tail.data;
        }
        Node currentNode = head;
        int count = 0;
        while (currentNode != null) {
            /// 3 5 6 7
            /// 0 1 2 3
            if (index == count) {
                return currentNode.data;
            }
            count++;
            currentNode = currentNode.next;

        }
        return null;
    }

    public T removeFirst() {

        if (size == 0) {
            throw new IndexOutOfBoundsException("Size: " + size);
        }

        T data = head.data;

        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;

        return data;
    }
     public T removeLast() {

        if (size == 0) {
            throw new IndexOutOfBoundsException("Size: " + size);
        }

        T data = tail.data;

        return data;
    }


    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * InnerMyLinkedList
     */
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.addFirst(20);
        myLinkedList.addFirst(30);
        myLinkedList.addLast(50);
        myLinkedList.print();
        System.out.println(myLinkedList.getIndex(0));
         System.out.println(myLinkedList.getIndex(1));
          System.out.println(myLinkedList.getIndex(2));
    }

}
