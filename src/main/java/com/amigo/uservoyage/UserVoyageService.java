package com.amigo.uservoyage;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
public interface UserVoyageService {
    public List<UserVoyageDto> getAllUserVoyages();
    public List<UserVoyageDto> getSelectedUserVoyage(String name, String brand, String typeId);

    public UserVoyageDto createUserVoyage(UserVoyageDto productDto);

    public UserVoyageDto deleteUserVoyage(String id);
    public UserVoyageDto updateUserVoyage(UserVoyageDto productDto);

    public UserVoyageDto getUserVoyageById(String id);
    public List<UserVoyageDto> getListUserVoyageByIdUser(String id);

}
