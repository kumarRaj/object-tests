package com.tw.rajkum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

class equalsPerson extends Person {
    public equalsPerson(int age, String name) {
        super(age, name);
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person))
            return false;
        Person person = (Person) obj;
        if (this.hashCode() == person.hashCode())
            if (this.getAge() == person.getAge())
                if (this.getName() == person.getName())
                    return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().length() + this.getAge();
    }
}

public class PersonTest {
    @Test
    public void test2PersonsEqualsWithoutImplementingEquals() {
        Person pallavi = new Person(84, "Pallavi");
        Person golliwale = new Person(84, "golliwale");

        assertEquals(false, pallavi.equals(golliwale));
        assertEquals(false, pallavi == golliwale);
    }

    @Test
    public void test2PersonsEqualsOnImplementingEquals() {
        equalsPerson pallavi1 = new equalsPerson(84, "Pallavi");
        equalsPerson pallavi2 = new equalsPerson(84, "Pallavi");

        assertEquals(true, pallavi1.equals(pallavi2));
        assertEquals(true, pallavi2.equals(pallavi1));
        assertEquals(false, pallavi1 == pallavi2);
    }

    @Test
    public void test2PersonsNotEqualsOnImplementingEquals() {
        equalsPerson pallavi1 = new equalsPerson(84, "Pallavi");
        equalsPerson golliwale = new equalsPerson(84, "Golliwale");

        assertEquals(false, pallavi1.equals(golliwale));
        assertEquals(false, pallavi1 == golliwale);
        assertEquals(true, golliwale == golliwale);
    }

    @Test
    public void test2PersonsHashCode() {
        equalsPerson pallavi1 = new equalsPerson(84, "Pallavi");
        equalsPerson golliwale = new equalsPerson(84, "Golliwale");

        assertEquals(false, pallavi1.hashCode() == golliwale.hashCode());
        assertEquals(true, pallavi1.hashCode() == pallavi1.hashCode());
    }

    @Test
    public void testInsertInHashMapShouldOverWriteForSameData() {
        equalsPerson pallavi1 = new equalsPerson(84, "Pallavi");
        equalsPerson pallavi2 = new equalsPerson(84, "Pallavi");
        HashMap<equalsPerson, equalsPerson> people = new HashMap<equalsPerson, equalsPerson>();
        people.put(pallavi1, pallavi1);
        people.put(pallavi2, pallavi2);
        assertEquals(1, people.size());
    }

    @Test
    public void testInsertInHashMapShouldNotOverWriteIfEqualsNotImplemented() {
        Person pallavi1 = new Person(84, "Pallavi");
        Person pallavi2 = new Person(84, "Pallavi");
        HashMap<Person, Person> people = new HashMap<Person, Person>();
        people.put(pallavi1, pallavi1);
        people.put(pallavi2, pallavi2);
        assertEquals(2, people.size());
    }

    @Test
    public void testInsertInSetShouldOverWrite() {
        equalsPerson pallavi1 = new equalsPerson(84, "Pallavi");
        equalsPerson pallavi2 = new equalsPerson(84, "Pallavi");
        Set<equalsPerson> people = new HashSet<equalsPerson>();
        people.add(pallavi1);
        people.add(pallavi2);
        assertEquals(1, people.size());
    }

    @Test
    public void testInsertInSetShouldNotOverWriteIfHashCodeNotImplemented() {
        Person pallavi1 = new Person(84, "Pallavi");
        Person pallavi2 = new Person(84, "Pallavi");
        Set<Person> people = new HashSet<Person>();
        people.add(pallavi1);
        people.add(pallavi2);
        assertEquals(2, people.size());
    }

    @Test
    public void testInsertInArrayList() {
        Person pallavi1 = new Person(84, "Pallavi");
        Person pallavi2 = new Person(84, "Pallavi");
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(pallavi1);
        people.add(pallavi2);
        assertEquals(2, people.size());
    }

}
