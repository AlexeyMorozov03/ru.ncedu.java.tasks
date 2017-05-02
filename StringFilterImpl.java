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
        Set<String> result = new HashSet<String>();

        for (Iterator<String> i = set.iterator(); i.hasNext();){
            String s = i.next();
            if ((chars == null) || (s.contains(chars.subSequence(0, chars.length())))){
                result.add(s);
            }
        }

        Iterator<String> iterator = result.iterator();
        return iterator;
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        String beginLowerCase = null;
        if (begin != null){
            beginLowerCase = begin.toLowerCase();
        }
        Set<String> result = new HashSet<String>();

        for (Iterator<String> i = set.iterator(); i.hasNext();){
            String s = i.next();
            if ((beginLowerCase == null) || (s.indexOf(beginLowerCase) == 0)){
                result.add(s);
            }
        }

        Iterator<String> iterator = result.iterator();
        return iterator;
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        Set<String> result = new HashSet<String>();

        for (Iterator<String> i = set.iterator(); i.hasNext();){
            String s = i.next();
            if ((format == null) || (format.length() == 0)){
                result.add(s);
            }else if (s.length() == format.length()){
                boolean error = false;
                for (int j = 0; j < format.length(); j++){
                    if ((format.toCharArray()[j] == '#') && (!isDigit(s.toCharArray()[j]))){
                        error = true;
                    }
                    if ((format.toCharArray()[j] != '#') && (format.toCharArray()[j] != s.toCharArray()[j])){
                        error = true;
                    }
                }
                if (!error){
                    result.add(s);
                }
            }
        }

        Iterator<String> iterator = result.iterator();
        return iterator;
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        Set<String> result = new HashSet<String>();
        int firstIndexWildcard;
        int lastIndexWildcard;

        for (Iterator<String> i = set.iterator(); i.hasNext();){
            String s = i.next();

            if ((pattern == null) || (pattern.length() == 0)){
                result.add(s);
            }

            else {
                firstIndexWildcard = pattern.indexOf('*');
                lastIndexWildcard = pattern.lastIndexOf('*');

                if ((firstIndexWildcard == -1) && (pattern.compareTo(s) == 0)){
                    result.add(s);
                }

                else if ((firstIndexWildcard == 0) && (lastIndexWildcard == pattern.length() - 1) && (s.contains(pattern.subSequence(1, pattern.length() - 1)))){
                    result.add(s);
                }

                else if (firstIndexWildcard == lastIndexWildcard){
                    if (((s.length() + 1) >= pattern.length()) && (pattern.substring(0, firstIndexWildcard).compareTo(s.substring(0, firstIndexWildcard)) == 0) && (pattern.substring(firstIndexWildcard + 1, pattern.length()).compareTo(s.substring(s.length() - (pattern.length() - firstIndexWildcard) + 1, s.length()))  == 0)){
                        result.add(s);
                    }
                }

                else if (((s.length() + 2) >= pattern.length()) && (pattern.substring(0, firstIndexWildcard).compareTo(s.substring(0, firstIndexWildcard)) == 0) && (pattern.substring(lastIndexWildcard + 1, pattern.length()).compareTo(s.substring(s.length() - (pattern.length() - lastIndexWildcard) + 1, s.length()))  == 0)){
                    if(s.substring(firstIndexWildcard, s.length() - (pattern.length() - lastIndexWildcard - 1)).contains(pattern.subSequence(firstIndexWildcard + 1, lastIndexWildcard))){
                        result.add(s);
                    }
                }
            }
        }

        Iterator<String> iterator = result.iterator();
        return iterator;
    }
}
