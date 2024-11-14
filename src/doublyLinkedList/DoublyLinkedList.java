package doublyLinkedList;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public DoublyLinkedList(E value) {
        Node<E> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void append(E value) {
        Node<E> node = new Node<>(value);
        if (length == 0) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        length++;
    }

    public E removeLast() {
        if (length == 0) return null;
        Node<E> temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
            temp.setPrev(null);
        }
        length--;
        return temp.getValue();
    }

    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        length++;
    }

    public E removeFirst() {
        if (length == 0) return null;
        Node<E> temp = head;
        if (length == 1) {
            head = null;
            tail = null;

        } else {
            head = temp.getNext();
            head.setPrev(null);
            temp.setNext(null);
        }
        length--;
        return temp.getValue();
    }

    public Node<E> get(int index) {
        if (index < 0 || index >= length) return null;
        Node<E> temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.getPrev();
            }
        }
        return temp;
    }

    public boolean set(int index, E value) {
        Node<E> node = get(index);
        if (node != null) {
            node.setValue(value);
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
        Node<E> before = get(index - 1);
        Node<E> after = before.getNext();
        newNode.setPrev(before);
        newNode.setNext(after);
        before.setNext(newNode);
        after.setPrev(newNode);
        length++;
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node<E> temp = get(index);
        temp.getNext().setPrev(temp.getPrev());
        temp.getPrev().setNext(temp.getNext());
        temp.setPrev(null);
        temp.setNext(null);
        length--;
        return temp.getValue();
    }
}
