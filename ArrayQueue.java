/**
 * Your implementation of an array-backed queue.
 *
 * @author Quang Hai Dang Dam
 * @version 1.0
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int front;
    private int back;
    private int size;
    private int capacity;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        size = 0;
        back = 0;
        capacity = INITIAL_CAPACITY;
    }

    /**
     * Dequeue from the front of the queue.
     *
     * Do not shrink the backing array.
     * If the queue becomes empty as a result of this call, you <b>must not</b>
     * explicitly reset front or back to 0.
     *
     * @see QueueInterface#dequeue()
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("No more element exist");
        }
        T object = backingArray[front];
        backingArray[front] = null;
        front = (front + 1) % capacity;
        size--;
        return object;
    }

    /**
     * Add the given data to the queue.
     *
     * If sufficient space is not available in the backing array, you should
     * regrow it to 1.5 times the current backing array length, rounding down
     * if necessary. If a regrow is necessary, you should copy elements to the
     * front of the new array and reset front to 0.
     *
     * @see QueueInterface#enqueue(T)
     */
    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("insert null data into data structure");
        }
        if (size == capacity) {
            capacity *= 1.5;
            T[] newArray = (T[]) new Object[capacity];
            for (int a = 0; a < size; a++) {
                newArray[a] = backingArray[(front + a) % size()];
            }
            backingArray = newArray;
            front = 0;
            back = size;
        }
        backingArray[back] = data;
        back = (back + 1) % capacity;
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
     * Returns the backing array of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the backing array
     */
    public Object[] getBackingArray() {
        // DO NOT MODIFY!
        return backingArray;
    }
}