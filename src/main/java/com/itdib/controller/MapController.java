package com.itdib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.itdib.service.ServerLocationService;

@Controller
public class MapController {

	@Autowired
	ServerLocationService locationService;

	@GetMapping("/getPages")
	public String getPages(Model model) {
		return "map";

	}

}