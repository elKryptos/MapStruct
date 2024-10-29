package it.objectmethod.school.models;

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

    @OneToMany(mappedBy = "student")
    private List<Inscription> inscriptions;

}
