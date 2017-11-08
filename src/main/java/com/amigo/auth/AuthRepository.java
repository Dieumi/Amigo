package com.amigo.auth;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Loïc on 04/04/2017.
 */
@Repository
public interface AuthRepository extends MongoRepository<AuthEntity, String> {
    AuthEntity findByLoginAndPwd(String login, String pwd);
    AuthEntity findByLogin(String login);
    AuthEntity findById(String id);
    List<AuthEntity> findAll();
}

