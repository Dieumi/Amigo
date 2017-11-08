package com.amigo.ville;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
public interface VilleService {
    public List<VilleDto> getAllVille();
    public List<VilleDto> getSelectedVille(String name, String brand, String typeId);

    public VilleDto createVille(VilleDto productDto);

    public VilleDto deleteVille(String id);
    public VilleDto updateVille(VilleDto productDto);

    public VilleDto getVilleById(String id);
}
