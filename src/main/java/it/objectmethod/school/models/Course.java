package it.objectmethod.school.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Inscription> inscriptions;

}
