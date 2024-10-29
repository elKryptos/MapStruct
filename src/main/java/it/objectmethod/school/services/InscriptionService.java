package it.objectmethod.school.services;

import it.objectmethod.school.models.dtos.InscriptionDto;
import it.objectmethod.school.models.entities.Course;
import it.objectmethod.school.models.entities.Inscription;
import it.objectmethod.school.models.entities.Student;
import it.objectmethod.school.repositories.CourseRepository;
import it.objectmethod.school.repositories.InscriptionRepository;
import it.objectmethod.school.repositories.StudentRepository;
import it.objectmethod.school.responses.InscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Inscription> getALlInscriptions() {
        return inscriptionRepository.findAll();
    }

    public InscriptionResponse enrollStudent(InscriptionDto inscriptionDto) {
        Optional<Student> optionalStudent = studentRepository.findById(inscriptionDto.getStudentId());
        if (!optionalStudent.isPresent()) {
            return new InscriptionResponse("Student not found");
        }
        Optional<Course> optionalCourse = courseRepository.findById(inscriptionDto.getCourseId());
        if (!optionalCourse.isPresent()) {
            return new InscriptionResponse("Course not found");
        }
        Inscription inscription = new Inscription();
        inscription.setStudent(optionalStudent.get());
        inscription.setCourse(optionalCourse.get());
        inscriptionRepository.save(inscription);
        return new InscriptionResponse("Student enrolled", inscriptionDto);
    }

}
