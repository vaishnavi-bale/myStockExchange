package com.cts.project.sectorservice;

import java.util.List;

import com.cts.project.sectorservice.feign.SectorAndUserDTO;


public interface SectorService {
	
	public Sector addSector(Sector sector);
    public void deleteSector(int id);
    public Sector updateSector(Sector sector);
    public List<Sector> getAllSectors();
    public Sector getSectorById(int id);
    public List<SectorAndUserDTO> getAllUsersWithSector();

}
