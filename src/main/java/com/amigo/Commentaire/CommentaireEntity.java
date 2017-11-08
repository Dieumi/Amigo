package com.amigo.Commentaire;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by andrem on 23/03/2017.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="commentaire")
public class CommentaireEntity {
    @Id
    private String id;

    private String idUser;


    private String message;



    @Override
    public String toString() {
      /*  return String.format(
                "Product[id=%s, name='%s', brand='%s', typeId='%s', price='%f%n', imageURL='%s']",
                id, name, brand, typeId, price, imageURL);*/
      return null;

    }

}
