package it.objectmethod.school.repositories;

import it.objectmethod.school.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student where name = :name;", nativeQuery = true)
    List<Student> findStudentByName(String name);
    @Query(value = "select * from student where surname = :surname", nativeQuery = true)
    List<Student> findStudentBySurname(String surname);
    @Query(value = "select * from student where name = :name and surname = :surname", nativeQuery = true)
    List<Student> findStudentByNameAndSurname(String name, String surname);
}
