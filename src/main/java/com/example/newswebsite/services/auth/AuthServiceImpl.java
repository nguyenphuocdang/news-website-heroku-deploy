package com.example.newswebsite.services.auth;

import com.example.newswebsite.utils.EncryptPassSingleton;
import com.example.newswebsite.utils.ModelMapperSingleton;
import com.example.newswebsite.dtos.UserDto;
import com.example.newswebsite.entities.User;
import com.example.newswebsite.entities.embedded.AccountEmbedded;
import com.example.newswebsite.exceptions.*;
import com.example.newswebsite.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(UserDto userDto) throws DuplicatedValueException {
        User user = ModelMapperSingleton.getInstance().modelMapper().map(userDto, User.class);
        AccountEmbedded acc =  user.getAccount();
        if(userRepository.findUserByEmail(user.getEmail()).isPresent()){
            throw new DuplicatedValueException("Email existed!!!");
        }
        else if(userRepository.findUserByUsername(user.getPhone()).isPresent()){
            throw new DuplicatedValueException("Username existed!!!");
        }

        acc.setPassword(EncryptPassSingleton.getInstance().encrypt(acc.getPassword()));
        user.setAccount(acc);
        userRepository.save(user);
        return user;
    }

    @Override
    public User login(UserDto userDto) throws NonexistentValueException, IncorrectValueException {
        User user = ModelMapperSingleton.getInstance().modelMapper().map(userDto, User.class);
        Optional<User> existedUser = userRepository.findUserByEmail(user.getEmail());
        if(existedUser.isEmpty()){
            throw new NonexistentValueException("User does not exist!!!");
        }
        AccountEmbedded acc = existedUser.get().getAccount();
        if(!EncryptPassSingleton.getInstance().compare(userDto.getAccount().getPassword(), acc.getPassword())){
            throw new IncorrectValueException("Wrong Password, please try again!!!");
        }else
            return existedUser.get();
    }
}
