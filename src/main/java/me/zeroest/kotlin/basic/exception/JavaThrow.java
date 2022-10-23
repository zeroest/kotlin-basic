package me.zeroest.kotlin.basic.exception;

import java.io.IOException;

public class JavaThrow {

    public void throwIOException() throws IOException {
        throw new IOException("[JavaThrow] IOException");
    }

    public static void main(String[] args) {
        JavaThrow javaThrow = new JavaThrow();

        // 체크드 익셥션이기에 try-catch가 필수
        try {
            javaThrow.throwIOException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        하지만 코틀린의 경우 체크드 익셉션의 예외처리를 강제하지 않기 때문에 예외처리시 오히려 오류 발생
        Exception 'java.io.IOException' is never thrown in the corresponding try block

        따라서 코틀린 코드에 예외전파 에너테이션을 추가하도록 한다.
        */
        KotlinThrow kotlinThrow = new KotlinThrow();
        try {
            kotlinThrow.throwIoException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
