package com.cts.project.sectorservice;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.sectorservice.feign.SectorAndUserDTO;


@Service
public class SectorServiceImpl implements SectorService{
	
	@Autowired
	SectorRepo sectorRepo;
	
	
	@Override
	public Sector addSector(Sector sector) {
		sectorRepo.save(sector);
	    return sector;
	}
	@Override
	public List<Sector> getAllSectors(){
		return sectorRepo.findAll();
	}
	@Override
	public void deleteSector(int id) {
		sectorRepo.deleteById(id);
	}
	@Override
	public Sector getSectorById(int id){
		Optional<Sector> sector=sectorRepo.findById(id);
		return sector.get();
	}
	@Override
	public Sector updateSector(Sector sector) {
		return sectorRepo.save(sector);
	}
	@Override
	public List<SectorAndUserDTO> getAllUsersWithSector() {
		List<Sector> sector=sectorRepo.findAll();
		List<SectorAndUserDTO> sector_dto=new ArrayList<SectorAndUserDTO>();
		for(Sector s: sector) {
			SectorAndUserDTO sectorDTO = new SectorAndUserDTO();
			BeanUtils.copyProperties(s, sectorDTO);
			sector_dto.add(sectorDTO);
		}	
		return sector_dto;
	}


}
