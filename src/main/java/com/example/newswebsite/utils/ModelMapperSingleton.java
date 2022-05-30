package com.example.newswebsite.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperSingleton {

    private static ModelMapperSingleton instance;
    private ModelMapperSingleton(){}

    public static ModelMapperSingleton getInstance(){
        if(instance == null){
            synchronized (ModelMapperSingleton.class){
                if(instance == null){
                    instance = new ModelMapperSingleton();
                }
            }
        }
        return instance;
    }

    public ModelMapper modelMapper(){
        //Tạo object và cấu hình
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}
