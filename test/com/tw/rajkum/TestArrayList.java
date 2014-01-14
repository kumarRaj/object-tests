package com.tw.rajkum;

import org.junit.Test;

import java.util.ArrayList;

public class TestArrayList {
    @Test(expected = ClassCastException.class)
    public void testArrayList() {
        Person swamiji = new Person(3, "Swamiji");
        ArrayList people = new ArrayList<Person>();
        people.add(swamiji);
        people.add("Ram");
        Person p = (Person) people.get(1);
    }

    @Test
    public void testArrayListToHaveItsSubClasses() {
        ArrayList<? extends Person> people = new ArrayList<Person>();
        ArrayList list = people;
        Person swamiji = new Person(3, "Swamiji");
        Person somebody = new Person(12, "Duba Part 1") {
            int id;
        };
        Person other = new Person(12, "Duba Part 2") {
            int id;
        };
        list.add(swamiji);
        list.add(somebody);
        list.add(other);
        for (Object person : list) {
            Person p = (Person) person;
        }
    }
}
