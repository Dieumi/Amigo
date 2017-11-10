package com.amigo.voyage;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by andrem on 27/03/2017.
 */
@Repository
public interface VoyageRepository extends MongoRepository<VoyageEntity, String> {
    @Query("{$and: [ {$or : [ { null : ?0 } , { 'name' : ?0 }]}, {$or : [ { null : ?1 } , { 'brand' : ?1 }]}, {$or : [ { null : ?2 } , { typeId : ?2 }]} ] }")
    public List<VoyageEntity> findByOptionalParameters(String name, String brand, String typeId);
    public List<VoyageEntity> findAll();
    public VoyageEntity findById(String id);
    public List<VoyageEntity> findByArriveAndDepartAndDateGreaterThanEqualAndNbplaceGreaterThan(String arr, String dep,String date,int nb);
    public List<VoyageEntity> findByArriveAndDepartAndDateGreaterThanEqualAndHeureDepGreaterThanEqualAndNbplaceGreaterThan(String arr, String dep,String date,String heure,int nb);

}