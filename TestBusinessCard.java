package ru.ncedu.java.tasks;

import java.util.Scanner;

public class TestBusinessCard {
    public static void main(String[] args) {
        String[] data = {
                "bla-bla;bla-bla-bla;BLA;01-01-2001;F;99999;5555555555",
                "Chuck;Norris;DSI;10-04-1940;M;1000;1234567890",};

        Scanner scanner = new Scanner(data[0]);

        BusinessCard subsidiaryObject = new BusinessCardImpl();
        BusinessCard testObject = null;

        try {
            testObject = subsidiaryObject.getBusinessCard(scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(testObject.getEmployee());
        System.out.println(testObject.getDepartment());
        System.out.println(testObject.getAge());
        System.out.println(testObject.getGender());
        System.out.println(testObject.getSalary());
        System.out.println(testObject.getPhoneNumber());
    }
}




