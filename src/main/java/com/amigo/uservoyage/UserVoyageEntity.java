package com.amigo.uservoyage;

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
@Document(collection="userVoyage")
public class UserVoyageEntity {
    @Id
    private String id;
    private String idVoyage;
    private String idUser;
    private double note;


    @Override
    public String toString() {
      /*  return String.format(
                "Product[id=%s, name='%s', brand='%s', typeId='%s', price='%f%n', imageURL='%s']",
                id, name, brand, typeId, price, imageURL);*/
      return null;

    }

}
