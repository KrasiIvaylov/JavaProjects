package StackIterator;

import java.security.InvalidParameterException;
import java.util.Iterator;

public class stack<T> implements Iterable<T> {
    private class Node<T> {
        private Node<T> prev;
        private T element;

        private Node(T element){
            this.prev = null;
            this.element = element;
        }
    }

    private Node<T> top;

    public stack(){
        this.top = null;
    }

    public void push(T element){
        Node<T> newNode = new Node<>(element);
        newNode.prev = this.top;
        this.top = newNode;
    }

    public T pop(){
        if(this.top == null){
            throw new InvalidParameterException("No elements");
        }

        T element = this.top.element;
        this.top = this.top.prev;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = top;
            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public T next() {
                T element = this.current.element;
                this.current = this.current.prev;
                return element;
            }
        };
    }
}