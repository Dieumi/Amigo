package com.amigo.Commentaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrem on 23/03/2017.
 */
public class CommentaireAdapter {

    public static CommentaireDto fromVoyagetToDto(CommentaireEntity Commentaire){
        return CommentaireDto.builder()
                .id(Commentaire.getId())
                .idUser(Commentaire.getIdUser())
                .message(Commentaire.getMessage())
                .build();
    }

    public static CommentaireEntity fromDtoToVoyage(CommentaireDto CommentaireDto){
        return CommentaireEntity.builder()
                .id(CommentaireDto.getId())
                .idUser(CommentaireDto.getIdUser())
                .message(CommentaireDto.getMessage())
                .build();
    }

    public static List<CommentaireDto> fromProductListToDtoList(List<CommentaireEntity> CommentaireEntities){
        List<CommentaireDto> CommentaireDtoList = new ArrayList<CommentaireDto>();
        for(CommentaireEntity CommentaireEntitie : CommentaireEntities){
            CommentaireDtoList.add(fromVoyagetToDto(CommentaireEntitie));
        }
        return  CommentaireDtoList;
    }
}
