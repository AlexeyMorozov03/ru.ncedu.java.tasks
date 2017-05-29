package ru.ncedu.java.tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusinessCardImpl implements BusinessCard {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String department;
    private int salary;
    private String phoneNumber;

    @Override
    public BusinessCard getBusinessCard(Scanner scanner) {
        BusinessCardImpl object = new BusinessCardImpl();
        scanner.useDelimiter("\\s*;\\s*");

        // firstName
        if (scanner.hasNext()){
            String name = scanner.next();
            Pattern pattern = Pattern.compile("^[A-Za-z-]{1,}$"); // "Chuck"
            if (wrapperMatcher(name, pattern)){
                object.firstName = name;
            }
        }else {
            throw new NoSuchElementException();
        }

        // lastName
        if (scanner.hasNext()){
            String lastName = scanner.next();
            Pattern pattern = Pattern.compile("^[A-Za-z-]{1,}$"); // "Norris"
            if (wrapperMatcher(lastName, pattern)){
                object.lastName = lastName;
            }
        }else {
            throw new NoSuchElementException();
        }

        // department
        if (scanner.hasNext()){
            String department = scanner.next();
            Pattern pattern = Pattern.compile("^[A-Za-z]{1,}$"); // "DSI"
            if (wrapperMatcher(department, pattern)){
                object.department = department;
            }
        }else {
            throw new NoSuchElementException();
        }

        // birth date
        if (scanner.hasNext()){
            String date = scanner.next();
            Pattern pattern = Pattern.compile("^[0-9]{2}-[0-9]{2}-[0-9]{4}$"); // "10-04-1940"

            if (wrapperMatcher(date, pattern)){
                Calendar currentCalendar = Calendar.getInstance();
                Calendar birthCalendar = Calendar.getInstance();

                SimpleDateFormat formatter  = new SimpleDateFormat("dd-MM-yyyy");

                try {
                    Date dateBirth = formatter.parse(date);
                    birthCalendar.setTime(dateBirth);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                long diff = currentCalendar.getTimeInMillis() - birthCalendar.getTimeInMillis();
                long seconds = diff / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                long days = hours / 24;
                long years = days / 365;

                object.age = (int)years;
            }
        }else {
            throw new NoSuchElementException();
        }

        // gender
        if (scanner.hasNext()){
            String gender = scanner.next();
            Pattern pattern = Pattern.compile("^(F|M){1}$"); // "F" or "M"
            if (wrapperMatcher(gender, pattern)){
                if (gender.equals("M")){
                    object.gender = "Male";
                } else if (gender.equals("F")){
                    object.gender = "Female";
                }
            }
        }else {
            throw new NoSuchElementException();
        }

        // salary
        if (scanner.hasNext()){
            int salary = scanner.nextInt();
            if (salary >= 100 && salary <= 100_000){ // 100 - 100_000
                object.salary = salary;
            }else {
                throw new InputMismatchException();
            }
        }else {
            throw new NoSuchElementException();
        }


        // department
        if (scanner.hasNext()){
            String source = scanner.next();
            Pattern pattern = Pattern.compile("^[0-9]{10}$"); // "1234567890"

            if (wrapperMatcher(source, pattern)){
                String phone = "+7" + " " +
                        source.substring(0, 3) + "-" +
                        source.substring(3, 6) + "-" +
                        source.substring(6, 8) + "-"  +
                        source.substring(8, source.length());
                object.phoneNumber = phone;
            }
        }else {
            throw new NoSuchElementException();
        }

        scanner.close();
        return object;
    }

    @Override
    public String getEmployee() {
        return firstName + " " + lastName;
    }

    @Override
    public String getDepartment() { return department; }

    @Override
    public int getSalary() { return salary; }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    private boolean wrapperMatcher(String checkedString, Pattern pattern) throws InputMismatchException{
        Matcher m = pattern.matcher(checkedString);
        boolean result = false;

        if(m.matches()){
            result = true;
        }else {
            throw new InputMismatchException();
        }

        return result;
    }
}

