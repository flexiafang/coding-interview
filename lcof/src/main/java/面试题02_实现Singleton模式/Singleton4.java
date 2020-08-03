package 面试题02_实现Singleton模式;

/**
 * 使用枚举类型，天然线程安全，也可以避免反射和序列化机制破坏单例特性。
 *
 * @Author hustffx
 * @Date 2020/8/3
 */
public enum Singleton4 {

    INSTANCE;

    public void doSomething() {
        System.out.println("这是枚举类型的单例模式！");
    }
}
