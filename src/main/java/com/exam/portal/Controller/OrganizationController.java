package com.exam.portal.Controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.portal.Model.Exam;
import com.exam.portal.Model.Organization;

import com.exam.portal.Repository.OrganizationRepository;

@Controller
public class OrganizationController {

	@Autowired
	OrganizationRepository repo;

	@GetMapping("/organiser/organization")
	public String showOrg(Model model) {
		List<Organization> org = repo.findAll();
		model.addAttribute("org", org);
		return "organiser/organization/org";
	}
	
	
	

	@GetMapping("/organiser/organization/new")
	public String newOrg() {
		return "organiser/organization/createOrg";
	}

	@PostMapping("/organiser/organization/register")
	public String registerOrganization(@ModelAttribute Organization organization) {
		// Save the organization to the database
		repo.save(organization);
		// Redirect to a success page or return a success message
		return "redirect:/organiser/organization/";
	}

//	 @GetMapping("/organiser/organization/view")
//	    public String viewExam(Model model){
//	        Organization org=repo.findByOrganizationId(9);
//	        System.out.println(org.getEmail_id());
//	       // model.addAttribute("org",org);
//	        return "organiser/organization/oview";
//	    }

	@GetMapping("/organiser/organization/view/{id}")
	public String viewOrganization(@PathVariable("id") Integer id, Model model) {
		Organization org = repo.findByOrganizationId(id);
		System.out.println(org);
		if (org != null) {
			model.addAttribute("org", org);
		} else {
			System.out.println("not shown view");
		}
		return "organiser/organization/oview";
	}
	
	
//	@PostMapping("/organiser/organization/edit")
//	public String editOrganization(@ModelAttribute("org") Organization org) {
//		// Handle organization edit logic here
//		// You can use the organization object passed from the form to update the
//		// organization details in the database
//		// For example:
//		Organization existingOrg = repo.findByOrganizationId(org.getOrganizationId());
//		if (existingOrg != null) {
//			existingOrg.setOrganization_name(org.getOrganization_name());
//			// Set other fields as needed
//			repo.save(existingOrg); // Save the updated organization
//		}
//		return "redirect:/organiser/organization/view/" + org.getOrganizationId();
//	}
	
}
