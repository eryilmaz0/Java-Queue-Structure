package Base.Package;

import Base.Package.Structure.CustomQueue;
import Base.Package.Structure.Queue;

public class Main {

    public static void main(String[] args) {

        //Queue<String> queue = new Queue<String>();
        Queue<String> queue2 = new CustomQueue<String>(7);


        System.out.println(queue2.pop("Value 1"));
        System.out.println(queue2.pop("Value 2"));
        System.out.println(queue2.pop("Value 3"));
        System.out.println(queue2.pop("Value 4"));

        System.out.println(queue2.getQueueLength());
        queue2.printQueueInfo();

        System.out.println(queue2.add(1, "Value 1 (Add)"));
        queue2.printQueueInfo();

        System.out.println(queue2.add(5, "Value 4 (Add)"));
        queue2.printQueueInfo();

        System.out.println(queue2.add(3, "Value 10"));
        queue2.printQueueInfo();


        System.out.println(queue2.replace(5, "Value 20 (Replaced)"));
        queue2.printQueueInfo();

        System.out.println(queue2.replace(3, "Value 10 (Replaced)"));
        queue2.printQueueInfo();

        queue2.clear();

    }
}
