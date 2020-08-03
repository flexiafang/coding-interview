# 面试题 02：实现 Singleton 模式

## 题目描述

设计一个类，只能生成该类的一个实例（单例模式）。

## 实现思路

单例模式要求类能够有返回对象一个引用（永远是同一个）和一个获得该实例的方法（必须是静态方法，通常使用 getInstance 这个名称）。

单例的实现主要是通过以下两个步骤：

1. 将该类的构造方法定义为私有方法，这样其他处的代码就无法通过调用该类的构造方法来实例化该类的对象，只有通过该类提供的静态方法来得到该类的唯一实例；
2. 在该类内提供一个静态方法，当我们调用这个方法时，如果类持有的引用不为空就返回这个引用，如果类保持的引用为空就创建该类的实例并将实例的引用赋予该类保持的引用。

## 解法 1 静态变量（饿汉式）

```java
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。

缺点：在类装载的时候就完成实例化，没有达到 Lazy Loading 的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。

## 解法 2 使用双重校验锁（懒汉式）

```java
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
```

进行了两次 `if (instance == null)` 检查，这样可以保证线程安全。实例化代码只用执行一次，后面再次访问时，判断 `if (instance == null)`，直接返回实例化对象。

优点：线程安全，延迟加载，效率较高。

## 解法 3 使用静态内部类持有类的实例

```java
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
```

这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类加载机制来保证初始化实例时只有一个线程。不同的地方在饿汉式方式是只要 Singleton 类被装载就会实例化，没有 Lazy-Loading 的作用，而静态内部类方式在 Singleton 类被装载时并不会立即实例化，而是在需要实例化时，调用 getInstance() 方法，才会加载 SingletonHolder 类，从而完成 Singleton 的实例化。

类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM 帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。

优点：避免了线程不安全，延迟加载，效率高。

## 解法 4 枚举

```java
public enum Singleton4 {

    INSTANCE;

    public void doSomething() {
        System.out.println("这是枚举类型的单例模式！");
    }
}
```

枚举不需要做任何额外的操作，就可以保证对象单一性与线程安全性。在程序启动时，会调用 Singleton 的空参构造器，实例化好一个 Singleton 对象赋给 INSTANCE，之后再也不会实例化。

使用枚举可以防止调用者使用反射、序列化与反序列化机制强制生成多个单例对象，破坏单例模式。

1. 枚举类默认继承了 Enum 类，在利用反射调用 `newInstance()` 时，会判断该类是否是一个枚举类，如果是，则抛出异常。
2. 在读入 Singleton 对象时，每个枚举类型和枚举名字都是唯一的，所以在序列化时，仅仅只是对枚举的类型和变量名输出到文件中，在读入文件反序列化成对象时，使用 Enum 类的 `valueOf(String name)` 方法根据变量的名字查找对应的枚举对象。所以，在序列化和反序列化的过程中，只是写出和读入了枚举类型和名字，没有任何关于对象的操作。