package it.objectmethod.school.repositories;

import it.objectmethod.school.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer> {

    Optional<Course> findCourseByName (String name);
}
