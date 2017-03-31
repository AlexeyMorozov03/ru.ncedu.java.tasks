package ru.ncedu.java.tasks;

public class ControlFlowStatements1Impl implements ControlFlowStatements1{
    public static void main(String... args) {
        ControlFlowStatements1Impl object = new ControlFlowStatements1Impl();

        //test getFunctionValue()
        float x = -5;
        float eps = (float) 0.5;
        while (x <= 5) {
            System.out.println("x = " + x + "   f(x) = " + object.getFunctionValue(x));
            x += eps;
        }
        System.out.println();

        //test decodeWeekday()
        for(int i = -1; i < 9; i++){
            System.out.println("Day " + i + " of the week is " + object.decodeWeekday(i) + ".");
        }
        System.out.println();

        //test initArray()
        int [][] array = object.initArray();
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");// добавить форматированный вывод
            }
            System.out.println();
        }
        System.out.println();

        //test getMinValue()
        int [][] testArray = {{5, 5, 3 ,2}, {2, 0, 10, 7}, {1, 1, 100, 9}};
        System.out.println(object.getMinValue(testArray));
        System.out.println();

        //test calculateBankDeposit()
        BankDeposit deposit = new BankDeposit();
        deposit = object.calculateBankDeposit(12.5);
        System.out.println(deposit.toString());
    }

    @Override
    public float getFunctionValue(float x) {
        if (x > 0) {
            return (float) (2 * Math.sin(x));
        }
        else {
            return 6 - x;
        }
    }

    @Override
    public String decodeWeekday(int weekday) {
        switch (weekday){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Invalid weekday";
        }
    }

    @Override
    public int[][] initArray() {
        int[][] array = new int[8][5];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                array[i][j] = i * j;
            }
        }
        return array;
    }

    @Override
    public int getMinValue(int[][] array) {
        int minElement = array[0][0];
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] < minElement){
                    minElement = array[i][j];
                }
            }
        }
        return minElement;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit object = new BankDeposit();
        object.amount = 1000;
        P /= 100;
        while (object.amount <= 5000){
            object.years += 1;
            object.amount += object.amount * P;
        }
        return object;
    }
}
