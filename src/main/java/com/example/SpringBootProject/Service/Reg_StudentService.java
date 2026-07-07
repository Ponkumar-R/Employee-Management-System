package com.example.SpringBootProject.Service;

import com.example.SpringBootProject.Module.Course_details;
import com.example.SpringBootProject.Module.Reg_Student;
import com.example.SpringBootProject.Repository.Course_detailsRepo;
import com.example.SpringBootProject.Repository.Reg_StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reg_StudentService {
    @Autowired
    private Reg_StudentRepo regStudentRepo;

    @Autowired
    private Course_detailsRepo courseDetailsRepo;

    public List<Reg_Student> getReg_Student() {
        return regStudentRepo.findAll();
    }

    public Boolean insert(String rollnumber, String name, String dept, String gender, Integer courseId) {
            Course_details course=courseDetailsRepo.findById(courseId).orElse(new Course_details("NON-Defined","NON-Defined",0L));
            Reg_Student regStudent=new Reg_Student();
            regStudent.setRollnumber(rollnumber);
            regStudent.setName(name);
            regStudent.setDept(dept);
            regStudent.setGender(gender);
            if(course.getCourse_name().equals("NON-Defined") && course.getDuration().equals("NON-Defined") && course.getCourse_cost()==0)return false;
            regStudent.setCourse_id(course.getId());
            regStudent.setCourse_name(course.getCourse_name());
            regStudent.setDuration(course.getDuration());
            regStudent.setCourse_cost(course.getCourse_cost());
            regStudentRepo.save(regStudent);
            return true;
    }

    public int update(String rollnumber, String name, String dept, String gender, int courseId) {
        return regStudentRepo.Update(rollnumber,name,dept,gender,courseId);
    }
}
