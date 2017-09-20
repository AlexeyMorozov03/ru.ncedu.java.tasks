package ru.ncedu.java.tasks;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionsImpl implements Reflections{
    @Override
    public Object getFieldValueByName(Object object, String fieldName) throws NoSuchFieldException {
        Class clazz = object.getClass();

        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);

        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Value of field was not getting", e);
        }
    }

    @Override
    public Set<String> getProtectedMethodNames(Class clazz) {
        if(clazz == null){
            throw new NullPointerException();
        }

        Set<String> set = new HashSet<>();

        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {
            m.setAccessible(true);
            int modifiers = m.getModifiers();
            if(Modifier.isProtected(modifiers)){
                set.add(m.getName());
            }
        }

        return set;
    }

    @Override
    public Set<Method> getAllImplementedMethodsWithSupers(Class clazz) {
        Set<Method> set = new LinkedHashSet<Method>();
        System.out.println(clazz.getName());
        if(clazz.getName().equals("java.lang.Object")){
            addMethods(set, clazz);
            return set;
        }
        if(clazz == null){
            throw new NullPointerException();
        }
        addMethods(set, clazz);
        set.addAll(this.getAllImplementedMethodsWithSupers(clazz.getSuperclass()));
        return set;
    }

    private void addMethods(Set<Method> set, Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m: methods) {
            m.setAccessible(true);
            set.add(m);
        }
    }

    @Override
    public List<Class> getExtendsHierarchy(Class clazz) {
        List<Class> list = new ArrayList<Class>();
        if(clazz == null){ throw new NullPointerException(); }
        if(clazz.getName().equalsIgnoreCase("java.lang.Object")){ return list; }
        list.add(clazz.getSuperclass());
        list.addAll(this.getExtendsHierarchy(clazz.getSuperclass()));
        return list;
    }

    @Override
    public Set<Class> getImplementedInterfaces(Class clazz) {
        return null;
    }

    @Override
    public List<Class> getThrownExceptions(Method method) {
        return null;
    }

    @Override
    public String getFooFunctionResultForDefaultConstructedClass() {
        return null;
    }

    @Override
    public String getFooFunctionResultForClass(String constructorParameter, String string, Integer... integers) {
        return null;
    }
}
