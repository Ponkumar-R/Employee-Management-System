package com.example.SpringBootProject.Module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course_details")
public class Course_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String course_name;
    private String duration;
    private Long course_cost;

    public Course_details(String courseName, String duration, Long courseCost) {
        this.course_name = courseName;
        this.duration = duration;
        this.course_cost = courseCost;
    }
}