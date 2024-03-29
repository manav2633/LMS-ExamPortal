package com.exam.portal.Controller;

import com.exam.portal.OrganiserDetails;
import com.exam.portal.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.portal.Model.Exam;
import com.exam.portal.Model.Organiser;
import com.exam.portal.Repository.OrganiserRepository;
import com.exam.portal.Repository.OrganizationRepository;

@Controller
public class OrganiserController {

	@Autowired
	OrganiserRepository repo;

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	OrganizationRepository orgrepo;
	
	

	public static String LOGIN_ROUTE="redirect:/organiser/login";

	@GetMapping("organiser/register")
	public String register(Model model) {
		model.addAttribute("organiser",new Organiser());
		return "organiser/register";
	}
	 
	
	
	
	@PostMapping("organiser/register")
	public String registerPost(Organiser org) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword=encoder.encode(org.getPassword());
		org.setPassword(encodedPassword);
		repo.save(org);
		return "redirect:/organiser/dashboard";
	}
	
	@GetMapping("organiser/login")
	public String login() {
		Object user= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof OrganiserDetails){
			return "redirect:/organiser/dashboard";
		}
		return "redirect:/login";
	}
	
	@GetMapping("organiser/dashboard")
	public String dashboard(Model model) {
		int examcount=0;
		Object user=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof OrganiserDetails){
			Organiser org = ((OrganiserDetails) user).getOrg();
			      
			examcount = examRepository.findByOrganiserId(org.getId()).size();
		}
		long organizationCount = orgrepo.count();
		// Add the organization count to the model
        model.addAttribute("organizationCount", organizationCount);
		model.addAttribute("examcount",examcount);
		return "organiser/dashboard";
	}
}
