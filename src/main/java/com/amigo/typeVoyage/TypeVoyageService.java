package com.amigo.typeVoyage;

import java.util.List;

public interface TypeVoyageService {

	public List<TypeVoyageDTO> getListType();
    public TypeVoyageDTO createType(TypeVoyageDTO typeDTO);

    public TypeVoyageDTO deleteType(String id);
    public TypeVoyageDTO updateType(TypeVoyageDTO typeDTO);

    public TypeVoyageDTO getTypeById(String id);

}
