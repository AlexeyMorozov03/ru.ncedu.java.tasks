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
        return null;
    }
}
