
/**
 * Your implementation of a linked stack.
 *
 * @author Quang Hai Dang Dam
 * @version 1.0
 */
public class LinkedStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private int size;

    public LinkedStack() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("No more element exist\n");
        }
        T object = head.getData();
        head = head.getNext();
        size--;
        return object;
    }

    @Override
    public void push(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Cannot insert null data into data structure");
        }
        LinkedNode<T> linkedNode = new LinkedNode<T>(data, head);
        head = linkedNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the head of this stack.
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
}