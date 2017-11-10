package com.amigo.voyage;

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
public class Search {
    @NotNull
    private String depart;
    @NotNull
    private String arrive;
    @NotNull
    private String date;

    private String heureDep;
}
