package com.mohanty.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohanty.date.CustomDateClass;
import com.mohanty.exception.StudentErrorResponse;
import com.mohanty.exception.StudentNotFoundException;
import com.mohanty.model.Address;
import com.mohanty.model.Student;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

	private List<Student> stulist;

	@PostConstruct
	public void loadData() {
		stulist = new ArrayList<Student>();
		Address add1 = new Address("Church Street", "Bangalore", "Karnataka", "560066", "India");
		String[] languages = (String[]) Arrays.asList("English", "Bengali", "Odia").toArray();
		Student stu = new Student(1, "Ashutosh", "Mohanty", true, add1, languages);
		stulist.add(stu);
	}

	@GetMapping(value = "/getAllStudents")
	public List<Student> getAllStudents() {
		return stulist;

	}

	@GetMapping(value = "/getStudentsById/{Id}")
	public Student getStudentsById(@PathVariable int Id) {

		if (Id > stulist.size() || Id < 0)
			throw new StudentNotFoundException("Student Id is not valid:" + Id);

		return stulist.get(Id);
	}

}
