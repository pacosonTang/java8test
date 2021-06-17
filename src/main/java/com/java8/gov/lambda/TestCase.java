package com.java8.gov.lambda;

import com.java8.gov.lambda.basic.BusiMethod;
import com.java8.gov.lambda.basic.Person;
import com.java8.gov.lambda.check.CheckPerson;
import com.java8.gov.lambda.check.CheckPersonEligibleForSelectiveService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  测试案例
 */
public class TestCase {

    public static List<Person> personlist = new ArrayList<>();

    static {
        personlist.add(new Person("zhangsan", 10, Person.Sex.MALE));
        personlist.add(new Person("lisi", 15, Person.Sex.MALE));
        personlist.add(new Person("wangwu", 20, Person.Sex.FEMALE));
        personlist.add(new Person("zhaoliu", 25, Person.Sex.FEMALE));
        personlist.add(new Person("tianqi", 25, Person.Sex.MALE));
        personlist.add(new Person("wangba", 24, Person.Sex.MALE));
    }

    // 使用接口实例实现
    @Test
    public void test1() {
        BusiMethod.printPersons3(personlist, new CheckPersonEligibleForSelectiveService());
    }

    // 使用匿名内部类
    @Test
    public void test2() {
        BusiMethod.printPersons3(personlist, new CheckPerson() {
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });
    }

    // 使用 lambda 表达式
    @Test
    public void test3() {
        BusiMethod.printPersons3(personlist, p -> {
            return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
        });
    }

    // 使用 lambda 表达式，【简写版】
    @Test
    public void test3_1() {
        BusiMethod.printPersons3(personlist, p ->
            p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25
        );
    }

    /**
     * 使用 java8自带的标准函数式断言接口，筛选满足条件的元素，并打印
     */
    @Test
    public void test4() {
        BusiMethod.printWithPredicate(
                personlist,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
    }

    /**
     * 【方法5】 加工person，加工或处理方法由调用方提供，执行方不提供；
     *  对校验通过的person，打印person
     */
    @Test
    public void test5() {
        BusiMethod.processWithPredicateConsumer(
                personlist
                , p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
                , p->p.printPerson()
        );
    }

    /**
     * 【方法5】 加工person，加工或处理方法由调用方提供，执行方不提供；
     *  对校验通过的person，打印person
     */
    @Test
    public void test6() {
        List<String> result = BusiMethod.processWithPredicateFunction(
                personlist
                , p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
                , p -> p.getName()
        );
        System.out.println(result);
    }

    /**
     * 【方法5】 加工person，加工或处理方法由调用方提供，执行方不提供；
     *  对校验通过的person，
     */
    @Test
    public void test7() {
        BusiMethod.processWithPredicateFunctionConsumer(
                personlist
                , p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
                , p-> p.getName()
                , x -> System.out.println(x)
        );
    }

}
