package ru.ncedu.java.tasks;

public class ClassForTestingReflection2 extends ClassForTestingReflection {
    public ClassForTestingReflection2(int index, String text) {
        super(index, text);
    }

    @Override
    public String getMessage(){
        return "Class Two";
    }
}
