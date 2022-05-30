package com.example.newswebsite.utils;

import java.lang.reflect.Field;

public class LoopObjectSingleton {
    private static LoopObjectSingleton instance;
    private LoopObjectSingleton(){}
    public static LoopObjectSingleton getInstance(){
        if(instance == null){
            synchronized (LoopObjectSingleton.class){
                if(instance == null){
                    instance = new LoopObjectSingleton();
                }
            }
        }
        return instance;
    }

    public void mergingContent(Class targetClass, Object targetObject, Object oldTargetObject){
        for (Field field : targetClass.getDeclaredFields()) {
            field.setAccessible(true);
            try{
                if(field.get(targetObject) == ""){
                    field.set(targetObject, field.get(oldTargetObject));
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
