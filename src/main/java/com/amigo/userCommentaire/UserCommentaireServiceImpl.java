package com.amigo.userCommentaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
@Service
public class UserCommentaireServiceImpl implements UserCommentaireService {
    @Autowired
    UserCommentaireRepository commentaireRepository;
    @Override
    public List<UserCommentaireDto> getAllUserCommentaire(){
        return UserCommentaireAdapter.fromProductListToDtoList(commentaireRepository.findAll());
    }
    @Override
    public List<UserCommentaireDto> getSelectedUserCommentaire(String name, String brand, String typeId){
        return UserCommentaireAdapter.fromProductListToDtoList(commentaireRepository.findByOptionalParameters(name, brand, typeId));
    }
    @Override
    public UserCommentaireDto createUserCommentaire(UserCommentaireDto productDto){
        commentaireRepository.save(UserCommentaireAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public UserCommentaireDto deleteUserCommentaire(String id){
        UserCommentaireEntity productToDelete = commentaireRepository.findById(id);
        commentaireRepository.delete(productToDelete);
        return UserCommentaireAdapter.fromVoyagetToDto(productToDelete);
    }
    @Override
    public UserCommentaireDto updateUserCommentaire(UserCommentaireDto productDto){
        commentaireRepository.save(UserCommentaireAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public UserCommentaireDto getUserCommentaireById(String id){
        UserCommentaireEntity productToRetrieve = commentaireRepository.findById(id);
        return UserCommentaireAdapter.fromVoyagetToDto(productToRetrieve);
    }

}
