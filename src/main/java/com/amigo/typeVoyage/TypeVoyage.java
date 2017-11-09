package com.amigo.typeVoyage;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document(collection="typeVoyage")

public class TypeVoyage {

	@Id
	private String id;
	
	private String idvoyage;
	

	
	
}
