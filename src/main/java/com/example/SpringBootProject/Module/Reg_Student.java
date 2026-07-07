package com.example.SpringBootProject.Module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reg_student")
public class Reg_Student {
    @Id
    private String rollnumber;

    private String name;
    private String dept;
    private String gender;

    private int course_id;
    private String course_name;
    private String duration;
    private Long course_cost;
}