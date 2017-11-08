package com.amigo.typeVoyage.type;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface TypeVoyageRepository extends MongoRepository<TypeVoyage, String>{

	@Query("{$and: [ {$or : [ { null : ?0 } , { 'name' : ?0 }]}, {$or : [ { null : ?1 } , { 'brand' : ?1 }]}, {$or : [ { null : ?2 } , { typeId : ?2 }]} ] }")
    public List<TypeVoyage> findByOptionalParameters(String name, String brand, String typeId);
    public List<TypeVoyage> findAll();
    public TypeVoyage findByid(String id);
}
