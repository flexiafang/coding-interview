package 面试题02_实现Singleton模式;

/**
 * 使用静态内部类 + Holder模式
 *
 * @Author hustffx
 * @Date 2020/8/1
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
