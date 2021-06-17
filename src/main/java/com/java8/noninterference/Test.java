package com.java8.noninterference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    @org.junit.Test
    public void f1() {
        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(Collectors.joining(" "));
        l.add("four");
        System.out.print(s);
    }
}
