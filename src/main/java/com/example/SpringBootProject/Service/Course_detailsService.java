package com.example.SpringBootProject.Service;

import com.example.SpringBootProject.Module.Course_details;
import com.example.SpringBootProject.Repository.Course_detailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Course_detailsService {
    @Autowired
    private Course_detailsRepo courseDetailsRepo;

    public List<Course_details> getCourse(){
       return courseDetailsRepo.findAll();
    }
    public void insert(String course_name,String duration,Long course_cost) {
       courseDetailsRepo.save(new Course_details(course_name,duration,course_cost));
    }
    public void update(int id,String course_name,String duration,Long course_cost){
       courseDetailsRepo.updateCourse(id,course_name,duration,course_cost);
    }
}
