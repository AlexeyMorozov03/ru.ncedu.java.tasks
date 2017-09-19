package ru.ncedu.java.tasks;

public class ClassForTestingReflection {
    private int index;
    private String text;

    public ClassForTestingReflection(int index, String text){
        this.index = index;
        this.text = text;
    }

    protected int getIndex(){
        return index;
    }

    protected String getText(){
        return text;
    }
}
