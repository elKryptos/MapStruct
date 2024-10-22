package it.objectmethod.school.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "inscription")
@Data
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inscriptionId;
    private long registrationDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
