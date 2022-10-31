package me.zeroest.kotlin.basic.exception;

public class JavaException {
    public static void main(String[] args) {
        // 체크드 익셉션은 컴파일 에러가 발생하여 무조건 try-catch 또는 throws 처리
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // Exception handle
        }
    }
}
