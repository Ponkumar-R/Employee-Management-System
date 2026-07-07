package com.example.SpringBootProject.Repository;

import com.example.SpringBootProject.Module.Reg_Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Reg_StudentRepo extends JpaRepository<Reg_Student,String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE reg_student set name=:name,dept=:dept,gender=:gender,course_id=:courseId where rollnumber=:rollnumber",nativeQuery = true)
    int Update(@Param("rollnumber")String rollnumber,@Param("name") String name,@Param("dept") String dept,@Param("gender") String gender,@Param("courseId") int courseId);
}
