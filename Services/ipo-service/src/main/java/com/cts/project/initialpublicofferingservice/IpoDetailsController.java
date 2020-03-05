package com.cts.project.initialpublicofferingservice;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class IpoDetailsController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    IpoService ipoService;
	
	@PostMapping("/ipodetails")
	public ResponseEntity<?> addIpo(@RequestBody IpoDetails ipo) {
		ipoService.saveIpo(ipo);
		return new ResponseEntity<IpoDetails>(ipo, HttpStatus.CREATED);
	}
	
	@PutMapping("/ipodetails")
	public ResponseEntity<?> updateIpo(@RequestBody IpoDetails ipo){
		ipoService.saveIpo(ipo);
		return new ResponseEntity<IpoDetails>(ipo, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/ipodetails/{id}")
	public void deleteIpo(@PathVariable int id) {
		ipoService.deleteIpo(id);
	}
	
	@GetMapping("/ipodetails/{id}")
	public ResponseEntity<?> getIpoWithId(@PathVariable int id){
		IpoDetails ipo=ipoService.getIpoById(id);
		if(ipo!=null) {
			return new ResponseEntity<IpoDetails>(ipo, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No Ipo with specified ID", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ipodetails")
	public ResponseEntity<?> getAllIpos(){
		List<IpoDetails> ipolist=ipoService.getAllIpo();
		if(ipolist.size()>0) {
			return new ResponseEntity<List<IpoDetails>>(ipolist, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No items in the list",HttpStatus.NOT_FOUND);
		}
	}
//	@Autowired
//	IpoDetailsRepo ipoDetailsRepo;
//	
//	@GetMapping("/ipodetails")
//	public List<IpoDetails> getAllIpo(){
//		return ipoDetailsRepo.findAll();
//	}
//	
//	@GetMapping("/ipodetails/{id}")
//	public IpoDetails getIpoById(@PathVariable int id) {
//		Optional<IpoDetails> ipoList=ipoDetailsRepo.findById(id);
//		IpoDetails ipo=ipoList.get();
//		return ipo;
//	}
//	
//	@PostMapping("/ipodetails")
//	public IpoDetails saveIpo(@RequestBody IpoDetails ipodetails) {
//		IpoDetails newIpo=ipoDetailsRepo.save(ipodetails);
//		return newIpo;
//	}
//	
//	@DeleteMapping("/ipodetails/{id}")
//	public void deleteIpo(@PathVariable int id) {
//		ipoDetailsRepo.deleteById(id);
//	}
//	
//	@PutMapping("/ipodetails")
//	public IpoDetails updateIpo(@RequestBody IpoDetails ipodetails) {
//		IpoDetails updateipo=ipoDetailsRepo.save(ipodetails);
//		return updateipo;
//		
//	}
}
