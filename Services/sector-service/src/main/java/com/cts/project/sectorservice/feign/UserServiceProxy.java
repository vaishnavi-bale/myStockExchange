package com.cts.project.sectorservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient("user-service")
//@FeignClient(name="",url="http://localhost:8000")
@FeignClient("netflix-zuul-api-gateway-server")
public interface UserServiceProxy {
	
	@GetMapping("/user-service/user")
	public ResponseEntity<?> getUsers() ;

//	@GetMapping("/sector")
//	public List<SectorAndUserDTO> getSectorAndUser();
}
