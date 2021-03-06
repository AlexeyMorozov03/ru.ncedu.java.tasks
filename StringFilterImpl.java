package ru.ncedu.java.tasks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.lang.Character.isDigit;

public class StringFilterImpl implements StringFilter {
    private Set set = new HashSet();

    @Override
    public void add(String s) {
        if (s != null){
            set.add(s.toLowerCase());
        }else {
            set.add(s);
        }

    }

    @Override
    public boolean remove(String s) {
        String buf = null;
        if (s != null){
            buf = s.toLowerCase();
        }
        if (set.contains(buf)){
            set.remove(buf);
            return true;
        }
        return false;
    }

    @Override
    public void removeAll() {
        set.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return set;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        final String finalChars = chars;
        Filter stringsContaining = new Filter() {
            @Override
            public boolean checkStringMatch(String checkedString) {
                boolean result = false;

                if ((finalChars == null) || (finalChars.length() == 0)){
                    result = true;
                }

                else if (checkedString != null){
                    result = checkedString.contains(finalChars.subSequence(0, finalChars.length()));
                }

                return result;
            }
        };

        return getIterator(stringsContaining);
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        final String finalBegin = begin != null ? begin.toLowerCase() : null;

        Filter stringsStartingWith = new Filter() {
            @Override
            public boolean checkStringMatch(String checkedString) {
                boolean result = false;

                if (((finalBegin == null) || (finalBegin.length() == 0))){
                    result = true;
                }

                else if (checkedString != null){
                    result = checkedString.indexOf(finalBegin) == 0;
                }

                return result;
            }
        };

        return getIterator(stringsStartingWith);
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        final String finalFormat = format;
        Filter stringsByNumberFormat = new Filter() {
            @Override
            public boolean checkStringMatch(String checkedString) {
                boolean result = false;

                if ((finalFormat == null) || (finalFormat.length() == 0)){
                    result = true;
                }

                else if ((checkedString != null) && (checkedString.length() == finalFormat.length())){
                    boolean error = false;

                    for (int j = 0; j < finalFormat.length(); j++){
                        if ((finalFormat.toCharArray()[j] == '#') && (!isDigit(checkedString.toCharArray()[j]))){
                            error = true;
                        }

                        if ((finalFormat.toCharArray()[j] != '#') && (finalFormat.toCharArray()[j] != checkedString.toCharArray()[j])){
                            error = true;
                        }
                    }

                    if (!error){
                        result = true;
                    }
                }
                return result;
            }
        };
        return getIterator(stringsByNumberFormat);
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        final String finalPattern = pattern;
        Filter stringsByPattern = new Filter() {
            @Override
            public boolean checkStringMatch(String checkedString) {
                int firstIndexWildcard;
                int lastIndexWildcard;
                boolean result = false;

                if ((finalPattern == null) || (finalPattern.length() == 0)){
                    result = true;
                }

                else {
                    firstIndexWildcard = finalPattern.indexOf('*');
                    lastIndexWildcard = finalPattern.lastIndexOf('*');

                    if (checkedString != null){
                        if ((firstIndexWildcard == -1) && (finalPattern.compareTo(checkedString) == 0)){
                            result = true;
                        }

                        else if ((firstIndexWildcard == 0) && (lastIndexWildcard == finalPattern.length() - 1) && (checkedString.contains(finalPattern.subSequence(1, finalPattern.length() - 1)))){
                            result = true;
                        }

                        else if (firstIndexWildcard == lastIndexWildcard){
                            if (((checkedString.length() + 1) >= finalPattern.length()) && (finalPattern.substring(0, firstIndexWildcard).compareTo(checkedString.substring(0, firstIndexWildcard)) == 0) && (finalPattern.substring(firstIndexWildcard + 1, finalPattern.length()).compareTo(checkedString.substring(checkedString.length() - (finalPattern.length() - firstIndexWildcard) + 1, checkedString.length()))  == 0)){
                                result = true;
                            }
                        }

                        else if (((checkedString.length() + 2) >= finalPattern.length()) && (finalPattern.substring(0, firstIndexWildcard).compareTo(checkedString.substring(0, firstIndexWildcard)) == 0) && (finalPattern.substring(lastIndexWildcard + 1, finalPattern.length()).compareTo(checkedString.substring(checkedString.length() - (finalPattern.length() - lastIndexWildcard) + 1, checkedString.length()))  == 0)){
                            if(checkedString.substring(firstIndexWildcard, checkedString.length() - (finalPattern.length() - lastIndexWildcard - 1)).contains(finalPattern.subSequence(firstIndexWildcard + 1, lastIndexWildcard))){
                                result = true;
                            }
                        }
                    }

                }
                return result;
            }
        };
        return getIterator(stringsByPattern);
    }

    private interface Filter {
        boolean checkStringMatch(String checkedString);
    }

    private Iterator<String> getIterator(Filter filter){
        Set<String> result = new HashSet<String>();

        for (Iterator<String> i = set.iterator(); i.hasNext();){
            String s = i.next();
            if (filter.checkStringMatch(s)){
                result.add(s);
            }
        }

        Iterator<String> iterator = result.iterator();
        return iterator;
    }
}
