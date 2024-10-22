package it.objectmethod.school.repositories;

import it.objectmethod.school.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
