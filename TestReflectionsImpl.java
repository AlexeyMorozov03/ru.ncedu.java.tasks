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

    public static void testGetProtectedMethodNames() {
        Reflections reflection = new ReflectionsImpl();
        Class clazz = null;

        try {
            clazz = Class.forName("ru.ncedu.java.tasks.ClassForTestingReflection");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Class was not found.", e);
        }

        System.out.println(reflection.getProtectedMethodNames(clazz));
    }

    public static void main(String[] args) {
        testGetProtectedMethodNames();
    }
}
