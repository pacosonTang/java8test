
package com.java8.test08;

import com.java8.test02.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流式操作-来自网络
 */
public class TestStreamApi0801 {

	@Test
	public void test1() {
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("筛选列表: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: " + mergedString);
	}
}
