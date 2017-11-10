package com.amigo.user;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Created by oxeyo on 09/11/2017.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Res {
    @NotNull
    private String idUser;
    @NotNull
    private double price;

}
