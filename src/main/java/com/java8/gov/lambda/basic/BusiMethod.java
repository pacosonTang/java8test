package com.java8.gov.lambda.basic;

import com.java8.gov.lambda.check.CheckPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *  业务场景
 */
public class BusiMethod {
    /**
     * 【测试案例1】筛选年龄大于给定值的person 来打印
     * @param personlist
     * @param age
     */
    public static void printPersonsOlderThan(List<Person> personlist, int age) {
        for (Person p : personlist) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    /**
     * 【测试案例2】 筛选年龄在给定区间的person 来打印
     * @param personlist
     * @param low
     * @param high
     */
    public static void printPersonsWithinAgeRange(
            List<Person> personlist, int low, int high) {
        for (Person p : personlist) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    /**
     * 【方法3】 筛选年龄在给定区间的person 来打印
     * @param personlist
     * @param tester
     */
    public static void printPersons3(
            List<Person> personlist, CheckPerson tester) {
        for (Person p : personlist) {
            if (tester.test(p)) { // 满足条件后，再打印
                p.printPerson();
            }
        }
    }

    /**
     * 【方法4】 使用 java8自带的标准函数式断言接口，筛选满足条件的元素，并打印
     * @param personlist
     * @param tester
     */
    public static void printWithPredicate(
            List<Person> personlist, Predicate<Person> tester) {
        for (Person p : personlist) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * 使用java8 自带的标注函数式接口，断言型接口与消费型接口
     * 对断言型接口方法实例校验通过的person，执行消费型接口方法实例
     * @param personlist
     * @param tester
     * @param consumer
     */
    public static void processWithPredicateConsumer(
            List<Person> personlist,
            Predicate<Person> tester,
            Consumer<Person> consumer
    ) {
        for (Person p : personlist) {
            if (tester.test(p)) {
                consumer.accept(p);
            }
        }
    }

    /**
     * 使用java8 自带的标准函数式接口，断言型接口与函数型接口及消费型接口
     * 对断言型接口方法实例校验通过的person，执行函数型接口方法获得数据并收集，最后返回
     * @param personlist
     * @param tester
     * @param function
     */
    public static List<String> processWithPredicateFunction(
            List<Person> personlist,
            Predicate<Person> tester,
            Function<Person, String> function
    ) {
        List<String> result = new ArrayList<>();
        for (Person p : personlist) {
            if (tester.test(p)) {
                String data = function.apply(p);
                result.add(data != null ? data.toUpperCase() : data);
            }
        }
        return result;
    }

    /**
     * 使用java8 自带的标准函数式接口，断言型接口与函数型接口及消费型接口
     * 对断言型接口方法实例校验通过的person，执行函数型接口方法获得数据，最后执行消费型接口处理数据
     * @param personlist
     * @param tester
     * @param function
     */
    public static void processWithPredicateFunctionConsumer(
            List<Person> personlist,
            Predicate<Person> tester,
            Function<Person, String> function,
            Consumer<String> consumer
            ) {
        for (Person p : personlist) {
            if (tester.test(p)) {
                String data = function.apply(p);
                consumer.accept(data);
            }
        }
    }




}
