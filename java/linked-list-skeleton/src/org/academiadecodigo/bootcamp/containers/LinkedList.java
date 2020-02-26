package org.academiadecodigo.bootcamp.containers;

public class LinkedList<T> {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(T data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {

        if (length == 0) return null;

        Node iterator = head.getNext();

        int currentIndex = 0;

        while (currentIndex != index && iterator.getNext() != null) {

            iterator = iterator.getNext();

            currentIndex++;

        }

        if (currentIndex == index) {

            return iterator.getData();

        } else {

            return null;

        }

    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {

        if (length == 0) return -1;

        Node iterator = head.getNext();

        int index = 0;

        while (iterator != null) {

            if (iterator.getData().equals(data)) {

                return index;

            }

            iterator = iterator.getNext();

            index++;

        }

        return -1;

    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {

        if (length == 0) return false;

        Node iterator = head.getNext();

        Node previous = head;

        while (iterator != null) {

            if (iterator.getData().equals(data)) {

                iterator.setData(null);

                previous.setNext(iterator.getNext());

                length--;

                return true;

            }

            previous = iterator;

            iterator = iterator.getNext();

        }

        return false;

    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
