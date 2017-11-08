package com.amigo.type;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;




public interface TypeRepository extends MongoRepository<Type, String>{

	@Query("{$and: [ {$or : [ { null : ?0 } , { 'name' : ?0 }]}, {$or : [ { null : ?1 } , { 'brand' : ?1 }]}, {$or : [ { null : ?2 } , { typeId : ?2 }]} ] }")
    public List<Type> findByOptionalParameters(String name, String brand, String typeId);
    public List<Type> findAll();
    public Type findByid(String id);
}
