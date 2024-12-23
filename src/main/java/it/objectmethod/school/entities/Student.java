package it.objectmethod.school.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Inscription> inscriptions;

}
