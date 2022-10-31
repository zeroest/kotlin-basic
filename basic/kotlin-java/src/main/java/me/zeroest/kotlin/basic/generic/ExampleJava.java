package me.zeroest.kotlin.basic.generic;

import java.util.List;

public class ExampleJava {
    public static void main(String[] args) {
        SummariesJava.Builder<Summary> builder = SummariesJava.builder(StateJava.class);
        List<Summary> summaries = builder.build();
    }
}
