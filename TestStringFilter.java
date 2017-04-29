package ru.ncedu.java.tasks;

import java.util.*;

public class TestStringFilter {

    public  static void testAdd(){
        StringFilter a = new StringFilterImpl();
        a.add("Abc");
        a.add("XYZ");
        a.add("abc");
        a.add(null);
        System.out.println(a.getCollection());
    }

    public  static void testRemove(){
        StringFilter a = new StringFilterImpl();
        a.add("Abc");
        a.add("XYZ");
        a.add("abc");
        a.add(null);
        System.out.println(a.getCollection());
        System.out.println(a.remove(null));
        System.out.println(a.remove("XYZ"));
        System.out.println(a.getCollection());
    }

    public  static void testRemoveAll(){
        StringFilter a = new StringFilterImpl();
        a.add("Abc");
        a.add("XYZ");
        a.add("abc");
        a.add(null);
        System.out.println(a.getCollection());
        a.removeAll();
        System.out.println(a.getCollection());
    }

    public  static void testGetCollection(){
        StringFilter a = new StringFilterImpl();
        a.add("Abc");
        a.add("XYZ");
        a.add("abc");
        a.add(null);
        System.out.println(a.getCollection());
    }

    public  static void testGetStringsContaining(){
        StringFilter a = new StringFilterImpl();
        a.add("Abcdef");
        a.add("XYZdef");
        a.add("abc");
        a.add("abcdeef");
        //a.add(null);
        Iterator<String> i = a.getStringsContaining("def");
        for (;i.hasNext();){
            System.out.println(i.next());
        }
    }

    public  static void testGetStringsStartingWith(){
        StringFilter a = new StringFilterImpl();
        a.add("Abcdef");
        a.add("XYZdef");
        a.add(" abc");
        a.add("abcdeef");
        //a.add(null);
        Iterator<String> i = a.getStringsStartingWith("");
        for (;i.hasNext();){
            System.out.println(i.next());
        }
    }

    public  static void testGetStringsByNumberFormat(){
        StringFilter a = new StringFilterImpl();
        a.add("Abcdef");
        a.add("XYZdef");
        a.add(" abc");
        a.add("abcdeef");
        //a.add(null);

        a.add("(000)000-0000");
        a.add("(000)000-0001");
        a.add("(100)000-0000");

        a.add("0 000");
        a.add("0000");

        a.add("-0.00");
        //"(###)###-####", "# ###", "-#.##"
        Iterator<String> i = a.getStringsByNumberFormat( "");
        for (;i.hasNext();){
            System.out.println(i.next());
        }
    }

    public  static void main(String... args){
        testGetStringsByNumberFormat();
    }
}
