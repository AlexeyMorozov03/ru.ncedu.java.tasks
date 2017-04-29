package ru.ncedu.java.tasks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        return null;
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        return null;
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        return null;
    }
}
