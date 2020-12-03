package pilha_ingenua_2;

public class PilhaIngenua2 {
  protected int capacity;
  public static final int CAPACITY = 8;
  protected Integer[] pilha;
  protected int size;

  public PilhaIngenua2() {
    capacity = CAPACITY;
    pilha = new Integer[capacity];
    size = 0;
  }

  public void add(int newElement) {
    if (size == capacity) {
      capacity += CAPACITY;
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