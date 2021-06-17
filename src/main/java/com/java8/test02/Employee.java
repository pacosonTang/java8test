package com.java8.test02;

public class Employee {
	private String name; 
	private Integer age; 
	private Double salary;
	
	public Employee() {
		super();
	}
	

	public Employee(String name) {
		this.name = name;
	}
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age; 
	}
	
	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1; 
		result = prime * result + (age == null ? 0 : age.hashCode());
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (salary == null ? 0 : salary.hashCode());
		return result; 
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; 
		} else if (obj == null) {
			return false; 
		} else if (getClass() != obj.getClass()) {
			return false; 
		} 
		Employee other = (Employee) obj;
		if (this.age != other.getAge()) {
			return false; 
		}
		if (this.name != null) {
			if (!this.name.equals(other.getName())) {
				return false; 
			}
		} else if (other.getName() != null) {
			if (!other.getName().equals(this.name)) {
				return false; 
			}
		}
		
		if (this.salary != null) {
			if (!this.salary.equals(other.getSalary())) {
				return false; 
			}
		} else if (other.getSalary() != null) {
			if (!other.getSalary().equals(this.salary)) {
				return false; 
			}
		}
		return true; 
	}
}
