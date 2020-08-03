package 面试题02_实现Singleton模式;

/**
 * 使用静态变量，在类加载时初始化实例对象，保证程序运行期间有且仅有一个实例。
 *
 * @Author hustffx
 * @Date 2020/8/3
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
