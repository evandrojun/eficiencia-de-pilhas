package linked_list;

public class SimpleLinkedList {
  protected Node head, tail;
  protected long size;

  public SimpleLinkedList() {
    head = tail = null;
    size = 0;
  }

  public long size() {
    return size;
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  public void addFirst(Node node) {
    node.setNext(head);
    head = node;

    if (isEmpty()) {
      tail = node;
    }

    size++;
  }

  public Node removeFirst() throws IllegalStateException {
    if (isEmpty()) {
      throw new IllegalStateException("Empty list");
    }

    Node tmp = head;

    head = head.getNext();

    tmp.setNext(null);

    size--;

    if (isEmpty()) {
      tail = null;
    }

    return tmp;
  }
}
