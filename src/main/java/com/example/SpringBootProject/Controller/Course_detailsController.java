package com.example.SpringBootProject.Controller;

import com.example.SpringBootProject.Module.Course_details;
import com.example.SpringBootProject.Service.Course_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class Course_detailsController {
    @Autowired
    private Course_detailsService courseDetailsService;

    @GetMapping("/courseDetails")
    public ResponseEntity<?> getCourse(){
        List<Course_details> result= courseDetailsService.getCourse();
        return result!=null && !result.isEmpty()?ResponseEntity.ok(result):ResponseEntity.status(HttpStatus.NO_CONTENT).body("Our course Details is Empty!");
    }
    @PostMapping("/new/course")
    public ResponseEntity<String> insert(@RequestParam String course_name,@RequestParam String duration,@RequestParam Long course_cost){
        courseDetailsService.insert(course_name,duration,course_cost);
        return ResponseEntity.ok("Added....👍");
    }
    @PutMapping("/new/course/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestParam String course_name, @RequestParam String duration, @RequestParam Long course_cost){
        courseDetailsService.update(id,course_name,duration,course_cost);
        return ResponseEntity.ok("Updated...");
    }
}
