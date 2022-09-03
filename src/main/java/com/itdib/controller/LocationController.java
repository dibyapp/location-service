package com.itdib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itdib.service.ServerLocationService;

@RestController
public class LocationController {
	
	@Autowired
	ServerLocationService locationService;
	
	@GetMapping("/loc")
	public Object getLocation(@RequestParam("ip") String ip) {
		
		return locationService.getLocation(ip);
	}

}
