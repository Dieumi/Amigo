package com.amigo.typeVoyage.type;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeVoyageDTO {

	private String id;
	

	
	@NotNull
    @NotBlank
    private String idvoyage;
}