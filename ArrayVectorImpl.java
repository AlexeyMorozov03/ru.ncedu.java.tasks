package ru.ncedu.java.tasks;

import java.util.Arrays;
import static java.lang.Math.sqrt;

public class ArrayVectorImpl implements ArrayVector {
    private double[] array;

    public ArrayVectorImpl(){}

    public ArrayVectorImpl(double... args){
        array = args;
    }

    @Override
    public void set(double... elements) {
        array = elements;
    }

    @Override
    public double[] get() {
        return array;
    }

    @Override
    public ArrayVector clone() {
        return new ArrayVectorImpl(array.clone());
    }

    @Override
    public int getSize() {
        return array.length;
    }

    @Override
    public void set(int index, double value) {
        if (index < 0){
            return;
        }
        if (index < array.length){
            array[index] = value;
        } else {
            this.set(Arrays.copyOf(array, index + 1));
            array[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if ((index < 0) && (index >= array.length)){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public double getMax() {
        double max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(array);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < array.length; i++){
            array[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int len = array.length;
        if (anotherVector.getSize() < len){
            len = anotherVector.getSize();
        }
        for (int i = 0; i < len; i++){
            array[i] += anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double scalarMult = 0;
        int len = array.length;
        if (anotherVector.getSize() < len){
            len = anotherVector.getSize();
        }
        for (int i = 0; i < len; i++){
            scalarMult += array[i] * anotherVector.get(i);
        }
        return scalarMult;
    }

    @Override
    public double getNorm() {
        return sqrt(this.scalarMult(this));
    }
}
