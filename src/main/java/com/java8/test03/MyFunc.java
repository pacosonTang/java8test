package com.java8.test03;

// 函数式接口注解 
@FunctionalInterface 
public interface MyFunc {
	
	public Integer getValue(Integer num);
	
//	public void test02(); 这里报错，因为函数式接口只能有一个抽象方法
}
