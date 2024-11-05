package com.schoolMicro.school_micro.controller;

import com.schoolMicro.school_micro.entity.School;
import com.schoolMicro.school_micro.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public String addSchool(@RequestBody School school) {
           boolean success = schoolService.addSchool(school);
           if (success) {
               return "School added successfully";
           } else {
               return "School not added";
           }
    }

    @GetMapping
    public List<School> fetchSchools() {
        return schoolService.fetchSchools();
    }

    @GetMapping("/{id}")
    public School fetchSchoolById(@PathVariable int id) {
        return schoolService.getSchoolById(id);
    }

}
