package 面试题03_实现Singleton模式;

/**
 * @Author hustffx
 * @Date 2020/8/1
 */
public class Singleton2 {

    private volatile static Singleton2 uniqueInstance;

    private Singleton2() {
    }

    public static Singleton2 getUniqueInstance() {
        return uniqueInstance;
    }
}
