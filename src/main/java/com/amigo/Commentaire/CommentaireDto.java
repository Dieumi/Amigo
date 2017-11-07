package com.amigo.Commentaire;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Created by andrem on 23/03/2017.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CommentaireDto {

    private String id;
    @NotNull
    private String idUser;

    @NotNull
    private String message;

    public CommentaireDto(String idUser, int nbplace, String depart, String arrive, String typeVoiture){
       /* this.name = name;
        this.brand = brand;
        this.typeId = typeId;
        this.price = price;
        this.imageURL = imageURL;*/
    }
}
