package it.objectmethod.school.services;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.mappers.InscriptionMapper;
import it.objectmethod.school.models.Course;
import it.objectmethod.school.models.Inscription;
import it.objectmethod.school.models.Student;
import it.objectmethod.school.repositories.CourseRepository;
import it.objectmethod.school.repositories.InscriptionRepository;
import it.objectmethod.school.repositories.StudentRepository;
import it.objectmethod.school.responses.InscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final InscriptionMapper inscriptionMapper;

    public List<InscriptionDto> getAllInscriptions() {
        List<Inscription> inscriptions = inscriptionRepository.findAll();
        return inscriptions.stream().map(inscriptionMapper::toDto).collect(Collectors.toList());
    }

//    public InscriptionResponse enrollStudent(InscriptionDto inscriptionDto) {
//        Optional<Student> optionalStudent = studentRepository.findById(inscriptionDto.getStudentId());
//        if (!optionalStudent.isPresent()) {
//            return new InscriptionResponse("Student not found");
//        }
//        Optional<Course> optionalCourse = courseRepository.findById(inscriptionDto.getCourseId());
//        if (!optionalCourse.isPresent()) {
//            return new InscriptionResponse("Course not found");
//        }
//        Inscription inscription = new Inscription();
//        inscription.setStudent(optionalStudent.get());
//        inscription.setCourse(optionalCourse.get());
//        inscriptionRepository.save(inscription);
//        return new InscriptionResponse("Student enrolled", inscriptionDto);
//    }

    public InscriptionResponse enrollStudent(InscriptionDto inscriptionDto) {
        Student student = studentRepository.findById(inscriptionDto.getStudentId()).orElse(null);
        if (student == null) {
            return new InscriptionResponse("Student not found");
        }
        Course course = courseRepository.findById(inscriptionDto.getCourseId()).orElse(null);
        if (course == null) {
            return new InscriptionResponse("Course not found");
        }
        Inscription inscription = inscriptionMapper.toEntity(inscriptionDto, student, course);
        inscriptionRepository.save(inscription);
        return new InscriptionResponse("Student enrolled", inscriptionDto);
    }

}
