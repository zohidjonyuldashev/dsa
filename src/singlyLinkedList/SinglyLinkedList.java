package singlyLinkedList;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public SinglyLinkedList(E element) {
        Node<E> newNode = new Node<>(element);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.getElement());
            temp = temp.getNext();
        }
    }

    public void append(E element) {
        Node<E> newNode = new Node<>(element);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        length++;
    }

    public E removeLast() {
        if (length == 0) return null;
        Node<E> temp = head;
        Node<E> pre = head;
        while (temp.getNext() != null) {
            pre = temp;
            temp = temp.getNext();
        }
        tail = pre;
        tail.setNext(null);
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp.getElement();
    }

    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        length++;
    }

    public E removeFirst() {
        if (length == 0) return null;
        Node<E> temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp.getElement();
    }

    public Node<E> get(int index) {
        if (index < 0 || index >= length) return null;
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean set(int index, E value) {
        Node<E> temp = get(index);
        if (temp != null) {
            temp.setElement(value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, E value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node<E> newNode = new Node<>(value);
        Node<E> temp = get(index - 1);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        length++;
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index > length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node<E> prev = get(index - 1);
        Node<E> temp = prev.getNext();
        prev.setNext(temp.getNext());
        temp.setNext(null);
        length--;
        return temp.getElement();
    }

    public void reverse() {
        Node<E> temp = head;
        head = tail;
        tail = temp;
        Node<E> after = temp.getNext();
        Node<E> before = null;
        for (int i = 0; i < length; i++) {
            after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
    }
}