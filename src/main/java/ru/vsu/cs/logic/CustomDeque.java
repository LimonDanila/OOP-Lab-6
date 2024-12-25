package ru.vsu.cs.logic;

public class CustomDeque<E> implements Deque<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    @Override
    public void addFirst(E obj) {
        offerFirst(obj);
    }

    @Override
    public void addLast(E obj) {
        offerLast(obj);
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Очередь пуста");
        }

        return first.data;
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Очередь пуста");
        }

        return last.data;
    }

    @Override
    public boolean offerFirst(E obj) {
        Node<E> newNode = new Node<>(obj);

        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;

        return true;
    }

    @Override
    public boolean offerLast(E obj) {
        Node<E> newNode = new Node<>(obj);

        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;

        return true;
    }

    @Override
    public E peekFirst() {
        return isEmpty()? null: first.data;
    }

    @Override
    public E peekLast() {
        return isEmpty()? null: last.data;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }

        E data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;

        return data;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }

        E data = last.data;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;

        return data;
    }

    @Override
    public E pop() {
        return pollFirst();
    }

    @Override
    public void push(E element) {
        addFirst(element);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Deque is empty!");
        }

        return pollFirst();
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Deque is empty!");
        }

        return pollLast();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder SB = new StringBuilder("[");
        Node<E> curr = first;
        while (curr != null) {
            SB.append(curr.data);
            if (curr.next != null) {
                SB.append(", ");
            }
            curr = curr.next;
        }
        SB.append("]");
        return  SB.toString();
    }
}
