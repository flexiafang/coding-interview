package 面试题02_实现Singleton模式;

/**
 * 双重校验锁（DCL, Double Check Lock）
 *
 * @Author hustffx
 * @Date 2020/8/1
 */
public class Singleton2 {

    private volatile static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
