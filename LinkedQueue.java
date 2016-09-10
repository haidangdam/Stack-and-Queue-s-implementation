/**
 * Your implementation of a linked queue.
 *
 * @author Quang Hai Dang Dam
 * @version 1.0
 */
public class LinkedQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("No more element exist");
        }
        T object = head.getData();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return object;
    }

    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Cannot insert null data into data structure");
        }
        if (isEmpty()) {
            LinkedNode<T> linkedNode = new LinkedNode<T>(data, null);
            head = linkedNode;
            tail = linkedNode;
        } else {
            LinkedNode<T> linkedNode = new LinkedNode<T>(data, null);
            tail.setNext(linkedNode);
            tail = linkedNode;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the head of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the head node
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    /**
     * Returns the tail of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the tail node
     */
    public LinkedNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }
}