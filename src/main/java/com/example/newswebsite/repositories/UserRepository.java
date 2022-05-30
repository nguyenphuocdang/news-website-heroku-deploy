package com.example.newswebsite.repositories;

import com.example.newswebsite.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{}")
    List<User> findAllUser();

    @Query("{'email': '?0'}")
    Optional<User> findUserByEmail(String email);

    @Query("{_id: '?0'}")
    Optional<User> findUserById(String id);

    @Query("{ 'account.username': '?0'}")
    Optional<User> findUserByUsername(String username);

    @Query("{ _id : {$ne: '?0'}, 'account.username': '?1'}")
    Optional<User> findUserByUsernameButNotTheSameId(String id, String username);

    @Query("{ _id : {$ne: '?0'}, email: '?1'}")
    Optional<User> findUserByEmailButNotTheSameId(String id, String email);
}

