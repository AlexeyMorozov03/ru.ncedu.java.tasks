package ru.ncedu.java.tasks;

public class TestReflectionsImpl {
    public static void testGetFieldValueByName() {
        Reflections.SecretClass secretClassInstance = new Reflections.SecretClass("ololo");
        Reflections reflection = new ReflectionsImpl();

        try {
            System.out.println(reflection.getFieldValueByName(secretClassInstance, "text"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testGetFieldValueByName();
    }
}
