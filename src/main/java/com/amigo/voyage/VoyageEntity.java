package com.amigo.voyage;

import lombok.*;

import javax.persistence.Id;

/**
 * Created by andrem on 23/03/2017.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VoyageEntity {
    @Id
    private String id;

    private String idUser;

    private int nbplace;

    private String depart;

    private String arrive;

    private String typeVoiture;
    private double price;
    private double note;

    @Override
    public String toString() {
      /*  return String.format(
                "Product[id=%s, name='%s', brand='%s', typeId='%s', price='%f%n', imageURL='%s']",
                id, name, brand, typeId, price, imageURL);*/
      return null;

    }

}
