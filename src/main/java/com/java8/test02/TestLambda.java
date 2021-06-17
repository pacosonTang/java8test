package com.java8.test02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 为什么使用 Lambda
 * @author tang rong
 * @since 2020/10/13 
 */
public class TestLambda {
	@Test 
	public void test1() {
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2); 
			}
		};
		TreeSet<Integer> treeSet = new TreeSet<>(com); 
	}
	
	/* Lambda 表达式 */
	@Test
	public void test2() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		TreeSet<Integer> treeSet = new TreeSet<>(com);
	}
	
	List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9900.99)
			, new Employee("李四", 28, 5500.99)
			, new Employee("王五", 37, 4400.33)
			, new Employee("赵六", 46, 6600.12)
			, new Employee("田七", 59, 3300.54)
	);
	
	@Test
	public void test3() {
		List<Employee> list = this.filterEmployees(employees);
		for (Employee rd : list) {
			System.out.println(rd); 
		}
	}
	
	/* 需求1：获取当前公司中员工年龄大于35的员工信息  */
	public List<Employee> filterEmployees(List<Employee> list) {
		List<Employee> result = new ArrayList<>();
		
		for (Employee emp : list) {
			if (emp.getAge() > 35) {
				result.add(emp); 
			}
		}
		return result; 
	}
	
	/* 需求2：获取当前公司中员工公司大于  5000 的员工信息  */
	public List<Employee> filterEmployees2(List<Employee> list) {
		List<Employee> result = new ArrayList<>();
		
		for (Employee emp : list) {
			if (emp.getSalary() > 5000) {
				result.add(emp); 
			}
		}
		return result; 
	}
	
	/* 优化方式1：通过接口，采用策略设计模式 */
	public List<Employee> filterEmployeesOptimize(List<Employee> list, MyPredict<Employee> mp) {
		List<Employee> result = new ArrayList<>();
		
		for (Employee emp : list) {
			if (mp.test(emp)) {
				result.add(emp); 
			}
		} 
		return result; 
	}
	/* 优化方式2： 匿名内部类  */
	/* 优化方式3： Lambda表达式 */
	@Test 
	public void test6() {
		List<Employee> list = this.filterEmployeesOptimize(employees, e -> e.getSalary() <=5000);
		list.forEach(System.out::println); 
	}

    /**
     * 匿名内部类实现
     */
	@Test
	public void test6copy() {
		List<Employee> list = this.filterEmployeesOptimize(employees, new MyPredict<Employee>() {
			@Override
			public boolean test(Employee employee) {
				return employee.getSalary() > 5000 ;
			}
		});
		list.forEach(System.out::println);
	}
	
	/* 优化方式4： Stream API，假设上面的代码都不存在，即不复用上面的代码    */
	@Test
	public void test7() {
		employees.stream()
		    	 .filter(e->e.getSalary() > 4000)
		    	 .limit(2)
		    	 .forEach(System.out::println);
//		Employee [name=张三, age=18, salary=9900.99]
//		Employee [name=李四, age=28, salary=5500.99]

		employees.stream()
		         .map(Employee::getName)
		         .forEach(System.out::println); 
//		张三
//		李四
//		王五
//		赵六
//		田七
	}
}
