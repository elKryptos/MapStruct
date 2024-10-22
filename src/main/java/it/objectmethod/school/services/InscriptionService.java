package it.objectmethod.school.services;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.entities.Course;
import it.objectmethod.school.entities.Inscription;
import it.objectmethod.school.entities.Student;
import it.objectmethod.school.mappers.InscriptionMapper;
import it.objectmethod.school.repositories.CourseRepository;
import it.objectmethod.school.repositories.InscriptionRepository;
import it.objectmethod.school.repositories.StudentRepository;
import it.objectmethod.school.responses.ResponseWrapper;
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

    public ResponseWrapper<InscriptionDto> enrollStudent(InscriptionDto inscriptionDto) {
        Student student =studentRepository.findById(inscriptionDto.getStudentId()).orElse(null);
        if (student == null) {
            return new ResponseWrapper<>("Student not found");
        }
        Course course = courseRepository.findById(inscriptionDto.getCourseId()).orElse(null);
        if (course == null) {
            return new ResponseWrapper<>("Course not found");
        }
        Inscription inscription = inscriptionMapper.toEntity(inscriptionDto);
        inscription.setRegistrationDate(System.currentTimeMillis());
        inscription.setStudent(student);
        inscription.setCourse(course);
        inscriptionRepository.save(inscription);
        InscriptionDto savedInscriptionDto = inscriptionMapper.toDto(inscription);
        return new ResponseWrapper<>("Student enrolled", savedInscriptionDto);
    }

}
