package com.java8.gov.lambda.check;

import com.java8.gov.lambda.basic.Person;

/**
 * person校验实现接口
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
    }
    public CheckPersonEligibleForSelectiveService(){};
}