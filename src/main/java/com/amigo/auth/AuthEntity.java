package com.amigo.auth;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by iPlowPlow on 10/03/2017.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="auth")
public class AuthEntity {
    @Id
    private String id;

    private String login;

    private String pwd;

}
