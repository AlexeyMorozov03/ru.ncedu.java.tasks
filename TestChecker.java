package ru.ncedu.java.tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestChecker {
    public static void testGetPLSQLNamesPattern(){
        String[] array = {
                "Variable",
                "Variable25",
                "V25ariable",
                "V25",
                "V25Vv",
                "v25Vv",
                "V",
                "V25ariable25",
                "25ariable25",
                "Variableeeeeeeeeeeeeeeeeeeeeee",
                "Variableeeeeeeeeeeeee$eeeeeeee",
                "Variableeeeeeeeeeeeee_eeeeeeee",
                "Variableeeeeeeeeeeeeeeeeeeeeee",
                "VariableeeeeeeeeeeeeeeeeeeeeeeE",
                "vARIABLE"
        };

        Checker checker = new CheckerImpl();
        Pattern pattern = checker.getPLSQLNamesPattern();

        boolean check = true;

        for(String s : array){
            Matcher matcher = pattern.matcher(s);
            if(!matcher.matches()){
                check = false;
                System.out.println("FAIL: " + s);
            }
        }

        if (check){
            System.out.println("TEST: OK");
        }
    }

    public static void testGetHrefURLPattern(){

    }

    public static void testGetEMailPattern(){
        String[] array = {
                "user@d.ru",
                "user@-domen.com",
                "user@domen-.net",
                "user@.domen.org",
                "user@domen..ru",
                "user@-.com",

                "user@domen.net",
                "user@DOMEN.org",
                "user@5domen.ru",
                "user@domen5.com",
                "user@dom5en.net",
                "user@5555.org",
                "user@55-55.ru",
                "user@domen.looking.com",
                "user@domen.looking.kick.net",
                "user@domen.looking.kick.forward.org",
        };

        Checker checker = new CheckerImpl();
        Pattern pattern = checker.getEMailPattern();

        for(String s : array){
            Matcher matcher = pattern.matcher(s);
            if(!matcher.matches()){
                System.out.println("FAIL: " + s);
            }
        }
    }

    public static void main(String[] args) {
        testGetEMailPattern();
    }
}
