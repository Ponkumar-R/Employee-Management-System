package com.example.SpringBootProject.Controller;

import com.example.SpringBootProject.Module.Reg_Student;
import com.example.SpringBootProject.Service.Reg_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class Reg_StudentController {
    private final Reg_StudentService regStudentService;
    Reg_StudentController(Reg_StudentService regStudentService){
        this.regStudentService=regStudentService;
    }
    @GetMapping("/students")
    public ResponseEntity<?> getStudent(){
        List<Reg_Student> result=regStudentService.getReg_Student();
        return result!=null && !result.isEmpty()?ResponseEntity.ok(result):ResponseEntity.status(HttpStatus.NO_CONTENT).body("No One Student registered....");
    }

    @PostMapping("/new/student")
    public ResponseEntity<String> insert(@RequestParam String rollnumber,@RequestParam String name,@RequestParam String dept,@RequestParam String gender,@RequestParam int course_id){
        Boolean result=regStudentService.insert(rollnumber,name,dept,gender,course_id);
        return result?ResponseEntity.ok("Student Added...."):new ResponseEntity<>("No course Details in this ID!..",HttpStatus.NO_CONTENT);
    }
    @PutMapping("/new/student/{rollnumber}")
    public ResponseEntity<String>update(@PathVariable String rollnumber,@RequestParam String name,@RequestParam String dept,@RequestParam String gender,@RequestParam int course_id){
        int result=regStudentService.update(rollnumber,name,dept,gender,course_id);
        return result>0?new ResponseEntity<>("Update is success..",HttpStatus.OK):new ResponseEntity<>("No Update have error....",HttpStatus.NOT_FOUND);
    }
}
