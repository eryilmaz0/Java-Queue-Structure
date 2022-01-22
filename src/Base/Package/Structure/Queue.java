package Base.Package.Structure;

public interface Queue<T> {
    int getQueueLength();
    void clear();
    void printQueueInfo();
    boolean pop(T value);
    void push();
    boolean add(int orderNumber, T value);
    boolean replace(int orderNumber, T value);
}
