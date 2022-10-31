package me.zeroest.kotlin.basic.jvmannotation;

public class JvmStaticExample {
    public static void main(String[] args) {

        // @JvmStatic 어노테이션으로 아래와 같이 제공
//        String hello = HelloClass.Companion.hello();
//        String hi = HiObject.INSTANCE.hi();
        String hello = HelloClass.hello();
        String hi = HiObject.hi();

        System.out.println("hello = " + hello);
        System.out.println("hi = " + hi);
    }
}
