import java.sql.Time;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 锁 + volatile
 * AtomicInteger
 *
 * @author coderblue
 * @date 2020/12/17
 */
public class Main {

    private final static Object object = new Object();
    private volatile static int flag = 1;
    private static int[] order = {3, 1, 2};

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> System.out.printf("one"));
        Thread t2 = new Thread(() -> System.out.printf("two"));
        Thread t3 = new Thread(() -> System.out.printf("Three"));

        first(t1);
        second(t2);
        third(t3);
    }

    public Main() {

    }

    public static void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) {
                object.wait();
            }
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }

    public static void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) {
                object.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public static void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while (flag != 3) {
                object.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            object.notifyAll();
        }
    }
}
