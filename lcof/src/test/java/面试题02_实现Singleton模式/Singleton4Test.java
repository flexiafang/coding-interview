package 面试题02_实现Singleton模式;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @Author hustffx
 * @Date 2020/8/2
 */
public class Singleton4Test {

    private static final Semaphore A = new Semaphore(1);
    private static final Semaphore B = new Semaphore(0);
    private static final Semaphore C = new Semaphore(0);

    private static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    A.acquire();
                    System.out.println("A：" + Singleton4.INSTANCE.hashCode());
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    B.acquire();
                    System.out.println("B：" + Singleton4.INSTANCE.hashCode());
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    C.acquire();
                    System.out.println("C：" + Singleton4.INSTANCE.hashCode());
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSingleton() throws InterruptedException {
        new ThreadA().start();
        Thread.sleep(1);
        new ThreadB().start();
        Thread.sleep(1);
        new ThreadC().start();
        Thread.sleep(1);
    }
}