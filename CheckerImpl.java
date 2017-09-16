package ru.ncedu.java.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerImpl implements Checker{
    @Override
    public Pattern getPLSQLNamesPattern() {
        Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z0-9_$]{0,29}");
        return pattern;
    }

    @Override
    public Pattern getHrefURLPattern() {
        Pattern pattern = Pattern.compile("<[\t\n\r\f ]*(A|a)[\t\n\r\f ]*(HREF|href)[\t\n\r\f ]*=[\t\n\r\f ]*([\\S]|\"[^\"]+\")+[\t\n\r\f ]*/?>");
        return pattern;
    }

    @Override
    public Pattern getEMailPattern() {
        Pattern pattern = Pattern.compile("[A-Za-z0-9][A-Za-z0-9_.-]{0,19}[A-Za-z0-9]{1,1}@" +
                        "([A-Za-z0-9][A-Za-z0-9-]+[A-Za-z0-9]\\.)+(ru|com|net|org)$");
        return pattern;
    }

    @Override
    public boolean checkAccordance(String inputString, Pattern pattern) throws IllegalArgumentException {
        if (inputString == null && pattern == null){
            return true;
        }

        if ((inputString == null && pattern != null) || (inputString != null && pattern == null)){
            throw new IllegalArgumentException();
        }

        Matcher matcher = pattern.matcher(inputString);

        if(matcher.matches()){
            return true;
        }

        return false;
    }

    @Override
    public List<String> fetchAllTemplates(StringBuffer inputString, Pattern pattern) throws IllegalArgumentException {
        if(inputString == null || pattern == null){
            throw new IllegalArgumentException();
        }

        List<String> list = new ArrayList<>();

        Matcher matcher = pattern.matcher(inputString);

        boolean continueSearch = true;

        int startIndex = 0;

        while(continueSearch){
            if (matcher.find(startIndex)){
                list.add(matcher.group());
                startIndex = matcher.end();
            }else {
                continueSearch = false;
            }
        }

        return list;
    }
}
