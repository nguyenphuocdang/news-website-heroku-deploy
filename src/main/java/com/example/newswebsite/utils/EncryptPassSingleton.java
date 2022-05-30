package com.example.newswebsite.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptPassSingleton {
    private static EncryptPassSingleton instance;
    private EncryptPassSingleton(){
    }

    public static EncryptPassSingleton getInstance(){
        if(instance == null){
            synchronized (EncryptPassSingleton.class){
                if(instance == null){
                    instance = new EncryptPassSingleton();
                }
            }
        }
        return instance;
    }

    public String encrypt(String pass){
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(pass, salt);
    }

    public boolean checkHashed(String pass){
        return pass.startsWith("$2a$10$");
    }

    public boolean compare(String rawPass, String encodePass){
        return BCrypt.checkpw(rawPass, encodePass);
    }
}
