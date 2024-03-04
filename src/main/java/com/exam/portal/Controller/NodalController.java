package com.exam.portal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NodalController {
	@GetMapping("/organiser/nodal")
	public String viewNodal() {
		return "organiser/nodal/nodal_view";
	}
	
	@GetMapping("/organiser/nodalCreate")
	public String createNodal() {
		return "organiser/nodal/nodal_create";
	}

}
