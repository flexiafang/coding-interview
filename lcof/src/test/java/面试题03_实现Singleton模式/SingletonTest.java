package 面试题03_实现Singleton模式;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @Author hustffx
 * @Date 2020/8/1
 */
public class SingletonTest {

    // 以A开始的信号量,初始信号量数量为1
    private static final Semaphore A = new Semaphore(1);
    // B、C信号量,A完成后开始,初始信号数量为0
    private static final Semaphore B = new Semaphore(0);
    private static final Semaphore C = new Semaphore(0);

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    // A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                    A.acquire();
                    System.out.println("A：" + Singleton.getUniqueInstance());
                    // B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.println("B：" + Singleton.getUniqueInstance());
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    C.acquire();
                    System.out.println("C：" + Singleton.getUniqueInstance());
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