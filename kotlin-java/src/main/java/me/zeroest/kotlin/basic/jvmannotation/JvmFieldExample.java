package me.zeroest.kotlin.basic.jvmannotation;

public class JvmFieldExample {
    public static void main(String[] args) {
//        int id = JvmFieldClass.Companion.getId();
//        String name = JvmFieldObject.INSTANCE.getName();
        int id = JvmFieldClass.id;
        String name = JvmFieldObject.name;
        System.out.println("id = " + id);
        System.out.println("name = " + name);

        int code = JvmFieldClass.CODE;
        String familyName = JvmFieldObject.FAMILY_NAME;
        System.out.println("code = " + code);
        System.out.println("familyName = " + familyName);
    }
}
