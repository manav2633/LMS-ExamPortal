package com.exam.portal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramController {

	@GetMapping("/organiser/program")
	public String viewNodal() {
		return "organiser/program/program_view";
	}

	@GetMapping("/organiser/programCreate")
	public String createNodal() {
		return "organiser/program/program_create";
	}

}
