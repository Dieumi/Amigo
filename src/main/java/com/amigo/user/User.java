package com.amigo.user;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by Pierre on 11/03/2017.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document(collection="user")
public class User {

    @Id
    private String id;

    private String name;

    private String lastName;

    private String email;

    private String login;

    private String type;

    private double credit;

    private double note;

    private int nbvoyage;

}