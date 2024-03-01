package com.exam.portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exam.portal.Model.Organization;
import com.exam.portal.Model.modules;
import com.exam.portal.Repository.moduleRepository;

@Controller
public class moduleController {
	@Autowired
	moduleRepository repo;
	
	
	
	
	@GetMapping("/organiser/module")
    public String showModules(Model model ){
	
		List<modules> m = repo.findAll();

		 model.addAttribute("m",m);
		
		
		return "organiser/organization/mview";
    }
	

}
