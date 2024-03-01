package com.exam.portal.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.exam.portal.Model.Organization;
import com.exam.portal.Model.Topic;
import com.exam.portal.Repository.topicRepository;


@Controller
public class topicController {
	@Autowired
	topicRepository repo;
	
	
	@GetMapping("/organiser/topic")
	public String showTopic(Model model) {
		
		List<Topic> org = repo.findAll();
	model.addAttribute("topics", org);
		return "organiser/topic/tlist";	
	}
	
	@GetMapping("/organiser/newtopic")
	public String newTopic() {
		return "organiser/topic/Topic";	
	}
	
	 @PostMapping("/upload")
	    public String saveUser(Topic topic,BindingResult result,
				Model model,          
	            @RequestParam("files") MultipartFile multipartFile1
	           ) throws IOException {
	       try {  
	    	       	  
	    //    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	         String fileName1 = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
	       
	         topic.setPdfFile(fileName1);
	         
	         repo.save(topic);
	         
	       
	        String uploadDir1 = "user-files/" ;
     
	        FileUploadUtil.saveFile(uploadDir1, fileName1, multipartFile1);
	        
	    	model.addAttribute("topic", new Topic());
			//session.setAttribute("message", new Message("Succesfully Registered !!!!","alert-success"));
			   
	        return "organiser/topic/tlist";
	       }
	       catch (Exception e) {
			
	    	   e.printStackTrace();
				model.addAttribute("user", topic);
			//	session.setAttribute("message", new Message("something went wrong   " + e.getMessage(), "alert-danger"));
				return "organiser/organization";
		}
	    }

}
