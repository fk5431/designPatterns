package com.fk5431.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FK on 2017/8/1.
 */
public class Test {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("霍一", "FEMALE", "fat"));
        persons.add(new Person("邓二", "MALE", "thin"));
        persons.add(new Person("张三", "MALE", "fat"));
        persons.add(new Person("李四", "FEMALE", "thin"));
        persons.add(new Person("王五", "MALE", "fat"));
        persons.add(new Person("赵六", "FEMALE", "fat"));
        persons.add(new Person("孙七", "MALE", "fat"));
        persons.add(new Person("罗八", "MALE", "thin"));
        persons.add(new Person("刘九", "FEMALE", "thin"));
        persons.add(new Person("史十", "FEMALE", "fat"));

        List<Person> malePerson = new MaleFilter().filter(persons);
        for (Person p : malePerson) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println();
        List<Person> thinPerson = new ThinFilter().filter(persons);
        for (Person p : thinPerson) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println();
        List<Person> singleAndMalePerson = new FilterAnd(new MaleFilter(), new ThinFilter()).filter(persons);
        for (Person p : singleAndMalePerson) {
            System.out.println(p.toString());
        }
    }
}
