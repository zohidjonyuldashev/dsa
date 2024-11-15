package stack;

public class Stack<E> {
    private Node<E> top;
    private int height;

    public Stack(E value) {
        Node<E> newNode = new Node<>(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node<E> temp = top;
        while (top != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void push(E value) {
        Node<E> newNode = new Node<>(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        height++;
    }

    public Node<E> pop() {
        if (height == 0) return null;
        Node<E> temp = top;
        top = top.getNext();
        temp.setNext(null);
        height--;
        return temp;
    }

    public Node<E> peek() {
        if (height == 0) return null;
        return top;
    }
}