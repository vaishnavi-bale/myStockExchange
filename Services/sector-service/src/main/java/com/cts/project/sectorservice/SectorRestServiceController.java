package com.cts.project.sectorservice;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.sectorservice.feign.SectorAndUserDTO;
import com.cts.project.sectorservice.feign.UserServiceProxy;


@RestController
@CrossOrigin(origins="*")
public class SectorRestServiceController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserServiceProxy proxy;
	
	@Autowired
	SectorRepo sectorRepo;
	
	@Autowired
	SectorService sectorService;
	
	@GetMapping(value="/sector",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Sector> findAll(){
		return sectorService.getAllSectors();
	}
	@GetMapping(value="/sector/{id}")
	public ResponseEntity<?> findone(@PathVariable int id){
		Sector sector=sectorService.getSectorById(id);
		return new ResponseEntity<Sector>(sector, HttpStatus.OK);
	}
	@RequestMapping(value="/sector", method= RequestMethod.POST)
	public Sector save(@RequestBody Sector sector){
		Sector sec = sectorService.addSector(sector);
		return sec;
	}
	@RequestMapping(value="/sector/{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable int id){
		sectorService.deleteSector(id);
	}
	@RequestMapping(value = "/sector", method = RequestMethod.PUT)
	public Sector update(@RequestBody Sector sector) {
		Sector sect = sectorService.updateSector(sector);
		return sect;
	}
	
	@GetMapping("/sector")
	public List<SectorAndUserDTO> getSectorAndUser(){
		return sectorService.getAllUsersWithSector();
	}
	@GetMapping("/users-by-sector")
	public ResponseEntity<?> getAllUsersBySector() {
//		List<Sector> sector=sectorService.getAllSectors();
//		List<SectorAndUserDTO> sector_dto=proxy.getUsers();
//		for(Sector s: sector) {
//			SectorAndUserDTO sectorDTO = new SectorAndUserDTO();
//			BeanUtils.copyProperties(s, sectorDTO);
//			sector_dto.add(sectorDTO);
//		}	
//		return sector_dto;
		logger.info("Get All users Invoked.....");
		ResponseEntity<?> users=proxy.getUsers();
		logger.info("Information-->{}",users);
		return proxy.getUsers();
	}
	
//	@GetMapping("/user-with-sector")
//	public List<SectorAndUserDTO> getAllUser(){
//		return proxy.getSectorAndUser();
//	}
}
