package com.amigo.Commentaire;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
public interface CommentaireService {
    public List<CommentaireDto> getAllCommentaire();
    public List<CommentaireDto> getSelectedCommentaire(String name, String brand, String typeId);

    public CommentaireDto createCommentaire(CommentaireDto productDto);

    public CommentaireDto deleteCommentaire(String id);
    public CommentaireDto updateCommentaire(CommentaireDto productDto);

    public CommentaireDto getCommentaireById(String id);
}
