package it.objectmethod.school.repositories;

import it.objectmethod.school.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer> {

}