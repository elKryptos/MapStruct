package it.objectmethod.school.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String name;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Inscription> inscriptions = new ArrayList<>();

}
