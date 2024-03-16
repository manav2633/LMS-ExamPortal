package com.exam.portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.portal.Model.Organization;
import com.exam.portal.Model.course;

import com.exam.portal.Repository.courseRepository;

@Controller
public class CourseController {

	@Autowired
    courseRepository repo;

	@GetMapping("/organiser/user")
	public String viewUser(){
		return "organiser/abc/abc";
	}
	
	@GetMapping("/organiser/course")
	public String viewNodal(Model model) {

		List<String> categories = repo.findDistinctCourseCategory();
		model.addAttribute("categories", categories);
			List<course> course = repo.findAll();
		model.addAttribute("course", course);
		
		return "organiser/course/cview";
	}

	@GetMapping("/organiser/cour")
    public String viewCourseByCategory(Model model, @RequestParam(required = false) String category) {
		List<String> categories = repo.findDistinctCourseCategory();
		model.addAttribute("categories", categories);
        List<course> course;
        if (category != null && !category.isEmpty()) {
            course = repo.findByCourseCategory(category);
        } else {
            course = repo.findAll();
        }
        model.addAttribute("course", course);
        return "organiser/course/cview";
    }

	@GetMapping("/organiser/course/new")
	public String newCourse(Model model) {
		List<String> categories = repo.findDistinctCourseCategory();
		model.addAttribute("categories", categories);
		return "organiser/course/courseCreate";
	}
}
