package com.amigo.user.repository;

import com.amigo.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pierre on 25/03/2017.
 */
@Repository

public interface UserRepository  extends MongoRepository<User,String>{
    public User findById(String id);
    public User findByName(String name);
    public User findByLogin(String login);
    public List<User> findByType(String Type);


}
