package it.objectmethod.school.repositories;

import it.objectmethod.school.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findStudentByName(String name);

    List<Student> findStudentBySurname(String surname);

    List<Student> findStudentByNameAndSurname(String name, String surname);

    @Query(value = "SELECT * FROM student where name = :name;", nativeQuery = true)
    List<Student> byName(@Param(value = "name") String name);

    @Query(value = "SELECT * FROM student where surname = :surname", nativeQuery = true)
    List<Student> bySurname(String surname);

    @Query(value = "SELECT * FROM student where name = :name and surname = :surname", nativeQuery = true)
    List<Student> studentByNameAndSurname(String name, String surname);

    @Query(value = "SELECT s.name, s.surname, i.*\n" +
            "FROM student s\n" +
            "JOIN inscription i ON s.student_id = i.student_id\n" +
            "JOIN course c ON i.course_id = c.course_id\n" +
            "WHERE s.student_id = :studentId;", nativeQuery = true)
    List<Student> findStudentByInscriptionsAndCourse(int studentId);


}
