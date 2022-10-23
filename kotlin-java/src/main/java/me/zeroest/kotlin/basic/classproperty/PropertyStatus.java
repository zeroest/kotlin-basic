package me.zeroest.kotlin.basic.classproperty;

public class PropertyStatus {

    private static class JavaCoffee {
        private String name = "Java Coffee";
        private boolean iced;

        public String getName() {
            return name;
        }

        public boolean isIced() {
            return iced;
        }

        public void setIced(boolean iced) {
            this.iced = iced;
        }
    }

    public static void main(String[] args) {
        JavaCoffee javaCoffee = new JavaCoffee();

        javaCoffee.setIced(true);

        if (javaCoffee.isIced()) { // 상태를 메서드로 표현
            System.out.printf("Ice %s\n", javaCoffee.getName());
        } else {
            System.out.printf("Hot %s\n", javaCoffee.getName());
        }
    }

}
