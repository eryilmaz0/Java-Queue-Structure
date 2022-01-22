package Base.Package.Structure;

public interface Queue<T> {

    //Abstract Methots for Queue Structure
    int getQueueLength();
    void clear();
    void printQueueInfo();
    boolean pop(T value);
    void push();
    boolean add(int orderNumber, T value);
    boolean replace(int orderNumber, T value);
}
