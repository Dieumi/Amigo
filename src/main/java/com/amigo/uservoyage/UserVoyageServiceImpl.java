package com.amigo.uservoyage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
@Service
public class UserVoyageServiceImpl implements UserVoyageService {
    @Autowired
    UserVoyageRepository userVoyageRepository;
    @Override
    public List<UserVoyageDto> getAllUserVoyages(){
        return UserVoyageAdapter.fromProductListToDtoList(userVoyageRepository.findAll());
    }
    @Override
    public List<UserVoyageDto> getSelectedUserVoyage(String name, String brand, String typeId){
        return UserVoyageAdapter.fromProductListToDtoList(userVoyageRepository.findByOptionalParameters(name, brand, typeId));
    }
    @Override
    public UserVoyageDto createUserVoyage(UserVoyageDto productDto){
        userVoyageRepository.save(UserVoyageAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public UserVoyageDto deleteUserVoyage(String id){
        UserVoyageEntity productToDelete = userVoyageRepository.findById(id);
        userVoyageRepository.delete(productToDelete);
        return UserVoyageAdapter.fromVoyagetToDto(productToDelete);
    }
    @Override
    public UserVoyageDto updateUserVoyage(UserVoyageDto productDto){
        userVoyageRepository.save(UserVoyageAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public UserVoyageDto getUserVoyageById(String id){
        UserVoyageEntity productToRetrieve = userVoyageRepository.findById(id);
        return UserVoyageAdapter.fromVoyagetToDto(productToRetrieve);
    }

    @Override
    public List<UserVoyageDto> getListUserVoyageByIdUser(String id) {
        List<UserVoyageEntity> productToRetrieve = userVoyageRepository.findAllByIdUserAndNoteEquals(id,0);
        return UserVoyageAdapter.fromProductListToDtoList(productToRetrieve);
    }

}
