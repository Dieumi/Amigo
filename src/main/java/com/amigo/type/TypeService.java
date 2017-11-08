package com.amigo.type;

import java.util.List;

import com.amigo.user.UserDTO;

public interface TypeService {

	public List<TypeDTO> getListType();
    public TypeDTO createType(TypeDTO typeDTO);

    public TypeDTO deleteType(String id);
    public TypeDTO updateType(TypeDTO typeDTO);

    public TypeDTO getTypeById(String id);

}
