package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */

    private int limit;

    private LinkedList<T> linkedList;

    public BQueue(int limit) {

        this.limit = limit;

        this.linkedList = new LinkedList<>();

    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public void offer(T data) {

        synchronized (this) {

            try {

                while (linkedList.size() == limit) {

                    this.wait();

                }

            } catch (InterruptedException ex) {

                System.out.println(ex.getMessage());

            }

            System.out.println("ELEMENT " + data + " HAS BEEN INSERTED INSIDE THE QUEUE.");

            linkedList.offer(data);

            notifyAll();

        }

    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public T poll() {

        synchronized (this) {

            try {

                while (linkedList.size() == 0) {

                    this.wait();

                }

            } catch (InterruptedException ex) {

                System.out.println(ex.getMessage());

            }

            T result = linkedList.poll();

            System.out.println("ELEMENT " + result + " HAS BEEN REMOVED.");

            notifyAll();

            return result;

        }

    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public int getSize() {

        return linkedList.size();

    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {

        return limit;

    }

}
