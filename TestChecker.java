package ru.ncedu.java.tasks;

import java.util.List;
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
        String[] array = {
                "< a href = https://www.google.com >",
                "<\ta\thref\t=\thttps://www.google.com\t>",
                "<\ta\nhref\r=\fhttps://www.google.com >",
                "<\t\n\r\f a href = https://www.google.com >",
                "<\f\r\n\t a href = https://www.google.com >",
                "<a href = https://www.google.com >",
                "<ahref=https://www.google.com>",
                "<ahref=w>",

                "< a href = \"https://www.go ogle.com\" >",
                "< a href = \"https://www.go\togle.com\" >",
                "< a href = \"https://www.go\nogle.com\" >",
                "< a href = \"https://www.go\rogle.com\" >",
                "< a href = \"https://www.go\fogle.com\" >",

                "< a href = \"https://www.go ogle.com\" />",
                "< a href = \"https://www.go\togle.com\" />",
                "< a href = \"https://www.go\nogle.com\" />",
                "< a href = \"https://www.go\rogle.com\" />",
                "< a href = \"https://www.go\fogle.com\" />",

                "< a href = https://www.go ogle.com >",
                "< a href = https://www.go\togle.com >",
                "< a href = https://www.go\nogle.com >",
                "< a href = https://www.go\rogle.com >",
                "< a href = https://www.go\fogle.com >",

                "< a href = \t\t\t >",
                "\"distant\""
        };

        Checker checker = new CheckerImpl();
        Pattern pattern = checker.getHrefURLPattern();

        for(String s : array){
            Matcher matcher = pattern.matcher(s);
            if(!matcher.matches()){
                System.out.println("FAIL: " + s);
            }
        }
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

    public static void testCheckAccordance(){
        Checker checker = new CheckerImpl();

        Pattern pattern = Pattern.compile("^[aA]+");
        String s = "aAA";

        System.out.println(checker.checkAccordance(s, pattern));
    }

    public static void testFetchAllTemplates(){
        StringBuffer testStringBuffer = new StringBuffer("Google-BOOBLE-MOONT_###&&&_111111_doodle");
        Pattern pattern = Pattern.compile("[a-z]{6,6}", Pattern.CASE_INSENSITIVE);
        Checker checker = new CheckerImpl();
        List<String> list;
        list = checker.fetchAllTemplates(testStringBuffer, pattern);
        System.out.println(list);
    }

    public static void main(String[] args) {
        testFetchAllTemplates();
    }
}
