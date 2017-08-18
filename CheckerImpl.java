package ru.ncedu.java.tasks;

import java.util.List;
import java.util.regex.Pattern;

public class CheckerImpl implements Checker{
    @Override
    public Pattern getPLSQLNamesPattern() {
        Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z0-9_$]{0,29}");
        return pattern;
    }

    @Override
    public Pattern getHrefURLPattern() {
        Pattern pattern = Pattern.compile("<a\\shref\\s?=\\s?https://([^<>]*|)            /?>");
        return null;
    }

    @Override
    public Pattern getEMailPattern() {
        Pattern pattern = Pattern.compile("[A-Za-z0-9][A-Za-z0-9_.-]{0,19}[A-Za-z0-9]{1,1}@" +
                        "([A-Za-z0-9][A-Za-z0-9-]+[A-Za-z0-9]\\.)+(ru|com|net|org)$");
        return pattern;
    }

    @Override
    public boolean checkAccordance(String inputString, Pattern pattern) throws IllegalArgumentException {
        return false;
    }

    @Override
    public List<String> fetchAllTemplates(StringBuffer inputString, Pattern pattern) throws IllegalArgumentException {
        return null;
    }
}
