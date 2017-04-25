package ru.ncedu.java.tasks;

public class TestArrayVectorImpl {

    public static void testSet(){
        ArrayVectorImpl obj = new ArrayVectorImpl();
        double[] arg = {2.3, 0, -1.95};
        obj.set(2.3, 0, -1.95);
    }

    public static void testGet(){
        ArrayVectorImpl obj = new ArrayVectorImpl();
        double[] arg = {2.3, 0, -1.95};
        obj.set(2.3, 0, -1.95);
        double[] f = obj.get();

        for (double d : f) {
            d += 1;
            System.out.println(d);
        }

        double[] h = obj.get();
        for (double d : h) {
            System.out.println(d);
        }
    }

    public static void testClone(){
        ArrayVectorImpl a = new ArrayVectorImpl(0, -1.1, 2.78);
        ArrayVector b = a.clone();


    }

    public static void testGetSize(){
        ArrayVectorImpl a = new ArrayVectorImpl(0, -1.1, 2.78);
        System.out.println(a.getSize());
    }

    public static void testSetIndex(){
        ArrayVectorImpl a = new ArrayVectorImpl(0, -1.1, 2.78);
        a.set(1, 100);
        double[] h = a.get();
        for (double d: h) {
            System.out.println(d);
        }
        System.out.println();

        a.set(5, 88);
        h = a.get();
        for (double d: h) {
            System.out.println(d);
        }
    }

    public static void testGetItem(){
        ArrayVectorImpl a = new ArrayVectorImpl(0, -1.1, 2.78);
        System.out.println(a.get(2));
    }

    public static void testGetMax(){
        ArrayVectorImpl a = new ArrayVectorImpl(3, 11.1, 2.78);
        System.out.println(a.getMax());
    }

    public static void testGetMin(){
        ArrayVectorImpl a = new ArrayVectorImpl(3, -1.1, 2.78);
        System.out.println(a.getMin());
    }

    public static void testSortAscending(){
        ArrayVectorImpl a = new ArrayVectorImpl(3, -1.1, 2.78);
        a.sortAscending();
        double[] h = a.get();
        for (double d: h) {
            System.out.println(d);
        }
        System.out.println();
    }

    public static void testMult(){
        ArrayVectorImpl a = new ArrayVectorImpl(3, -1.1, 2.78);
        a.mult(2);
        double[] h = a.get();
        for (double d: h) {
            System.out.println(d);
        }
        System.out.println();
    }

    public static void testSum(){
        ArrayVectorImpl a = new ArrayVectorImpl(3, -1.1, 2.78);
        ArrayVectorImpl b = new ArrayVectorImpl(-1, 1);

        a.sum(b);
        double[] h = a.get();
        for (double d: h) {
            System.out.println(d);
        }
        System.out.println();
    }

    public static void testScalarMult(){
        ArrayVectorImpl a = new ArrayVectorImpl(3, -1.1);
        ArrayVectorImpl b = new ArrayVectorImpl(-1, 1, 3);

        System.out.println(a.scalarMult(b));
    }

    public static void testGetNorm(){
        ArrayVectorImpl a = new ArrayVectorImpl(-3, -4, 0, 2);
        System.out.println(a.getNorm());
    }

    public static void main(String... args){
        testGetNorm();
    }
}
