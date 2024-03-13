package com.exam.portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.portal.Model.Organization;
import com.exam.portal.Model.nodelOfficer;
import com.exam.portal.Repository.nodelOfficerRepository;

@Controller
public class NodalController {

	@Autowired
	nodelOfficerRepository nRepository;

	@GetMapping("/organiser/nodal")
	public String viewNodal(Model model) {
		List<nodelOfficer> nodal = nRepository.findAll();
		model.addAttribute("nodal", nodal);
		return "organiser/nodal/nodal_view";
	}

	@GetMapping("/organiser/nodalCreate")
	public String createNodal() {
		return "organiser/nodal/nodal_create";
	}

	@PostMapping("/organiser/nodal/register")
	public String registerNodal(@ModelAttribute nodelOfficer nodelOfficer) {
		// Save the organization to the database
		nRepository.save(nodelOfficer);
		// Redirect to a success page or return a success message
		return "organiser/nodal/nodal_view";
	}

}
