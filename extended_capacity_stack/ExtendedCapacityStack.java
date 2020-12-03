package extended_capacity_stack;

public class ExtendedCapacityStack {
  protected int capacity;
  public static final int CAPACITY = 8;
  protected Integer[] pilha;
  protected int size;

  public ExtendedCapacityStack() {
    capacity = CAPACITY;
    pilha = new Integer[capacity];
    size = 0;
  }

  public void add(int newElement) {
    if (size == capacity) {
      capacity *= 2;
      Integer[] tmp = new Integer[capacity];

      for (int i = 0; i < size; i ++) {
        tmp[i] = pilha[i];
      }

      pilha = tmp;
    }

    pilha[size] = newElement;
    size++;
  }

  public int remove() {
    int tmp = pilha[size - 1];
    size--;

    return tmp;
  }
}
