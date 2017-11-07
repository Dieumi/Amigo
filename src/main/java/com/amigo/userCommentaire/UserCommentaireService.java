package com.amigo.userCommentaire;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
public interface UserCommentaireService {
    public List<UserCommentaireDto> getAllUserCommentaire();
    public List<UserCommentaireDto> getSelectedUserCommentaire(String name, String brand, String typeId);

    public UserCommentaireDto createUserCommentaire(UserCommentaireDto productDto);

    public UserCommentaireDto deleteUserCommentaire(String id);
    public UserCommentaireDto updateUserCommentaire(UserCommentaireDto productDto);

    public UserCommentaireDto getUserCommentaireById(String id);
}
