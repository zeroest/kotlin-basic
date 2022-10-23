package me.zeroest.kotlin.basic.extensionfunction;

public class ExtensionFunctionExample {
    public static void main(String[] args) {
//        "ABCD".firstChar();
//        "ABCD".addFirstChar('Z');

        char firstChar = MyExtensionKt.firstChar("ABCD");
        String addFirstChar = MyExtensionKt.addFirstChar("ABCD", 'Z');
        System.out.println("firstChar = " + firstChar);
        System.out.println("addFirstChar = " + addFirstChar);
    }
}
