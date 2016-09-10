package com.company;

/**
 * Created by haidangdam on 9/9/16.
 */
public class RealityCheck {
    // You don't really need to have an constructor.
    private class Node<T> {
        private T data;
        private Node forward;
        private Node backward;

        private Node(T data, Node forward, Node backward) {
            this.data = data;
            this.forward = forward;
            this.backward = backward;
        }

        public T getData() {
            return data;
        }
        public void setNext(Node<T> ) {

        }

        public Node<T> getNext() {

        }

        public Node<T> getBack() {

        }

        public Node<t> setBack() {

        }
    }
}
