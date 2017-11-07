package com.amigo.Commentaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
@Service
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Override
    public List<CommentaireDto> getAllCommentaire(){
        return CommentaireAdapter.fromProductListToDtoList(commentaireRepository.findAll());
    }
    @Override
    public List<CommentaireDto> getSelectedCommentaire(String name, String brand, String typeId){
        return CommentaireAdapter.fromProductListToDtoList(commentaireRepository.findByOptionalParameters(name, brand, typeId));
    }
    @Override
    public CommentaireDto createCommentaire(CommentaireDto productDto){
        commentaireRepository.save(CommentaireAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public CommentaireDto deleteCommentaire(String id){
        CommentaireEntity productToDelete = commentaireRepository.findById(id);
        commentaireRepository.delete(productToDelete);
        return CommentaireAdapter.fromVoyagetToDto(productToDelete);
    }
    @Override
    public CommentaireDto updateCommentaire(CommentaireDto productDto){
        commentaireRepository.save(CommentaireAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public CommentaireDto getCommentaireById(String id){
        CommentaireEntity productToRetrieve = commentaireRepository.findById(id);
        return CommentaireAdapter.fromVoyagetToDto(productToRetrieve);
    }

}
