package com.tw.rajkum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;


public class MyComparatorTest {
    public static List addPeopleToList(Person... persons) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : persons) {
            people.add(person);
        }
        return people;
    }

    @Test
    public void testPersonsSortbyname() {
        Person swamiji = new Person(3, "Swamiji");
        Person kunal = new Person(50, "Kunal");
        Person digvijay = new Person(35, "Digvijay");
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people);
        assertEquals(true, people.get(0) == digvijay);
        assertEquals(true, people.get(1) == kunal);
        assertEquals(true, people.get(2) == swamiji);
    }

    @Test
    public void PersonsSortByNamesLength() {
        Person swamiji = new Person(3, "Swamiji");
        Person kunal = new Person(50, "Kunal");
        Person digvijay = new Person(35, "Digvijay");
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().length() - p2.getName().length();
            }
        });
        assertEquals(true, people.get(0) == kunal);
        assertEquals(true, people.get(1) == swamiji);
        assertEquals(true, people.get(2) == digvijay);
    }

    @Test
    public void PersonsSortByAge() {
        Person swamiji = new Person(3, "Swamiji");
        Person kunal = new Person(50, "Kunal");
        Person digvijay = new Person(35, "Digvijay");
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        assertEquals(true, people.get(0) == swamiji);
        assertEquals(true, people.get(1) == digvijay);
        assertEquals(true, people.get(2) == kunal);
    }
    @Test
    public void PersonsSortReverse() {
        Person swamiji = new Person(3, "Swamiji");
        Person kunal = new Person(50, "Kunal");
        Person digvijay = new Person(35, "Digvijay");
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return -1 * p1.compareTo(p2);
            }
        });
        assertEquals(true, people.get(0) == swamiji);
        assertEquals(true, people.get(1) == kunal);
        assertEquals(true, people.get(2) == digvijay);
    }
}