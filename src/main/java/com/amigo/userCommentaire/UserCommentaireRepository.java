package com.amigo.userCommentaire;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by andrem on 27/03/2017.
 */
@Repository
public interface UserCommentaireRepository extends MongoRepository<UserCommentaireEntity, String> {
    @Query("{$and: [ {$or : [ { null : ?0 } , { 'name' : ?0 }]}, {$or : [ { null : ?1 } , { 'brand' : ?1 }]}, {$or : [ { null : ?2 } , { typeId : ?2 }]} ] }")
    public List<UserCommentaireEntity> findByOptionalParameters(String name, String brand, String typeId);
    public List<UserCommentaireEntity> findAll();
    public UserCommentaireEntity findById(String id);
}