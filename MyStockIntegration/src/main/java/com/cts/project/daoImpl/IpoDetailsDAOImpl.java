package com.cts.project.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.bean.IpoDetails;
import com.cts.project.dao.IpoDetailsDAO;

@RestController
@CrossOrigin(origins = "*")
public class IpoDetailsDAOImpl {

	@Autowired
	IpoDetailsDAO ipoDetailsDAO;
	
	@GetMapping("/ipodetails")
	public List<IpoDetails> getAllIpo(){
		return ipoDetailsDAO.findAll();
	}
	
	@GetMapping("/ipodetails/{id}")
	public IpoDetails getIpoById(@PathVariable int id) {
		Optional<IpoDetails> ipoList=ipoDetailsDAO.findById(id);
		IpoDetails ipo=ipoList.get();
		return ipo;
	}
	
	@PostMapping("/ipodetails")
	public IpoDetails saveIpo(@RequestBody IpoDetails ipodetails) {
		IpoDetails newIpo=ipoDetailsDAO.save(ipodetails);
		return newIpo;
	}
	
	@DeleteMapping("/ipodetails/{id}")
	public void deleteIpo(@PathVariable int id) {
		ipoDetailsDAO.deleteById(id);
	}
	
	@PutMapping("/ipodetails")
	public IpoDetails updateIpo(@RequestBody IpoDetails ipodetails) {
		IpoDetails updateipo=ipoDetailsDAO.save(ipodetails);
		return updateipo;
		
	}
}
