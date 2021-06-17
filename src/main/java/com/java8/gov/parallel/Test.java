package com.java8.gov.parallel;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    @org.junit.Test
    public void f2() {
        int[] arr = IntStream.range(0,100).parallel().map(x -> x*2).toArray();

        IntStream stream = Arrays.stream(arr);

        // Assignment context
        Predicate<String> p = String::isEmpty;


        // Cast context


        Function f = null;

        Consumer c = null;

        Supplier s = null;

    }
}
