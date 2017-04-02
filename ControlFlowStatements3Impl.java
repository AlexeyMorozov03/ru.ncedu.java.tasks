package ru.ncedu.java.tasks;

import java.util.Random;

public class ControlFlowStatements3Impl implements ControlFlowStatements3 {
    public static  void main(String... args){
        ControlFlowStatements3Impl object = new ControlFlowStatements3Impl();

        //test getFunctionValue()
        float x = -5;
        float eps = (float) 0.5;
        while (x <= 5) {
            System.out.println("x = " + x + "   f(x) = " + object.getFunctionValue(x));
            x += eps;
        }
        System.out.println();

        //test decodeSeason()
        System.out.println(object.decodeSeason(13));
        System.out.println();

        //test initArray()
        long[][] array = object.initArray();
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //test getMaxProductIndex()
        long[][] testArray = {{5, 5, 3 ,0}, {2, 7, 10, 7}, {1, 1, 100, 0}, {10, 0, 100, 9}};
        System.out.println(object.getMaxProductIndex(testArray));
        System.out.println();

        //test calculateLineSegment()
        Random rand = new Random();
        float A = rand.nextFloat()*20;
        float B = rand.nextFloat()*10;
        System.out.println("A = " + A + " B = " + B + " free line = " + object.calculateLineSegment(A, B));
        System.out.println();


    }
    @Override
    public double getFunctionValue(double x) {
        if(x <= 0){
            return -x;
        }
        if((0 < x) && (x < 2)){
            return x*x;
        }
        else
            return 4;
    }

    @Override
    public String decodeSeason(int monthNumber) {
        switch (monthNumber){
            case 12:case 1:case 2:
                return "Winter";
            case 3:case 4:case 5:
                return "Spring";
            case 6:case 7:case 8:
                return "Summer";
            case 9:case 10:case 11:
                return "Autumn";
            default:
                return "Error";
        }
    }

    @Override
    public long[][] initArray() {
        long[][] array = new long[8][5];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                array[i][j] = (int) Math.pow(Math.abs(i-j), 5);
            }
        }
        return array;
    }

    @Override
    public int getMaxProductIndex(long[][] array) {
        int MaxProductIndex = 0;
        long maxRowValue = 1;
        long temp = 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                temp *= array[i][j];
            }
            if (temp > maxRowValue) {
                maxRowValue = temp;
                MaxProductIndex = i;
            }
            temp = 1;
        }
        return MaxProductIndex;
    }

    @Override
    public float calculateLineSegment(float A, float B) {
        while (A >= B){
            A -= B;
        }
        return A;
    }
}
