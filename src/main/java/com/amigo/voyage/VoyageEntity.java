package com.amigo.voyage;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by andrem on 23/03/2017.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="voyage")
public class VoyageEntity {
    @Id
    private String id;

    private String idUser;

    private int nbplace;

    private String depart;

    private String arrive;

    private String typeVoiture;
    private double price;
    private String note;
    private String date;
    private String heureDep;
    @Override
    public String toString() {
      /*  return String.format(
                "Product[id=%s, name='%s', brand='%s', typeId='%s', price='%f%n', imageURL='%s']",
                id, name, brand, typeId, price, imageURL);*/
      return null;

    }

}
