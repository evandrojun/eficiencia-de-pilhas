package linked_list;

public class Node {
  private String element;
  private Node nextNode;

  public Node(String element, Node nextNode) {
    this.element = element;
    this.nextNode = nextNode;
  }

  public String getElement() {
    return element;
  }

  public Node getNext() {
    return nextNode;
  }

  public void setElement(String newElement) {
    element = newElement;
  }

  public void setNext(Node newNext) {
    nextNode = newNext;
  }
}
