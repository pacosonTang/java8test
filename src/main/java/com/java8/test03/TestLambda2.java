package com.java8.test03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * Lambda 基础语法，java8引入了 新操作符 ->，箭头操作符或Lambda 操作符， 该操作符将 Lambda表达式拆分成两部分
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能，称为 Lambda体 
 * 
 * 语法格式1： 无参数，无返回值
 *      () -> System.out.println("hello world");
 * 
 * 语法格式2： 有一个参数，无返回值 
 *      (x) -> System.out.println(x); 
 * 语法格式3： 有一个参数，小括号可以不写
 *      x -> System.out.println(x);
 * 语法格式4：有2个以上的参数，有返回值，lambda体有多条语句
 *      Comparator<Integer> comparator = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y); 
		};
	语法格式5：有2个以上的参数，有返回值，lambda体有1条语句, return和大括号都可以省略不写 
		Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
	
	语法格式6：lambda表达式的参数列表的数据类型可以省略不写， 因为 jvm 编译器可以通过上线文推断出数据类型 ， 这个过程叫做“类型推断”
  
  【补充】 lambda表达式需要函数式接口的支持； 
      什么是函数式接口？ 
      函数式接口(Functional Interface)就是一个有且仅有一个抽象方法的接口。函数式接口可以被隐式转换为 lambda 表达式。
   函数式接口可以使用注解 @FunctionalInterface 修饰下； 可以检查某接口是否是函数式接口

 * @author tang rong 
 * @since 2020/10/13 
 */
public class TestLambda2 {
	
	@Test
	public void test1() {
		int num = 0; // jdk1.7之前，他必须是final 
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world" + num);  // 但num不能 num++ ，因为num默认final  
			}
		};
		// 语法格式1，无参数，无返回值的 Lambda表达式
		Runnable r2 = () -> System.out.println("hello world, this is funtional interface");
		r2.run(); 
	}
	
	@Test
	public void test2() {
		// 语法格式2，有一个参数，无返回值 
		Consumer<String> con = x -> System.out.println(x); 
		con.accept("hello");
	}
	@Test
	public void test3() {
		// 语法格式2，有一个参数，无返回值 
		Consumer<String> con = (x) -> System.out.println(x); 
		con.accept("hello");
		// 语法格式3： 有一个参数，小括号可以不写
		Consumer<String> con2 = x -> System.out.println(x); 
		con2.accept("hello2");
	}
	
	@Test
	public void test4() {
		// 语法格式4：有2个以上的参数，有返回值，lambda体有多条语句, 则lambda体必须使用大括号  
		Comparator<Integer> comparator = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y); 
		};
	}
	@Test
	public void test5() {
		// 语法格式5：有2个以上的参数，有返回值，lambda体有1条语句, return和大括号都可以省略不写    
		Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y); 
	}
	
	@Test
	public void test6() {
		// 语法格式6：lambda表达式的参数列表的数据类型可以省略不写， 因为 jvm 编译器可以通过上线文推断出数据类型 ， 这个过程叫做“类型推断”    
		Comparator<Integer> comparator = (Integer x, Integer y) -> Integer.compare(x, y);
		Comparator<Integer> comparator2 = (x,y) -> Integer.compare(x, y); 
		String[] arr = {"1", "2", "3"}; // 类型推断
		String arr2;
//		arr2 = {"1", "2", "3"}; 
		List<String> list = new ArrayList<>();  // // 类型推断  
	}
	
	@Test
	public void test7() {
		// 使用lambda 表达式实现函数式接口 
		Integer num = operation(100, (x) -> x*x);
		System.out.println(num);
		
		Integer num2 = operation(200, (x) -> x+100);
		System.out.println(num2);
	}
	public Integer operation(Integer num , MyFunc myFunc) {
		return myFunc.getValue(num); 
	}
	
	
	
	
}
