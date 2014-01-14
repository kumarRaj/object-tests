package com.tw.rajkum;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringTest {

    @Test
    public void testEqualsWith2StringLiterals(){
        String literal1 = "ram ek ladka hai";

        String literal2 = "ram ek ladka hai";

        assertEquals(true, literal1.equals(literal2));

    }
    @Test
    public void test2StringLiteralsOnEqualEqualSign(){
        String literal1 = "ram ek ladka hai";

        String literal2 = "ram ek ladka hai";

        assertEquals(true,literal1 == literal2);

    }

    @Test
    public void testEqualsWithOneConstructorAndOneLiteral(){
        String literal = "ram ek ladka hai";

        String string = new String("ram ek ladka hai");

        assertEquals(false,literal == string);

    }
    @Test
    public void testWithOneConstructorAndOneLiteralOnEqualEqualSign(){
        String literal = "ram ek ladka hai";

        String string = new String("ram ek ladka hai");

        assertEquals(true,literal.equals(string));

    }
    @Test
    public void testWithTwoConstructorsEquals(){
        String string1 = new String("ram ek ladka hai");

        String string2 = new String("ram ek ladka hai");

        assertEquals(false,string1 == string2);
        assertEquals(true,string1.equals(string2));

    }
    @Test
    public void testWithTwoStringsDifferentValuesEquals(){
        String string1 = new String("ram ek ladka hai");

        String string2 = new String("ram ek ladka nahi hai");

        assertEquals(false,string1 == string2);
        assertEquals(false,string1.equals(string2));

    }
    @Test
    public void testWithTwoLiteralsDifferentValuesEquals(){
        String literal1 = "ram ek ladka hai";

        String literal2 = "ram ek ladka nahi hai";

        assertEquals(false,literal1 == literal2);
        assertEquals(false,literal1.equals(literal2));

    }

}
